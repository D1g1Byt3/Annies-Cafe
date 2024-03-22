package net.d1g1byt3.anniescafe.entity;

import net.d1g1byt3.anniescafe.AnniesCafeMod;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AnniesCafeMod.MOD_ID);


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
