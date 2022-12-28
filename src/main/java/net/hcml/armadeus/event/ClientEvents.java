package net.hcml.armadeus.event;

import net.hcml.armadeus.ArmadeusMod;
import net.hcml.armadeus.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArmadeusMod.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event){
        Player player = Minecraft.getInstance().player;
        if(KeyBinding.PRONE_KEY.consumeClick()) {
            if(player.isOnGround()) {
                System.out.println("242353454");
            }
        }
    }
    @SubscribeEvent
    public static void onPlayerVitalsChange(CustomEvents.onPlayerVitalsChange event) {
        Player player = event.getPlayer();
        System.out.println(player.is(Minecraft.getInstance().player));
    }
}
