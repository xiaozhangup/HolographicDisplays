/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.holographicdisplays.plugin.hologram.internal;

import me.filoghost.holographicdisplays.plugin.HolographicDisplays;
import me.filoghost.holographicdisplays.plugin.hologram.base.BaseHologram;
import me.filoghost.holographicdisplays.plugin.hologram.tracking.LineTrackerManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class InternalHologram extends BaseHologram<InternalHologramLine> {

    private final String name;

    protected InternalHologram(Location location, String name, LineTrackerManager lineTrackerManager) {
        super(location, lineTrackerManager);
        this.name = name;
    }

    public InternalTextLine createTextLine(String text, String serializedConfigValue) {
        return new InternalTextLine(this, text, serializedConfigValue);
    }

    public InternalItemLine createItemLine(ItemStack icon, String serializedConfigValue) {
        return new InternalItemLine(this, icon, serializedConfigValue);
    }

    public String getName() {
        return name;
    }

    @Override
    public Plugin getCreatorPlugin() {
        return HolographicDisplays.getInstance();
    }

    @Override
    public boolean isVisibleTo(Player player) {
        return true;
    }

    @Override
    public String toString() {
        return "InternalHologram [name=" + name + ", super=" + super.toString() + "]";
    }

}