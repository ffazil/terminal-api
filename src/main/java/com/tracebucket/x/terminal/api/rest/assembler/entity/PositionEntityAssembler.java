package com.tracebucket.x.terminal.api.rest.assembler.entity;

import com.tracebucket.tron.assembler.EntityAssembler;
import com.tracebucket.tron.ddd.domain.EntityId;
import com.tracebucket.x.terminal.api.domain.Position;
import com.tracebucket.x.terminal.api.domain.PositionType;
import com.tracebucket.x.terminal.api.rest.resource.PositionResource;
import com.tracebucket.x.terminal.api.rest.resource.PositionTypeResource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sadath on 19-May-15.
 */
@Component
public class PositionEntityAssembler extends EntityAssembler<Position, PositionResource> {

    @Override
    public Position toEntity(PositionResource resource, Class<Position> entityClass) {
        Position position = null;
        if(resource != null) {
            PositionTypeResource positionType = resource.getPositionType() != null ? resource.getPositionType() : null;
            position = new Position(resource.getName(), positionType != null ? new PositionType(positionType.getType() != null ? positionType.getType() : null) : null, resource.getCode(), resource.getSelection());
            position.assign(resource.getOrganization());
            position.addEmployee(resource.getEmployee());
            if (resource.getUid() != null) {
                position.setEntityId(new EntityId(resource.getUid()));
            }
        }
        return position;
    }

    @Override
    public Set<Position> toEntities(Collection<PositionResource> resources, Class<Position> entityClass) {
        Set<Position> positions = new HashSet<Position>();
        if(resources != null) {
            Iterator<PositionResource> iterator = resources.iterator();
            if(iterator.hasNext()) {
                PositionResource positionResource = iterator.next();
                positions.add(toEntity(positionResource, Position.class));
            }
        }
        return positions;
    }
}