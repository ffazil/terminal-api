package com.tracebucket.x.terminal.api.domain;

import com.tracebucket.tron.ddd.domain.BaseEntity;

import javax.persistence.*;

/**
 * @author ffazil
 * @since 16/05/15
 */
@Entity
@Table(name = "POSITION")
public class Position extends BaseEntity{

    @Column(name = "NAME", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private String name;

    @Embedded
    private PositionType positionType;

    @Column(name = "CODE", nullable = false, unique = true)
    @Basic(fetch = FetchType.EAGER)
    private String code;

    @Column(name = "SELECTION")
    @Basic(fetch = FetchType.EAGER)
    private String selection;

    @Column(name = "ORGANIZATION")
    @Basic(fetch = FetchType.EAGER)
    private String organization;

    @Column(name = "EMPLOYEE")
    @Basic(fetch = FetchType.EAGER)
    private String employee;

    private Position(){

    }

    //Default minimal constructor
    public Position(String name, PositionType positionType){
        this.name = name;
        this.positionType = positionType;
    }

    //Default full constructor
    public Position(String name, PositionType positionType, String code, String selection){
        this.name = name;
        this.positionType = positionType;
        this.code = code;
        this.selection = selection;
    }

    public void assign(String organization){
        this.organization = organization;
    }

    public void addEmployee(String employee){
        this.employee = employee;
    }

    public void changePositionType(PositionType newPositionType){
        this.positionType = newPositionType;
    }

    public String getName() {
        return name;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public String getCode() {
        return code;
    }

    public String getSelection() {
        return selection;
    }

    public String getOrganization() {
        return organization;
    }

    public String getEmployee() {
        return employee;
    }
}
