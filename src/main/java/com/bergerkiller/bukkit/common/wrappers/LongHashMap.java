package com.bergerkiller.bukkit.common.wrappers;

import com.bergerkiller.bukkit.common.reflection.classes.LongHashMapRef;
import com.bergerkiller.bukkit.common.utils.MathUtil;
import org.bukkit.craftbukkit.v1_10_R1.util.LongObjectHashMap;

import java.util.Collection;
import java.util.Set;

/**
 * A wrapper around the internal LongHashMap implementation. This type of
 * HashMap allows storing values at long keys. Ideally, two int values are
 * merged into one long to map against 2D-coordinates. This type of class is
 * used by, for example, the internal chunk storage.
 *
 * @param <V> - Value type
 */
public class LongHashMap<V> extends BasicWrapper {

    public LongHashMap() {
        this(LongHashMapRef.constructor1.newInstance());
    }

    /**
     * Constructs a new LongHashMap with an initial capacity as specified<br>
     * <b>Warning: this method was added in v1.54 and is not compatible with MC
     * 1.5.2.</b>
     *
     * @param initialCapacity for the new LongHashMap
     */
    public LongHashMap(int initialCapacity) {
        this();
    }

    public LongHashMap(Object handle) {
        this.setHandle(handle);
    }

    /**
     * Gets the amount of Long:Value pairs stored in this LongHashMap
     *
     * @return size
     */
    public int size() {
        return Math.max(((Integer) LongHashMapRef.size.invoke(handle)), 0);
    }

    /**
     * Checks whether this Long HashMap contains the coordinates specified.<br>
     * <b>Warning: this method was added in v1.54 and is not compatible with MC
     * 1.5.2.</b>
     *
     * @param msw - most significant part of the key
     * @param lsw - least signfificant part of the key
     * @return True if contained, False if not
     */
    public boolean contains(int msw, int lsw) {
        return contains(MathUtil.longHashToLong(msw, lsw));
    }

    public boolean contains(long key) {
        return ((Boolean) LongHashMapRef.containsKey.invoke(handle, key));
    }

    /**
     * Gets the value stored at the coordinates specified.<br>
     * <b>Warning: this method was added in v1.54 and is not compatible with MC
     * 1.5.2.</b>
     *
     * @param msw - most significant part of the key
     * @param lsw - least signfificant part of the key
     * @return The value stored at the key, or null if none stored
     */
    public V get(int msw, int lsw) {
        return get(MathUtil.longHashToLong(msw, lsw));
    }

    @SuppressWarnings("unchecked")
    public V get(long key) {
        return (V) LongHashMapRef.get.invoke(handle, key);
    }

    /**
     * Removes and obtains the value stored at the coordinates specified.<br>
     * <b>Warning: this method was added in v1.54 and is not compatible with MC
     * 1.5.2.</b>
     *
     * @param msw - most significant part of the key
     * @param lsw - least signfificant part of the key
     * @return The removed value previously stored at the key, or null if none
     * was stored
     */
    public V remove(int msw, int lsw) {
        return remove(MathUtil.longHashToLong(msw, lsw));
    }

    @SuppressWarnings("unchecked")
    public V remove(long key) {
        return (V) LongHashMapRef.remove.invoke(handle, key);
    }

    /**
     * Puts a value at the coordinates specified.<br>
     * <b>Warning: this method was added in v1.54 and is not compatible with MC
     * 1.5.2.</b>
     *
     * @param msw - most significant part of the key
     * @param lsw - least signfificant part of the key
     * @param value to put at the coordinates
     */
    public void put(int msw, int lsw, V value) {
        put(MathUtil.longHashToLong(msw, lsw), value);
    }

    public void put(long key, V value) {
        LongHashMapRef.put.invoke(handle, key, value);
    }

    @SuppressWarnings("unchecked")
    public Collection<V> getValues() {
        return ((LongObjectHashMap) handle).values();
    }

    public long[] getKeys() {
        Set<Long> keySet = (Set<Long>) LongHashMapRef.keySet.invoke(handle);
        long[] keys = new long[keySet.size()];

        int i = 0;
        for (long l : keySet) {
            keys[i] = l;
        }

        return keys;
    }
}