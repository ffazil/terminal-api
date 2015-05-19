package com.tracebucket.x.terminal.api.test.fixture;

import com.tracebucket.x.terminal.api.domain.Position;
import com.tracebucket.x.terminal.api.test.builder.PositionBuilder;

import java.util.UUID;

/**
 * Created by sadath on 19-May-15.
 */
public class PositionFixture {
    public static Position standardPosition() {
        Position position = PositionBuilder.aPositionBuilder()
                .withCode(UUID.randomUUID().toString())
                .withEmployee(UUID.randomUUID().toString())
                .withName(UUID.randomUUID().toString())
                .withOrganization(UUID.randomUUID().toString())
                .withSelection(UUID.randomUUID().toString())
                .withPositionType(PositionTypeFixture.standardPositionType())
                .build();
        return position;
    }
}