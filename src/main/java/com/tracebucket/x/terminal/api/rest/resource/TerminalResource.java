package com.tracebucket.x.terminal.api.rest.resource;

import com.tracebucket.tron.assembler.BaseResource;

/**
 * Created by sadath on 18-May-15.
 */
public class TerminalResource extends BaseResource {
    private String name;
    private String id;
    private String macId;
    private PositionResource position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public PositionResource getPosition() {
        return position;
    }

    public void setPosition(PositionResource position) {
        this.position = position;
    }
}