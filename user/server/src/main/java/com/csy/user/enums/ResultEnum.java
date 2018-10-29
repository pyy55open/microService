package com.csy.user.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0,"登录成功"),
    ERROR(1,"登录失败"),
    ROLE_ERROE(2,"登录权限有误"),;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
