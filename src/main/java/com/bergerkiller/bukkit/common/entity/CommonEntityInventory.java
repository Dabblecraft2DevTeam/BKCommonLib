package com.bergerkiller.bukkit.common.entity;

import com.bergerkiller.bukkit.common.controller.EntityInventoryController;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.Inventory;

/**
 * An entity that has an Inventory
 */
public interface CommonEntityInventory<T extends Entity> {

    Inventory getInventory();

    /**
     * Updates the Inventory (can mean: Update items to viewers)
     */
    void update();

    void setInventoryController(EntityInventoryController<CommonEntity<T>> controller);

    EntityInventoryController<CommonEntity<T>> getInventoryController();
}
