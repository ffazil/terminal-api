package com.tracebucket.x.terminal.api.domain;

/**
 * @author ffazil
 * @since 17/05/15
 */
public class PositionType {
    private String type;

    //Default constructor
    private PositionType(){

    }

    public PositionType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
