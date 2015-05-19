package com.tracebucket.x.terminal.api.service.impl;

import com.tracebucket.tron.ddd.annotation.PersistChanges;
import com.tracebucket.tron.ddd.domain.AggregateId;
import com.tracebucket.x.terminal.api.domain.Position;
import com.tracebucket.x.terminal.api.domain.Terminal;
import com.tracebucket.x.terminal.api.repository.jpa.PositionRepository;
import com.tracebucket.x.terminal.api.repository.jpa.TerminalRepository;
import com.tracebucket.x.terminal.api.service.TerminalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sadath on 18-May-15.
 */
@Service
@Transactional
public class TerminalServiceImpl implements TerminalService {
    private static Logger log = LoggerFactory.getLogger(TerminalServiceImpl.class);

    @Autowired
    private TerminalRepository terminalRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Terminal save(Terminal terminal) {
        return terminalRepository.save(terminal);
    }

    @Override
    public Terminal findOne(AggregateId aggregateId) {
        terminalRepository.flush();
        return terminalRepository.findOne(aggregateId);
    }

    @Override
    public List<Terminal> findAll() {
        terminalRepository.flush();
        return terminalRepository.findAll();
    }

    @Override
    public boolean delete(AggregateId terminalAggregateId) {
        Terminal terminal = terminalRepository.findOne(terminalAggregateId);
        if(terminal != null) {
            terminalRepository.delete(terminal);
            return terminalRepository.findOne(terminalAggregateId) == null ? true : false;
        }
        return false;
    }

    @Override
    @PersistChanges(repository = "terminalRepository")
    public Terminal placePosition(Position position, AggregateId terminalAggregateId) {
        Terminal terminal = terminalRepository.findOne(terminalAggregateId);
        position = positionRepository.save(position);
        if(terminal != null) {
            terminal.place(position);
            return terminal;
        }
        return null;
    }
}