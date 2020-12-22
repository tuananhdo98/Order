package com.tuananhdo.model;

import lombok.Getter;

@Getter
public enum OrderStatus {
    DANG_XU_LY("Đang xử lý"),
    DANG_SHIP("Đang vận chuyển"), HOAN_THANH("Hoàn thành");


    private final String name;

    OrderStatus(String name) {
        this.name = name;
    }

}
