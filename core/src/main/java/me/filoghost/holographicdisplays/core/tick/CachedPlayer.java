/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.holographicdisplays.core.tick;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CachedPlayer {

    private final Player player;
    private final TickClock tickClock;

    private Location location;
    protected boolean movedThisTick;
    private long locationUpdateTick;

    public CachedPlayer(Player player, TickClock tickClock) {
        this.player = player;
        this.tickClock = tickClock;
        this.locationUpdateTick = -1;
    }

    public Player getBukkitPlayer() {
        return player;
    }

    void onTick() {
        Location newLocation = player.getLocation();
        movedThisTick = !newLocation.equals(location);
        location = newLocation;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CachedPlayer other = (CachedPlayer) obj;
        return player.equals(other.player);
    }

    @Override
    public int hashCode() {
        return player.hashCode();
    }

}
