package net.d1g1byt3.anniescafe.datagen;

import net.d1g1byt3.anniescafe.AnniesCafeMod;
import net.d1g1byt3.anniescafe.block.ModBlocks;
import net.d1g1byt3.anniescafe.block.crops.ModCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Function;

public class ModBlocksStateProvider extends BlockStateProvider {
    public ModBlocksStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AnniesCafeMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        
        makeBushCrop(((ModCropBlock) ModBlocks.COFFEE_CROP.get()), "coffee_bush_stage", "coffee_bush_stage");

    }

    public void makeCrop(CropBlock block, String modelName, String textureName){
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName,textureName);

        getVariantBuilder(block).forAllStates(function);

    }

    public void makeBushCrop(CropBlock block, String modelName, String textureName){
        Function<BlockState, ConfiguredModel[]> function = state -> states1(state, block, modelName,textureName);

        getVariantBuilder(block).forAllStates(function);

    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName){
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ModCropBlock) block).getAgeProperty()),
        new ResourceLocation(AnniesCafeMod.MOD_ID, "block/" + textureName + state.getValue(((ModCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private ConfiguredModel[] states1(BlockState state, CropBlock block, String modelName, String textureName){
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(((ModCropBlock) block).getAgeProperty()),
                new ResourceLocation(AnniesCafeMod.MOD_ID, "block/" + textureName + state.getValue(((ModCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    

    private void customLamp(Block block, BooleanProperty property, String name) {
        getVariantBuilder(block).forAllStates(state -> {
            String name_on = name + "_on";
            if(state.getValue(property)) {

                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(name_on,
                        new ResourceLocation(AnniesCafeMod.MOD_ID, "block/" + name_on)))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(name,
                        new ResourceLocation(AnniesCafeMod.MOD_ID, "block/" +name)))};
            }
        });
        simpleBlockItem(block, models().cubeAll(name,
                new ResourceLocation(AnniesCafeMod.MOD_ID, "block/" + name + "_on")));
    }


    private void blockItem(RegistryObject<Block> blockRegistryObject,String appendix){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("anniescafe:block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath() + appendix));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("anniescafe:block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
