package com.tracebucket.x.terminal.api.test.builder;

import com.tracebucket.x.terminal.api.domain.Position;
import com.tracebucket.x.terminal.api.domain.PositionType;

/**
 * Created by sadath on 19-May-15.
 */
public class PositionBuilder {
    private String name;
    private PositionType positionType;
    private String code;
    private String selection;
    private String organization;
    private String employee;

    private PositionBuilder() {

    }

    public static PositionBuilder aPositionBuilder() {
        return new PositionBuilder();
    }

    public PositionBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PositionBuilder withPositionType(PositionType positionType) {
        this.positionType = positionType;
        return this;
    }

    public PositionBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public PositionBuilder withSelection(String selection) {
        this.selection = selection;
        return this;
    }

    public PositionBuilder withOrganization(String organization) {
        this.organization = organization;
        return this;
    }

    public PositionBuilder withEmployee(String employee) {
        this.employee = employee;
        return this;
    }

    public Position build() {
        Position position = new Position(this.name, this.positionType, this.code, this.selection);
        position.assign(this.organization);
        position.addEmployee(this.employee);
        return position;
    }
}