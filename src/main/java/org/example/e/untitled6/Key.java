package org.example.e.untitled6;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

import java.util.concurrent.CopyOnWriteArrayList;

public class Key {
    public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<>();
    public Minecraft mc = Minecraft.getInstance();
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) {
        if (e.getAction() != GLFW.GLFW_PRESS) return;

        for (Module module : modules) {
            if (module.getKey() == e.getKey()) {
                module.toggle();
            }
        }
    }


    public static void startup() {
        modules.add(new Tr("Tr", GLFW.GLFW_KEY_X));
    }
}
