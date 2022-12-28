package net.hcml.armadeus;

import com.mojang.logging.LogUtils;
import net.hcml.armadeus.block.ModBlocks;
import net.hcml.armadeus.entity.ModBlockEntities;
import net.hcml.armadeus.item.ModItems;
import net.hcml.armadeus.networking.ModMessage;
import net.hcml.armadeus.sounds.ModSounds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(ArmadeusMod.MOD_ID)
public class ArmadeusMod
{
    public static final String MOD_ID = "armadeus";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ArmadeusMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModMessage.register();
    }
}
