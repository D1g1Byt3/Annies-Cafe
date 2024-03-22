package net.d1g1byt3.anniescafe.datagen;

import net.d1g1byt3.anniescafe.AnniesCafeMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AnniesCafeMod.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
       // this.tag(ModTags.Blocks.ORE_DETECTOR_VALUABLES)
               // .add(ModBlocks.ALEXANDRITE_ORE.get()).addTags(Tags.Blocks.ORES);

        //this.tag(BlockTags.MINEABLE_WITH_PICKAXE)


        //this.tag(BlockTags.NEEDS_IRON_TOOL)


        //this.tag(BlockTags.NEEDS_DIAMOND_TOOL)


        this.tag(BlockTags.FENCES);
                //.add(ModBlocks.ALEXANDRITE_FENCE.get());

        this.tag(BlockTags.FENCE_GATES);
               // .add(ModBlocks.ALEXANDRITE_FENCE_GATE.get());

        this.tag(BlockTags.WALLS);
                //.add(ModBlocks.ALEXANDRITE_WALL.get());
    }

    @Override
    public @NotNull String getName() {
        return "Block Tags";
    }
}
