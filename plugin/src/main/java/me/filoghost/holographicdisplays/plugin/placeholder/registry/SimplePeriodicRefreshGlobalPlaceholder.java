/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.holographicdisplays.plugin.placeholder.registry;

import me.filoghost.holographicdisplays.api.placeholder.global.GlobalPlaceholderReplacer;
import me.filoghost.holographicdisplays.api.placeholder.global.PeriodicRefreshGlobalPlaceholder;
import org.jetbrains.annotations.Nullable;

class SimplePeriodicRefreshGlobalPlaceholder implements PeriodicRefreshGlobalPlaceholder {

    private final int refreshIntervalTicks;
    private final GlobalPlaceholderReplacer placeholderReplacer;

    SimplePeriodicRefreshGlobalPlaceholder(int refreshIntervalTicks, GlobalPlaceholderReplacer placeholderReplacer) {
        this.refreshIntervalTicks = refreshIntervalTicks;
        this.placeholderReplacer = placeholderReplacer;
    }

    @Override
    public int getRefreshIntervalTicks() {
        return refreshIntervalTicks;
    }

    @Override
    public String getReplacement(@Nullable String argument) {
        return placeholderReplacer.getReplacement(argument);
    }

}
