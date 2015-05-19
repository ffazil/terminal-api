package com.tracebucket.x.terminal.api.test.builder;

import com.tracebucket.x.terminal.api.domain.Position;
import com.tracebucket.x.terminal.api.domain.Terminal;

/**
 * Created by sadath on 19-May-15.
 */
public class TerminalBuilder {
    private String name;
    private String id;
    private String macId;
    private Position position;

    private TerminalBuilder() {}

    public static TerminalBuilder aTerminalBuilder() {
        return new TerminalBuilder();
    }

    public TerminalBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public TerminalBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public TerminalBuilder withMacId(String macId) {
        this.macId = macId;
        return this;
    }

    public TerminalBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }

    public Terminal build() {
        Terminal terminal = new Terminal(this.name, this.id, this.macId);
        return terminal;
    }
}