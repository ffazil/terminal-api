package com.tracebucket.x.terminal.api.test.builder;

import com.tracebucket.x.terminal.api.rest.resource.PositionResource;
import com.tracebucket.x.terminal.api.rest.resource.TerminalResource;

/**
 * Created by sadath on 19-May-15.
 */
public class TerminalResourceBuilder {
    private String name;
    private String id;
    private String macId;
    private PositionResource position;

    private TerminalResourceBuilder() {}

    public static TerminalResourceBuilder aTerminalBuilder() {
        return new TerminalResourceBuilder();
    }

    public TerminalResourceBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public TerminalResourceBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public TerminalResourceBuilder withMacId(String macId) {
        this.macId = macId;
        return this;
    }

    public TerminalResourceBuilder withPosition(PositionResource position) {
        this.position = position;
        return this;
    }

    public TerminalResource build() {
        TerminalResource terminal = new TerminalResource();
        terminal.setId(this.id);
        terminal.setMacId(this.macId);
        terminal.setPosition(this.position);
        terminal.setName(this.name);
        return terminal;
    }
}