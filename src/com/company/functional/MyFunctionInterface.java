package com.company.functional;

/**
 * @author Administrator
 */
@FunctionalInterface
public interface MyFunctionInterface<T> {
    /**
     * test
     * @param origin
     * @return
     */
    T getValue(String origin);
}
