package com.tracebucket.x.terminal.api.rest.resource;

import com.tracebucket.tron.assembler.BaseResource;

/**
 * Created by sadath on 18-May-15.
 */
public class PositionResource extends BaseResource {
    private String name;
    private PositionTypeResource positionType;
    private String code;
    private String selection;
    private String organization;
    private String employee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PositionTypeResource getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionTypeResource positionType) {
        this.positionType = positionType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
}