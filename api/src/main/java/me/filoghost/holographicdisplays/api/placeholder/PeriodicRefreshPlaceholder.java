/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.holographicdisplays.api.placeholder;

public interface PeriodicRefreshPlaceholder extends Placeholder {

    @Override
    default boolean requiresUpdate(long currentTick, long lastUpdateTick) {
        return currentTick - lastUpdateTick > getRefreshIntervalTicks();
    }

    int getRefreshIntervalTicks();

}
