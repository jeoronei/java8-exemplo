package com.company;

@FunctionalInterface
public interface Validador<T> {
    boolean validar(T t);
}
