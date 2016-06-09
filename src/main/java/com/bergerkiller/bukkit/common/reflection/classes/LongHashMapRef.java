package com.bergerkiller.bukkit.common.reflection.classes;

import com.bergerkiller.bukkit.common.reflection.CBClassTemplate;
import com.bergerkiller.bukkit.common.reflection.ClassTemplate;
import com.bergerkiller.bukkit.common.reflection.MethodAccessor;
import com.bergerkiller.bukkit.common.reflection.SafeConstructor;

public class LongHashMapRef {

    public static ClassTemplate<?> TEMPLATE = CBClassTemplate.create("util.LongObjectHashMap");
    public static MethodAccessor<?> size = TEMPLATE.getMethod("size");
    public static MethodAccessor<?> containsKey = TEMPLATE.getMethod("containsKey", long.class);
    public static MethodAccessor<?> get = TEMPLATE.getMethod("get", long.class);
    public static MethodAccessor<?> remove = TEMPLATE.getMethod("remove", long.class);
    public static MethodAccessor<?> put = TEMPLATE.getMethod("put", long.class, Object.class);
    public static MethodAccessor<?> keySet = TEMPLATE.getMethod("keySet");
    public static SafeConstructor<?> constructor1 = TEMPLATE.getConstructor();
}