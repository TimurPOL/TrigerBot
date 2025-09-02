package org.example.e.untitled6;

import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

public class BindHandler {
    private final Tr tr;

    public BindHandler(Tr tr) {
        this.tr = tr;
    }

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        String msg = event.getMessage();
        if (!msg.startsWith(".bind")) return;

        event.setCanceled(true);

        String[] parts = msg.split(" ");
        if (parts.length < 2) return;

        String keyName = parts[1].toUpperCase();
        int keyCode = getKeyCodeFromString(keyName);
        if (keyCode == -1) {
            if (tr.mc.player != null) {
                tr.mc.player.sendMessage(new net.minecraft.util.text.StringTextComponent("§cНеизвестная клавиша: " + keyName), tr.mc.player.getUUID());
            }
            return;
        }

        tr.setKeyCode(keyCode);
        if (tr.mc.player != null) {
            tr.mc.player.sendMessage(new net.minecraft.util.text.StringTextComponent("§aTr привязан к клавише " + keyName), tr.mc.player.getUUID());
        }
    }

    private int getKeyCodeFromString(String keyName) {
        if (keyName.length() == 1) {
            char c = keyName.charAt(0);
            if (c >= 'A' && c <= 'Z') return GLFW.GLFW_KEY_A + (c - 'A');
            if (c >= '0' && c <= '9') return GLFW.GLFW_KEY_0 + (c - '0');
        }

        switch (keyName) {
            case "SPACE": return GLFW.GLFW_KEY_SPACE;
            case "SHIFT": return GLFW.GLFW_KEY_LEFT_SHIFT;
            case "CTRL":  return GLFW.GLFW_KEY_LEFT_CONTROL;
            case "ALT":   return GLFW.GLFW_KEY_LEFT_ALT;
            case "ENTER": return GLFW.GLFW_KEY_ENTER;
        }
        return -1;
    }
}
