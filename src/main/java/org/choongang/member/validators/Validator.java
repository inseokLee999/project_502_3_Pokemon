package org.choongang.member.validators;

public interface Validator<T> {
    void check(T form);
}
