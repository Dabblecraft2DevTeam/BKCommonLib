package com.bergerkiller.bukkit.common.entity.nms;

import com.bergerkiller.bukkit.common.controller.EntityInventoryController;
import net.minecraft.server.v1_10_R1.ItemStack;

public interface NMSEntityInventoryHook {

    EntityInventoryController<?> getInventoryController();

    void setInventoryController(EntityInventoryController<?> controller);

    /**
     * onItemSet
     */
    void setItem(int index, ItemStack item);

    /**
     * onItemSet super
     */
    void super_setItem(int index, ItemStack item);
}
