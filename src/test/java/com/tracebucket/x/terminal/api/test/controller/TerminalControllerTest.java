package com.tracebucket.x.terminal.api.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracebucket.x.terminal.api.TerminalApiStarter;
import com.tracebucket.x.terminal.api.rest.resource.PositionResource;
import com.tracebucket.x.terminal.api.rest.resource.TerminalResource;
import com.tracebucket.x.terminal.api.test.fixture.PositionResourceFixture;
import com.tracebucket.x.terminal.api.test.fixture.TerminalResourceFixture;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by sadath on 19-May-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TerminalApiStarter.class})
@WebIntegrationTest
public class TerminalControllerTest {
    private static final Logger log = LoggerFactory.getLogger(TerminalControllerTest.class);

    private RestTemplate restTemplate = null;

    @Value("http://localhost:${server.port}${server.contextPath}")
    private String basePath;

    @Autowired
    private ObjectMapper objectMapper;

    private TerminalResource terminal = null;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    private void createTerminal() throws Exception{
        terminal = TerminalResourceFixture.standardTerminal();
        log.info("Create Terminal : " + objectMapper.writeValueAsString(terminal));
        terminal = restTemplate.postForObject(basePath+"/terminal", terminal, TerminalResource.class);
        log.info("Created Terminal : " + objectMapper.writeValueAsString(terminal));
        Assert.assertNotNull(terminal);
    }

    @Test
    public void testCreate() throws Exception {
        createTerminal();
        Assert.assertNotNull(terminal.getUid());
    }

    @Test
    public void testPlacePosition() throws Exception{
        createTerminal();
        PositionResource positionResource = PositionResourceFixture.standardPosition();
        restTemplate.put(basePath+"/terminal/" + terminal.getUid() + "/position", positionResource);
        terminal = restTemplate.getForObject(basePath + "/terminal/" + terminal.getUid(), TerminalResource.class);
        Assert.assertNotNull(terminal);
        Assert.assertNotNull(terminal.getUid());
        Assert.assertNotNull(terminal.getPosition());
        Assert.assertNotNull(terminal.getPosition().getUid());
    }

    @Test
    public void testFindOne() throws Exception {
        createTerminal();
        String uid = terminal.getUid();
        log.info("Find Terminal with UID : " + terminal.getUid());
        terminal = restTemplate.getForObject(basePath + "/terminal/" + uid, TerminalResource.class);
        Assert.assertNotNull(terminal);
        Assert.assertNotNull(terminal.getUid());
        Assert.assertEquals(uid, terminal.getUid());
        log.info("Found : " + objectMapper.writeValueAsString(terminal));
    }

    @Test
    public void testFindAll() throws Exception {
        createTerminal();
        TerminalResource[] terminal = restTemplate.getForObject(basePath + "/terminals/", TerminalResource[].class);
        Assert.assertNotNull(terminal);
        Assert.assertTrue(terminal.length > 0);
    }

    @After
    public void tearDown() throws Exception{
        if(terminal != null && terminal.getUid() != null) {
            restTemplate.delete(basePath + "/terminal/" + terminal.getUid());
            try {
                restTemplate.getForEntity(new URI(basePath + "/terminal/" + terminal.getUid()), TerminalResource.class);
            } catch (HttpClientErrorException httpClientErrorException) {
                Assert.assertEquals(HttpStatus.NOT_FOUND, httpClientErrorException.getStatusCode());
            }
        }
    }
}