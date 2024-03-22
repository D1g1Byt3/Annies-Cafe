package net.d1g1byt3.anniescafe.datagen.loot;


import net.d1g1byt3.anniescafe.block.ModBlocks;
import net.d1g1byt3.anniescafe.block.crops.ModCropBlock;
import net.d1g1byt3.anniescafe.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {


        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.COFFEE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ModCropBlock.AGE, 6));
        this.add(ModBlocks.COFFEE_CROP.get(), this.createCropDrops(ModBlocks.COFFEE_CROP.get(), ModItems.COFFEE_CHERRIES.get(),
                ModItems.COFFEE_CHERRY_SEEDS.get(), lootitemcondition$builder2));

    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
