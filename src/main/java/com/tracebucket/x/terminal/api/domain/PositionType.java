package com.tracebucket.x.terminal.api.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author ffazil
 * @since 17/05/15
 */
@Embeddable
public class PositionType {

    @Column(name = "POSITION_TYPE")
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
