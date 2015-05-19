package com.tracebucket.x.terminal.api.repository.jpa;

import com.tracebucket.tron.ddd.domain.AggregateId;
import com.tracebucket.tron.ddd.jpa.BaseAggregateRepository;
import com.tracebucket.x.terminal.api.domain.Terminal;

/**
 * Created by sadath on 18-May-15.
 */
public interface TerminalRepository extends BaseAggregateRepository<Terminal, AggregateId> {
}