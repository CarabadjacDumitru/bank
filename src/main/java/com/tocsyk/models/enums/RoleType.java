package com.tocsyk.models.enums;

public enum RoleType {
    Unspecified(0),
    ADMIN(1),
    BANK(2),
    BRANCH(3),
    CUSTOMER(4),
    CONTRACT(5),
    PAYMENT(6);

    private int roleType;

    RoleType(int roleType) {
        this.roleType = roleType;

    }
}

