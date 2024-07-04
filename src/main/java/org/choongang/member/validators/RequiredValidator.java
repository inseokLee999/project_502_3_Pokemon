package org.choongang.member.validators;

import org.choongang.global.exceptions.AlertException;

public interface RequiredValidator {
    default void checkRequired(String str, AlertException e) {
        if (str == null || str.isBlank()) {
            throw e;
        }
    }

    // 참인지 체크
    default void checkTrue(boolean checked, RuntimeException e) {
        if (!checked) {
            throw e;
        }
    }
}