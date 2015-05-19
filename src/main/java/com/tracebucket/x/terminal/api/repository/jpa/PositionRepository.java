package com.tracebucket.x.terminal.api.repository.jpa;

import com.tracebucket.tron.ddd.domain.EntityId;
import com.tracebucket.tron.ddd.jpa.BaseEntityRepository;
import com.tracebucket.x.terminal.api.domain.Position;

/**
 * Created by sadath on 19-May-15.
 */
public interface PositionRepository extends BaseEntityRepository<Position, EntityId> {
}
