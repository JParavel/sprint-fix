package com.paravel.sprint.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.world.ClientWorld;

@Environment(EnvType.CLIENT)
public class SprintManager {

    MinecraftClient client;
    ClientPlayerEntity player;
    KeyBinding sprintKey;

    public void handleSprint(MinecraftClient client) {

        this.client = client;
        player = client.player;

        ClientWorld world = client.world;
        if (world == null)
            return;

        GameOptions options = client.options;
        boolean sprintToggled = options.getSprintToggled().getValue();

        sprintKey = options.sprintKey;

        // Missing implementation due to an ingame bug
        if (sprintToggled) {
            onSprintHold();
        } else {
            onSprintHold();
        }
    }

    public void onSprintHold() {

        ClientPlayerEntity player = client.player;
        if (player.isSprinting() && !sprintKey.isPressed()) {
            player.setSprinting(false);
        }

    }
}
