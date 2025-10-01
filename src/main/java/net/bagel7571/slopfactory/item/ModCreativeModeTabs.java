package net.bagel7571.slopfactory.item;

import net.bagel7571.slopfactory.SlopFactory;
import net.bagel7571.slopfactory.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SlopFactory.MOD_ID);

    public static final Supplier<CreativeModeTab> SLOP_FACTORY_TAB = CREATIVE_MODE_TAB.register("slop_factory_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MEAT_BLOCK.get()))
                    .title(Component.translatable("creativetab.slopfactory.slopfactorytab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.MEAT_BLOCK);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
