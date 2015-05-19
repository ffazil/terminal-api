package com.tracebucket.x.terminal.api.test.builder;

import com.tracebucket.x.terminal.api.domain.PositionType;

/**
 * Created by sadath on 19-May-15.
 */
public class PositionTypeBuilder {
    private String type;

    private PositionTypeBuilder() { }

    public static PositionTypeBuilder aPositionTypeBuilder() {
        return new PositionTypeBuilder();
    }

    public PositionTypeBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public PositionType build() {
        PositionType positionType = new PositionType(this.type);
        return positionType;
    }
}
