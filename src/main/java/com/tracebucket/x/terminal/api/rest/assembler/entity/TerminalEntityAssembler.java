package com.tracebucket.x.terminal.api.rest.assembler.entity;

import com.tracebucket.tron.assembler.AssemblerResolver;
import com.tracebucket.tron.assembler.EntityAssembler;
import com.tracebucket.tron.ddd.domain.AggregateId;
import com.tracebucket.x.terminal.api.domain.Position;
import com.tracebucket.x.terminal.api.domain.Terminal;
import com.tracebucket.x.terminal.api.rest.resource.PositionResource;
import com.tracebucket.x.terminal.api.rest.resource.TerminalResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sadath on 19-May-15.
 */
@Component
public class TerminalEntityAssembler extends EntityAssembler<Terminal, TerminalResource> {

    @Autowired
    private AssemblerResolver assemblerResolver;

    @Override
    public Terminal toEntity(TerminalResource resource, Class<Terminal> entityClass) {
        Terminal terminal = null;
        if(resource != null) {
            terminal = new Terminal(resource.getName(), resource.getId(), resource.getMacId());
            terminal.place(assemblerResolver.resolveEntityAssembler(Position.class, PositionResource.class).toEntity(resource.getPosition(), Position.class));
            if (resource.getUid() != null) {
                terminal.setAggregateId(new AggregateId(resource.getUid()));
            }
        }
        return terminal;
    }

    @Override
    public Set<Terminal> toEntities(Collection<TerminalResource> resources, Class<Terminal> entityClass) {
        Set<Terminal> terminals = new HashSet<Terminal>();
        if(resources != null) {
            Iterator<TerminalResource> iterator = resources.iterator();
            if(iterator.hasNext()) {
                TerminalResource terminalResource = iterator.next();
                terminals.add(toEntity(terminalResource, Terminal.class));
            }
        }
        return terminals;
    }
}