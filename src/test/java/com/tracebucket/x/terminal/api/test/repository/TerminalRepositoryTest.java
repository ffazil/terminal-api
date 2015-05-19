package com.tracebucket.x.terminal.api.test.repository;

import com.tracebucket.x.terminal.api.TerminalApiStarter;
import com.tracebucket.x.terminal.api.domain.Terminal;
import com.tracebucket.x.terminal.api.repository.jpa.TerminalRepository;
import com.tracebucket.x.terminal.api.test.fixture.PositionFixture;
import com.tracebucket.x.terminal.api.test.fixture.TerminalFixture;
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
public class TerminalRepositoryTest {

    @Autowired
    private TerminalRepository terminalRepository;

    private Terminal terminal = null;

    private void createTerminal() throws Exception{
        terminal = TerminalFixture.standardTerminal();
        terminal = terminalRepository.save(terminal);
    }

    @Test
    @Rollback(value = false)
    public void testCreate() throws Exception{
        createTerminal();
        Assert.assertNotNull(terminal.getAggregateId());
    }

    @Test
    @Rollback(value = false)
    public void testUpdate() throws Exception {
        createTerminal();
        terminal.place(PositionFixture.standardPosition());
        terminal = terminalRepository.save(terminal);
        Assert.assertNotNull(terminal);
        Assert.assertNotNull(terminal.getAggregateId());
        Assert.assertNotNull(terminal.getPosition());
        Assert.assertNotNull(terminal.getPosition().getEntityId());
    }

    @Test
    @Rollback(value = false)
    public void testFindById() throws Exception {
        createTerminal();
        terminal = terminalRepository.findOne(terminal.getAggregateId());
        Assert.assertNotNull(terminal);
    }

    @After
    public void tearDown(){
        if(terminal != null && terminal.getAggregateId() != null) {
            terminalRepository.delete(terminal.getAggregateId());
            terminal = terminalRepository.findOne(terminal.getAggregateId());
            Assert.assertNull(terminal);
        }
    }

}