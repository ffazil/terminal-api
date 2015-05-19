package com.tracebucket.x.terminal.api.test.fixture;

import com.tracebucket.x.terminal.api.rest.resource.PositionTypeResource;
import com.tracebucket.x.terminal.api.test.builder.PositionTypeResourceBuilder;

import java.util.UUID;

/**
 * Created by sadath on 19-May-15.
 */
public class PositionTypeResourceFixture {
    public static PositionTypeResource standardPositionType() {
        PositionTypeResource positionType = PositionTypeResourceBuilder.aPositionTypeBuilder()
                .withType(UUID.randomUUID().toString())
                .build();
        return positionType;
    }
}