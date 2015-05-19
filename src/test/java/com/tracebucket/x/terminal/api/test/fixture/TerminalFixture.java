package com.tracebucket.x.terminal.api.test.fixture;

import com.tracebucket.x.terminal.api.domain.Terminal;
import com.tracebucket.x.terminal.api.test.builder.TerminalBuilder;

import java.util.UUID;

/**
 * Created by sadath on 19-May-15.
 */
public class TerminalFixture {
    public static Terminal standardTerminal() {
        Terminal terminal = TerminalBuilder.aTerminalBuilder()
                .withId(UUID.randomUUID().toString())
                .withMacId(UUID.randomUUID().toString())
                .withName(UUID.randomUUID().toString())
                //.withPosition(PositionFixture.standardPosition())
                .build();
        return terminal;
    }
}