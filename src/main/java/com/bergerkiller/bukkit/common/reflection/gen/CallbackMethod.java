package com.bergerkiller.bukkit.common.reflection.gen;

import java.util.Map;

/**
 * Represents a Callback that can redirect a method call
 */
public interface CallbackMethod {

    /**
     * Executes this Callback for the instance specified. This instance is the
     * same instance as sent into
     * {@link CallbackSignature#createCallback(Object, Map)}.
     *
     * @param instance to call this Callback on
     * @param args for the Callback to use
     * @return the return type from the Callback
     * @throws Throwable - if anything goes wrong while invoking the Callback
     */
    Object invoke(Object instance, Object[] args) throws Throwable;
}
