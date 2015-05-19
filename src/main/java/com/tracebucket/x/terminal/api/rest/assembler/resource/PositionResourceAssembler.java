package com.tracebucket.x.terminal.api.rest.assembler.resource;

import com.tracebucket.tron.assembler.ResourceAssembler;
import com.tracebucket.x.terminal.api.domain.Position;
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
public class PositionResourceAssembler extends ResourceAssembler<PositionResource, Position> {

    @Override
    public PositionResource toResource(Position entity, Class<PositionResource> resourceClass) {
        PositionResource position = null;
        try {
            position = resourceClass.newInstance();
            if (entity != null) {
                position.setUid(entity.getEntityId().getId());
                position.setPassive(entity.isPassive());
                position.setSelection(entity.getSelection());
                position.setCode(entity.getCode());
                position.setName(entity.getName());
                position.setOrganization(entity.getOrganization());
                position.setEmployee(entity.getEmployee());
                position.setPositionType(new PositionTypeResource(entity.getPositionType().getType()));
            }
        } catch (InstantiationException ie) {

        } catch (IllegalAccessException iae) {

        }
        return position;
    }

    @Override
    public Set<PositionResource> toResources(Collection<Position> entities, Class<PositionResource> resourceClass) {
        Set<PositionResource> positions = new HashSet<PositionResource>();
        if(entities != null && entities.size() > 0) {
            Iterator<Position> iterator = entities.iterator();
            if(iterator.hasNext()) {
                Position group = iterator.next();
                positions.add(toResource(group, PositionResource.class));
            }
        }
        return positions;
    }
}