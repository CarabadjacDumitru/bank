package com.tocsyk.models.enums;

public enum AccountStatusType {
    Unspecified(1),
    Open(2),
    Closed(3),
    Suspended(4);

    private int typeOfStatus;

    AccountStatusType(int typeOfStatus) {
        this.typeOfStatus = typeOfStatus;

    }
}
