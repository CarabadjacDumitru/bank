package com.tocsyk.model.enums;

public enum enumRoleType {
    ANONYMOUS("ANONYMOUS"),
    ADMIN("ADMIN"),
    BANK("BANK"),
    BRANCH("BRANCH"),
    CUSTOMER("CUSTOMER"),
    CONTRACT("CONTRACT"),
    PAYMENT("PAYMENT");

    private String roleType;

    enumRoleType(String roleType) {
        this.roleType = roleType;
    }

    public  String getRole(){
        return roleType;
    }
}

