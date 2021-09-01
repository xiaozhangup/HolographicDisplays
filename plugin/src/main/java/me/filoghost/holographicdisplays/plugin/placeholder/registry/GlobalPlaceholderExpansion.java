/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.holographicdisplays.plugin.placeholder.registry;

import me.filoghost.holographicdisplays.api.placeholder.global.GlobalPlaceholder;
import me.filoghost.holographicdisplays.api.placeholder.global.GlobalPlaceholderFactory;
import me.filoghost.holographicdisplays.plugin.placeholder.PlaceholderException;
import me.filoghost.holographicdisplays.plugin.placeholder.StandardPlaceholder;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class GlobalPlaceholderExpansion extends PlaceholderExpansion {

    private final GlobalPlaceholderFactory placeholderFactory;

    GlobalPlaceholderExpansion(Plugin plugin, String identifier, GlobalPlaceholderFactory placeholderFactory) {
        super(plugin, identifier);
        this.placeholderFactory = placeholderFactory;
    }

    @Override
    public boolean isIndividual() {
        return false;
    }

    @Override
    public @Nullable StandardPlaceholder createPlaceholder(String argument) throws PlaceholderException {
        GlobalPlaceholder placeholder;
        try {
            placeholder = placeholderFactory.getPlaceholder(argument);
        } catch (Throwable t) {
            throw new PlaceholderException(t, this);
        }

        if (placeholder != null) {
            return new GlobalStandardPlaceholder(placeholder, this);
        } else {
            return null;
        }
    }


    private static class GlobalStandardPlaceholder extends StandardPlaceholder {

        private final @NotNull GlobalPlaceholder placeholder;

        GlobalStandardPlaceholder(@NotNull GlobalPlaceholder placeholder, @NotNull GlobalPlaceholderExpansion source) {
            super(source);
            this.placeholder = placeholder;
        }

        @Override
        protected boolean externalRequiresUpdate(long currentTick, long lastUpdateTick) {
            return placeholder.requiresUpdate(currentTick, lastUpdateTick);
        }

        @Override
        protected @Nullable String externalGetReplacement(Player player, @Nullable String argument) {
            return placeholder.getReplacement(argument);
        }

    }

}
