package com.tracebucket.x.terminal.api.rest.assembler.resource;

import com.tracebucket.tron.assembler.AssemblerResolver;
import com.tracebucket.tron.assembler.ResourceAssembler;
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
public class TerminalResourceAssembler extends ResourceAssembler<TerminalResource, Terminal> {

    @Autowired
    private AssemblerResolver assemblerResolver;

    @Override
    public TerminalResource toResource(Terminal entity, Class<TerminalResource> resourceClass) {
        TerminalResource terminal = null;
        try {
            terminal = resourceClass.newInstance();
            if (entity != null) {
                terminal.setUid(entity.getAggregateId().getAggregateId());
                terminal.setName(entity.getName());
                terminal.setPassive(entity.isPassive());
                terminal.setName(entity.getName());
                terminal.setMacId(entity.getMacId());
                terminal.setId(entity.getId());
                terminal.setPosition(assemblerResolver.resolveResourceAssembler(PositionResource.class, Position.class).toResource(entity.getPosition(), PositionResource.class));
            }
        } catch (InstantiationException ie) {

        } catch (IllegalAccessException iae) {

        }
        return terminal;
    }

    @Override
    public Set<TerminalResource> toResources(Collection<Terminal> entities, Class<TerminalResource> resourceClass) {
        Set<TerminalResource> terminals = new HashSet<TerminalResource>();
        if(entities != null && entities.size() > 0) {
            Iterator<Terminal> iterator = entities.iterator();
            if(iterator.hasNext()) {
                Terminal group = iterator.next();
                terminals.add(toResource(group, TerminalResource.class));
            }
        }
        return terminals;
    }
}