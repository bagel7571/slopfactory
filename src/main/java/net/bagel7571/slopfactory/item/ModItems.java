package net.bagel7571.slopfactory.item;

import net.bagel7571.slopfactory.SlopFactory;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SlopFactory.MOD_ID);

    //public static final DeferredItem<Item> LUMINOUS_JELLY = ITEMS.register("luminous_jelly",
    //        () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
