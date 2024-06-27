package org.choongang.global.validators;

public interface RequiredValidator {
    default void checkRequired(String str, RuntimeException e) {
        if (str == null || str.isBlank()) {
            throw e;
        }
    }

    default void checkTrue(boolean checked, RuntimeException e) {
        if (!checked) {
            throw e;
        }
    }
}
