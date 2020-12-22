package com.tuananhdo.model;

import lombok.Getter;

@Getter
public enum SizeCake {

    LARGE("Cỡ lớn - 12 inch"), MEDIUM("Cỡ vừa - 9 inch");

    private final String name;

    SizeCake(String name) {
        this.name = name;
    }
}
