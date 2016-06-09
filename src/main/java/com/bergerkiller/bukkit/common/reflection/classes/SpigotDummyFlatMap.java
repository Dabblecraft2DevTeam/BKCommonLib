package com.bergerkiller.bukkit.common.reflection.classes;

import com.bergerkiller.bukkit.common.internal.CommonPlugin;
import com.bergerkiller.bukkit.common.reflection.ClassBuilder;
import com.bergerkiller.bukkit.common.utils.CommonUtil;

import java.util.Arrays;
import java.util.logging.Level;

public class SpigotDummyFlatMap {

    private static final Object INSTANCE;

    static {
        Class<?> flatMapClass = CommonUtil.getClass("org.spigotmc.FlatMap");
        Object flatInstance = null;
        if (flatMapClass == null) {
            CommonPlugin.LOGGER.log(Level.SEVERE, "The Spigot FlatMap class could not be located!");
        } else {
            try {
                // Initialize a new dummy flatmap (that does nothing)
                ClassBuilder builder = new ClassBuilder(flatMapClass, FlatMapImpl.class);
                flatInstance = builder.create(new Class<?>[0], new Object[0], Arrays.asList((Object) new FlatMapImpl()));
            } catch (Throwable t) {
                CommonPlugin.LOGGER.log(Level.SEVERE, "Failed to initialize the Spigot Dummy FlatMap:", t);
            }
        }
        INSTANCE = flatInstance;
    }

    public static Object getInstance() {
        return INSTANCE;
    }

    public static class FlatMapImpl implements FlatMapMethods {

        public Object get(long msw, long lsw) {
            return null;
        }

        public Object get(long key) {
            return null;
        }

        public void put(long msw, long lsw, Object value) {
        }

        public void put(long key, Object value) {
        }
    }

    public interface FlatMapMethods {

        Object get(long msw, long lsw);

        Object get(long key);

        void put(long msw, long lsw, Object value);

        void put(long key, Object value);
    }
}
