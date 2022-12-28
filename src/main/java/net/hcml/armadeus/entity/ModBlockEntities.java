package net.hcml.armadeus.entity;

import net.hcml.armadeus.ArmadeusMod;
import net.hcml.armadeus.block.ModBlocks;
import net.hcml.armadeus.event.ModEventClientBusEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITY_TYPES, ArmadeusMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY.register(eventBus);
    }
}
