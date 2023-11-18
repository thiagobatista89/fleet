package com.escorts.search.infrastructure.enumeration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * MessageTypeEnum Enum
 *
 * @author Andryev Lemes
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public enum MessageTypeEnum {

    INFO("I", "info"),
    ERROR("E", "error"),
    ALERT("A", "alert");

    private String code;
    private String description;
}
