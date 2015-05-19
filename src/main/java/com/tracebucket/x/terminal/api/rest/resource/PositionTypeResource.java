package com.tracebucket.x.terminal.api.rest.resource;

import com.tracebucket.tron.assembler.BaseResource;

/**
 * Created by sadath on 18-May-15.
 */
public class PositionTypeResource extends BaseResource {
    private String type;

    public PositionTypeResource() {
    }

    public PositionTypeResource(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}