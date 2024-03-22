package net.d1g1byt3.anniescafe.item;

import net.d1g1byt3.anniescafe.AnniesCafeMod;
import net.d1g1byt3.anniescafe.block.ModBlocks;
import net.d1g1byt3.anniescafe.item.food.ModFoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AnniesCafeMod.MOD_ID);


    //Custom Items



    //Food Items

    public static final RegistryObject<Item> COFFEE_CHERRIES = ITEMS.register("coffee_cherries",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COFFEE_CHERRIES)));

    public static final RegistryObject<Item> COFFEE_DRINK = ITEMS.register("coffee_drink",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COFFEE_DRINK)));

    public static final RegistryObject<Item> COFFEE_CHERRY_SEEDS = ITEMS.register("coffee_cherry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.COFFEE_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
}
