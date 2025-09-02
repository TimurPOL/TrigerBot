package org.example.e.untitled6;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Tr extends Module {
    private long t;

    public Tr(String name, int keyCode) {
        super(name, keyCode);
    }

    @SubscribeEvent
    public void onJump(LivingEvent.LivingJumpEvent event) {
            if (mc.hitResult instanceof EntityRayTraceResult ) {
                EntityRayTraceResult entityRay = (EntityRayTraceResult) mc.hitResult;
                Entity target = entityRay.getEntity();

                if (target instanceof LivingEntity && target != mc.player) {
                    long now = System.currentTimeMillis();
                    if (now - t >= 600) {
                        assert mc.gameMode != null;
                        assert mc.player != null;
                        if (mc.player.isOnGround()) {
                            mc.gameMode.attack(mc.player, target);
                            mc.player.swing(net.minecraft.util.Hand.MAIN_HAND);
                            t = now;
                        }
                    }
                }
            }
        }
    }
