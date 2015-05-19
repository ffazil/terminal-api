package com.tracebucket.x.terminal.api.test.fixture;

import com.tracebucket.x.terminal.api.rest.resource.TerminalResource;
import com.tracebucket.x.terminal.api.test.builder.TerminalResourceBuilder;

import java.util.UUID;

/**
 * Created by sadath on 19-May-15.
 */
public class TerminalResourceFixture {
    public static TerminalResource standardTerminal() {
        TerminalResource terminal = TerminalResourceBuilder.aTerminalBuilder()
                .withId(UUID.randomUUID().toString())
                .withMacId(UUID.randomUUID().toString())
                .withName(UUID.randomUUID().toString())
                //.withPosition(PositionResourceFixture.standardPosition())
                .build();
        return terminal;
    }
}