package com.tracebucket.x.terminal.api.test.builder;

import com.tracebucket.x.terminal.api.rest.resource.PositionResource;
import com.tracebucket.x.terminal.api.rest.resource.PositionTypeResource;

/**
 * Created by sadath on 19-May-15.
 */
public class PositionResourceBuilder {
    private String name;
    private PositionTypeResource positionType;
    private String code;
    private String selection;
    private String organization;
    private String employee;

    private PositionResourceBuilder() {

    }

    public static PositionResourceBuilder aPositionBuilder() {
        return new PositionResourceBuilder();
    }

    public PositionResourceBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PositionResourceBuilder withPositionType(PositionTypeResource positionType) {
        this.positionType = positionType;
        return this;
    }

    public PositionResourceBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public PositionResourceBuilder withSelection(String selection) {
        this.selection = selection;
        return this;
    }

    public PositionResourceBuilder withOrganization(String organization) {
        this.organization = organization;
        return this;
    }

    public PositionResourceBuilder withEmployee(String employee) {
        this.employee = employee;
        return this;
    }

    public PositionResource build() {
        PositionResource position = new PositionResource();
        position.setOrganization(this.organization);
        position.setEmployee(this.employee);
        position.setName(this.name);
        position.setCode(this.code);
        position.setPositionType(this.positionType);
        position.setSelection(this.selection);
        return position;
    }
}