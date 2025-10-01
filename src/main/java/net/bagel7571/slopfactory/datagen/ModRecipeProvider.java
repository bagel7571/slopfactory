package net.bagel7571.slopfactory.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        //ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLATRA.get())
        //        .pattern("PIP")
        //        .pattern("IPI")
        //        .pattern("PIP")
        //        .define('P', Items.PRISMARINE_SHARD)
        //        .define('I', Items.PACKED_ICE)
        //        .unlockedBy("has_prismarine", has(Items.PRISMARINE_SHARD))
        //        .save(recipeOutput);

    }
}