package com.tracebucket.x.terminal.api.domain;

import com.tracebucket.tron.ddd.domain.BaseAggregateRoot;

import javax.persistence.*;

/**
 * @author ffazil
 * @since 16/05/15
 */

@Entity
@Table(name = "TERMINAL")
public class Terminal extends BaseAggregateRoot{

    @Column(name = "NAME", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private String name;

    @Column(name = "ID", nullable = false, unique = true)
    @Basic(fetch = FetchType.EAGER)
    private String id;

    @Column(name = "MAC_ID", nullable = false, unique = true)
    @Basic(fetch = FetchType.EAGER)
    private String macId;

    private Position position;

    //For JPA container
    private Terminal(){

    }

    //Default constructor
    public Terminal(String name, String id, String macId){
        this.name = name;
        this.id = id;
        this.macId = macId;
    }

    //Place a terminal in a position
    public void place(Position position){
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getMacId() {
        return macId;
    }

    public Position getPosition() {
        return position;
    }
}
