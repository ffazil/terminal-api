package com.tracebucket.x.terminal.api.test.fixture;

import com.tracebucket.x.terminal.api.rest.resource.PositionResource;
import com.tracebucket.x.terminal.api.test.builder.PositionResourceBuilder;

import java.util.UUID;

/**
 * Created by sadath on 19-May-15.
 */
public class PositionResourceFixture {
    public static PositionResource standardPosition() {
        PositionResource position = PositionResourceBuilder.aPositionBuilder()
                .withCode(UUID.randomUUID().toString())
                .withEmployee(UUID.randomUUID().toString())
                .withName(UUID.randomUUID().toString())
                .withOrganization(UUID.randomUUID().toString())
                .withSelection(UUID.randomUUID().toString())
                .withPositionType(PositionTypeResourceFixture.standardPositionType())
                .build();
        return position;
    }
}