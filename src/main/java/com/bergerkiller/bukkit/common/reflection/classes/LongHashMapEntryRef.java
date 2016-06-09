package com.bergerkiller.bukkit.common.reflection.classes;

import com.bergerkiller.bukkit.common.reflection.CBClassTemplate;
import com.bergerkiller.bukkit.common.reflection.ClassTemplate;
import com.bergerkiller.bukkit.common.reflection.FieldAccessor;

public class LongHashMapEntryRef {

    public static ClassTemplate<?> TEMPLATE;
    public static FieldAccessor<Long> entryKey;
    public static FieldAccessor<Object> entryValue;

    static {
        ClassTemplate<?> map = CBClassTemplate.create("util.LongObjectHashMap");

        for (Class<?> c : map.getType().getDeclaredClasses()) {
            if (c.getSimpleName().equalsIgnoreCase("Entry")) {
                TEMPLATE = ClassTemplate.create(c);
                entryKey = TEMPLATE.getField("key");
                entryValue = TEMPLATE.getField("value");
            }
        }
    }
}