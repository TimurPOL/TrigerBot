package org.example.e.untitled6;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lwjgl.glfw.GLFW;

@Mod("untitled6")
public class Untitled6 {
    public static Tr tr;

    public Untitled6() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        tr = new Tr("Tr", GLFW.GLFW_KEY_X);

        MinecraftForge.EVENT_BUS.register(new BindHandler(tr));

        MinecraftForge.EVENT_BUS.register(new Key());

        Key.modules.add(tr);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }
}
