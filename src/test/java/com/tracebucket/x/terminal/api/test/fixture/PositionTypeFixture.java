package com.tracebucket.x.terminal.api.test.fixture;

import com.tracebucket.x.terminal.api.domain.PositionType;
import com.tracebucket.x.terminal.api.test.builder.PositionTypeBuilder;

import java.util.UUID;

/**
 * Created by sadath on 19-May-15.
 */
public class PositionTypeFixture {
    public static PositionType standardPositionType() {
        PositionType positionType = PositionTypeBuilder.aPositionTypeBuilder()
                .withType(UUID.randomUUID().toString())
                .build();
        return positionType;
    }
}