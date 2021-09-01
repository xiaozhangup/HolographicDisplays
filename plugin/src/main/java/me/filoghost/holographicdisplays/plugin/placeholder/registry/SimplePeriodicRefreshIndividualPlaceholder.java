/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.holographicdisplays.plugin.placeholder.registry;

import me.filoghost.holographicdisplays.api.placeholder.individual.IndividualPlaceholderReplacer;
import me.filoghost.holographicdisplays.api.placeholder.individual.PeriodicRefreshIndividualPlaceholder;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class SimplePeriodicRefreshIndividualPlaceholder implements PeriodicRefreshIndividualPlaceholder {

    private final int refreshIntervalTicks;
    private final IndividualPlaceholderReplacer placeholderReplacer;

    SimplePeriodicRefreshIndividualPlaceholder(int refreshIntervalTicks, IndividualPlaceholderReplacer placeholderReplacer) {
        this.refreshIntervalTicks = refreshIntervalTicks;
        this.placeholderReplacer = placeholderReplacer;
    }

    @Override
    public int getRefreshIntervalTicks() {
        return refreshIntervalTicks;
    }

    @Override
    public String getReplacement(@NotNull Player player, @Nullable String argument) {
        return placeholderReplacer.getReplacement(player, argument);
    }

}
