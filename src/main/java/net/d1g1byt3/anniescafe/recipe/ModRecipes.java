package net.d1g1byt3.anniescafe.recipe;

import net.d1g1byt3.anniescafe.AnniesCafeMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AnniesCafeMod.MOD_ID);


    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
