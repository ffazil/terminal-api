package com.tracebucket.x.terminal.api.test.service;

import com.tracebucket.x.terminal.api.TerminalApiStarter;
import com.tracebucket.x.terminal.api.domain.Position;
import com.tracebucket.x.terminal.api.domain.Terminal;
import com.tracebucket.x.terminal.api.service.TerminalService;
import com.tracebucket.x.terminal.api.test.fixture.PositionFixture;
import com.tracebucket.x.terminal.api.test.fixture.TerminalFixture;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by sadath on 19-May-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TerminalApiStarter.class})
@WebIntegrationTest
public class TerminalServiceTest {
    @Autowired
    private TerminalService terminalService;

    private Terminal terminal = null;

    @Before
    public void setUp() throws Exception{

    }

    private void createTerminal() throws Exception{
        terminal = TerminalFixture.standardTerminal();
        terminal = terminalService.save(terminal);
    }

    @Test
    public void testCreate() throws Exception {
        createTerminal();
        Assert.assertNotNull(terminal.getAggregateId());
    }

    @Test
    public void testPlacePosition() throws Exception {
        createTerminal();
        Position position = PositionFixture.standardPosition();
        terminal = terminalService.placePosition(position, terminal.getAggregateId());
        Assert.assertNotNull(terminal);
        Assert.assertNotNull(terminal.getAggregateId());
        Assert.assertNotNull(terminal.getPosition());
        Assert.assertNotNull(terminal.getPosition().getEntityId());
    }

    @Test
    public void testFindById() throws Exception {
        createTerminal();
        terminal = terminalService.findOne(terminal.getAggregateId());
        Assert.assertNotNull(terminal);
    }

    @Test
    public void testFindAll() throws Exception {
        createTerminal();
        List<Terminal> terminals = terminalService.findAll();
        Assert.assertNotNull(terminals);
        Assert.assertTrue(terminals.size() > 0);
    }

    @After
    public void tearDown(){
        if(terminal != null && terminal.getAggregateId() != null) {
            terminalService.delete(terminal.getAggregateId());
            terminal = terminalService.findOne(terminal.getAggregateId());
            Assert.assertNull(terminal);
        }
    }
}