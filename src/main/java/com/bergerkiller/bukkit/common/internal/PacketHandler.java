package com.bergerkiller.bukkit.common.internal;

import com.bergerkiller.bukkit.common.protocol.PacketListener;
import com.bergerkiller.bukkit.common.protocol.PacketMonitor;
import com.bergerkiller.bukkit.common.protocol.PacketType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Collection;

/**
 * All the methods needed for internally handling the packet sending and
 * receiving
 */
public interface PacketHandler {

    /**
     * Removes all monitors and listeners belonging to a plugin
     *
     * @param plugin to remove for
     */
    void removePacketListeners(Plugin plugin);

    void removePacketListener(PacketListener listener);

    void removePacketMonitor(PacketMonitor monitor);

    void addPacketListener(Plugin plugin, PacketListener listener, PacketType[] types);

    void addPacketMonitor(Plugin plugin, PacketMonitor monitor, PacketType[] types);

    void sendPacket(Player player, Object packet, boolean throughListeners);

    void receivePacket(Player player, Object packet);

    Collection<Plugin> getListening(PacketType packetType);

    void transfer(PacketHandler to);

    /**
     * Gets the name of this type of Packet Handler
     *
     * @return packet handler name
     */
    String getName();

    /**
     * Called when this Packet Handler has to be enabled. This method should
     * take care of registering packet hooks or listeners.
     *
     * @return True if the handler successfully enabled, False if not
     */
    boolean onEnable();

    /**
     * Called when this Packet Handler has to be disabled. This method should
     * take care of removing any packet hooks or listeners.
     *
     * @return True if the handler successfully disabled, False if not
     */
    boolean onDisable();

    /**
     * Called when a new player joins the server and potentially needs a
     * listener hook
     *
     * @param player that joined
     */
    void onPlayerJoin(Player player);

    /**
     * Gets the amount of bytes of packet data still pending to be sent to the
     * player
     *
     * @param player to get the size for
     * @return pending packet queue byte size
     */
    long getPendingBytes(Player player);
}
