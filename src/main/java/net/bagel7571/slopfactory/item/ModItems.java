package net.bagel7571.slopfactory.item;

import net.bagel7571.slopfactory.SlopFactory;
import net.bagel7571.slopfactory.fluid.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SlopFactory.MOD_ID);

    //public static final DeferredItem<Item> LUMINOUS_JELLY = ITEMS.register("luminous_jelly",
    //        () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
