package com.tracebucket.x.terminal.api.service;

import com.tracebucket.tron.ddd.domain.AggregateId;
import com.tracebucket.x.terminal.api.domain.Position;
import com.tracebucket.x.terminal.api.domain.Terminal;

import java.util.List;

/**
 * Created by sadath on 18-May-15.
 */
public interface TerminalService {
    public Terminal save(Terminal terminal);
    public Terminal findOne(AggregateId aggregateId);
    public List<Terminal> findAll();
    public boolean delete(AggregateId terminalAggregateId);
    public Terminal placePosition(Position position, AggregateId terminalAggregateId);
}