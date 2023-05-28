package com.paravel.sprint;

import com.paravel.sprint.client.SprintManager;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

/**
 * SprintMod
 */

@Environment(EnvType.CLIENT)
public class SprintMod implements ModInitializer {

    SprintManager sprintManager = new SprintManager();

    @Override
    public void onInitialize() {

        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            sprintManager.handleSprint(client);
        });

    }

}