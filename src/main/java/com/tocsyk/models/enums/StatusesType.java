package com.tocsyk.models.enums;

public enum StatusesType {
    Unspecified(1),
    Open(2),
    Closed(3),
    Suspended(4);

    private int typeOfStatus;

    StatusesType(int typeOfStatus) {
        this.typeOfStatus = typeOfStatus;

    }
}
