package net.bagel7571.slopfactory.datagen;

import net.bagel7571.slopfactory.SlopFactory;
import net.bagel7571.slopfactory.block.ModBlocks;
import net.bagel7571.slopfactory.fluid.ModFluids;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SlopFactory.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MEAT_BLOCK);
        simpleBlock(ModFluids.MEAT_EMULSION_BLOCK.get(),
                new ModelFile.UncheckedModelFile("slopfactory:block/meat_emulsion_block"));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
