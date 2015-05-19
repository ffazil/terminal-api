package com.tracebucket.x.terminal.api.test.builder;

import com.tracebucket.x.terminal.api.rest.resource.PositionTypeResource;

/**
 * Created by sadath on 19-May-15.
 */
public class PositionTypeResourceBuilder {
    private String type;

    private PositionTypeResourceBuilder() { }

    public static PositionTypeResourceBuilder aPositionTypeBuilder() {
        return new PositionTypeResourceBuilder();
    }

    public PositionTypeResourceBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public PositionTypeResource build() {
        PositionTypeResource positionType = new PositionTypeResource();
        positionType.setType(this.type);
        return positionType;
    }
}