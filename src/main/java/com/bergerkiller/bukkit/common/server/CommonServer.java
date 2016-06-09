package com.bergerkiller.bukkit.common.server;

import com.bergerkiller.bukkit.common.internal.CommonPlugin;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.Collection;
import java.util.List;

public interface CommonServer {

    /**
     * Tries to initialize the server
     *
     * @return True if initializing was successful, False if not
     */
    boolean init();

    /**
     * Called after the {@link #init()} method successfully detected the server
     * and initialized the server. In here processing that depends on the
     * CommonServer instance being fully initialized can be continued.
     */
    void postInit();

    /**
     * Prepares this server for enabling of BKCommonLIb
     *
     * @param plugin instance
     */
    void enable(CommonPlugin plugin);

    /**
     * Prepares this server for disabling of BKCommonLib
     *
     * @param plugin instance
     */
    void disable(CommonPlugin plugin);

    /**
     * Gets the versioning information of the server
     *
     * @return server versioning description
     */
    String getServerVersion();

    /**
     * Gets the full name of the server
     *
     * @return server name
     */
    String getServerName();

    /**
     * Gets a more detailed description of the server, excluding the server
     * version
     *
     * @return server description
     */
    String getServerDescription();

    /**
     * Gets the real Class name for the given Path, allowing Class path
     * translations to occur
     *
     * @param path to the Class to fix
     * @return the real Class path
     */
    String getClassName(String path);

    /**
     * Obtains the real method name for a given method, allowing name
     * translations to occur
     *
     * @param type of Class the method is in
     * @param methodName of the method to fix
     * @param params of the method
     * @return the (translated) method name
     */
    String getMethodName(Class<?> type, String methodName, Class<?>... params);

    /**
     * Obtains the real field name for a given field, allowing name translations
     * to occur
     *
     * @param type of Class the field is in
     * @param fieldName of the field to fix
     * @return the (translated) field name
     */
    String getFieldName(Class<?> type, String fieldName);

    /**
     * Checks whether BKCommonLib is compatible with this server
     *
     * @return True if compatible, False if not
     */
    boolean isCompatible();

    /**
     * Gets the version of Minecraft the server supports
     *
     * @return Minecraft version
     */
    String getMinecraftVersion();

    /**
     * Gets the File Location where the regions of a world are contained
     *
     * @param worldName to get the regions folder for
     * @return Region folder
     */
    File getWorldRegionFolder(String worldName);

    /**
     * Gets the File Location where a world is contained
     *
     * @return World folder
     */
    File getWorldFolder(String worldName);

    /**
     * Gets a Collection of all worlds that can be loaded without creating it
     *
     * @return Loadable world names
     */
    Collection<String> getLoadableWorlds();

    /**
     * Checks whether the World name specified contains a folder and can be
     * loaded
     *
     * @param worldName to check
     * @return True if the world can be loaded, False if not
     */
    boolean isLoadableWorld(String worldName);

    /**
     * Obtains the Entity remove queue used for queuing removal packets for a
     * Player
     *
     * @param player to get it for
     * @return Entity remove queue
     */
    List<Integer> getEntityRemoveQueue(Player player);
}
