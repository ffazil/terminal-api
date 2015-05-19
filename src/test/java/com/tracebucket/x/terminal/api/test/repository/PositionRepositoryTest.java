package com.tracebucket.x.terminal.api.test.repository;

import com.tracebucket.x.terminal.api.TerminalApiStarter;
import com.tracebucket.x.terminal.api.domain.Position;
import com.tracebucket.x.terminal.api.repository.jpa.PositionRepository;
import com.tracebucket.x.terminal.api.test.fixture.PositionFixture;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * Created by sadath on 19-May-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TerminalApiStarter.class})
@WebIntegrationTest
@Transactional
public class PositionRepositoryTest {
    @Autowired
    private PositionRepository positionRepository;

    private Position position = null;

    private void createPosition() throws Exception{
        position = PositionFixture.standardPosition();
        position = positionRepository.save(position);
    }

    @Test
    @Rollback(value = false)
    public void testCreate() throws Exception{
        createPosition();
        Assert.assertNotNull(position.getEntityId());
    }

    @Test
    @Rollback(value = false)
    public void testUpdate() throws Exception {
        createPosition();
        Assert.assertNotNull(position.getEntityId());
    }

    @Test
    @Rollback(value = false)
    public void testFindById() throws Exception {
        createPosition();
        position = positionRepository.findOne(position.getEntityId());
        Assert.assertNotNull(position);
    }

    @After
    public void tearDown(){
        if(position != null && position.getEntityId() != null) {
            positionRepository.delete(position.getEntityId());
            position = positionRepository.findOne(position.getEntityId());
            Assert.assertNull(position);
        }
    }
}