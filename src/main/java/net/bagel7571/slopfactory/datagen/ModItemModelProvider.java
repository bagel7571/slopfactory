package net.bagel7571.slopfactory.datagen;

import net.bagel7571.slopfactory.SlopFactory;
import net.bagel7571.slopfactory.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SlopFactory.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // basicItem(ModItems.ITEMNAME.get());
    }
}