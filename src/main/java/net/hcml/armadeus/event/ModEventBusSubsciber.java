package net.hcml.armadeus.event;

import net.hcml.armadeus.ArmadeusMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

@Mod.EventBusSubscriber(modid = ArmadeusMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusSubsciber {

}
