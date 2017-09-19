package com.tocsyk.models.enums;

import java.io.Serializable;

public enum RoleType implements Serializable {
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");

    String roleTypeType;

    private RoleType(String userProfileType){
        this.roleTypeType = userProfileType;
    }

    public String getUserProfileType(){
        return roleTypeType;
    }

}