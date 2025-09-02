package org.example.e.untitled6;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.MinecraftForge;

import java.awt.*;

public class Module {
    private final String name;
    private int keyCode;
    private boolean toggled;
    public Minecraft mc = Minecraft.getInstance();

    public Module(String name, int keyCode) {
        this.name = name;
        this.keyCode = keyCode;
    }

    public String getName() {
        return name;
    }

    public int getKey() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public void toggle() {
        toggled = !toggled;
        if (toggled) onEnable();
        else onDisable();
    }

    public boolean isToggled() {
        return toggled;
    }

    public void onEnable() {
        if (mc.player != null) {
            mc.player.sendMessage(new StringTextComponent("Enable " + name), mc.player.getUUID());
        }
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onDisable() {
        if (mc.player != null) {
            mc.player.sendMessage(new StringTextComponent("Disable " + name), mc.player.getUUID());
        }
        MinecraftForge.EVENT_BUS.unregister(this);
    }
}
