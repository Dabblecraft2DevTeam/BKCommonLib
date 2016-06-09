package com.bergerkiller.bukkit.common.reflection.classes;

import com.bergerkiller.bukkit.common.conversion.ConversionPairs;
import com.bergerkiller.bukkit.common.reflection.*;
import org.bukkit.World;

public class ChunkProviderServerRef {

    public static final ClassTemplate<?> TEMPLATE = NMSClassTemplate.create("ChunkProviderServer");
    public static final FieldAccessor<Object> chunkLoader = TEMPLATE.getField("chunkLoader");
    public static final FieldAccessor<Object> chunks = TEMPLATE.getField("chunks");
    public static final FieldAccessor<Object> unloadQueue = TEMPLATE.getField("unloadQueue");
    public static final TranslatorFieldAccessor<World> world = TEMPLATE.getField("world").translate(ConversionPairs.world);
    public static final MethodAccessor<Boolean> isLoaded = TEMPLATE.getMethod("isLoaded", int.class, int.class);
}
