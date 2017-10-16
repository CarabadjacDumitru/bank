package com.tocsyk.model.enums;

public enum RoleType {
    Unspecified("ANONYMOUS"),
    ADMIN("ADMIN"),
    BANK("BANK"),
    BRANCH("BRANCH"),
    CUSTOMER("CUSTOMER"),
    CONTRACT("CONTRACT"),
    PAYMENT("PAYMENT");

    private String roleType;

    RoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRole(){
        return roleType;
    }
}

