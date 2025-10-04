package net.bagel7571.slopfactory.block;

import net.bagel7571.slopfactory.SlopFactory;
import net.bagel7571.slopfactory.fluid.ModFluids;
import net.bagel7571.slopfactory.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(SlopFactory.MOD_ID);

    public static final DeferredBlock<Block> MEAT_BLOCK = registerBlock("meat_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_WHITE).strength(0.8F).sound(SoundType.CORAL_BLOCK)));

    public static final DeferredHolder<Block, LiquidBlock> MEAT_EMULSION_BLOCK =
            BLOCKS.register("meat_emulsion_block",
                    () -> new LiquidBlock(ModFluids.MEAT_EMULSION_SOURCE.get(),
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_PINK)
                                    .strength(100.0f)
                                    .noLootTable()
                                    .noCollission()
                                    .replaceable()
                                    .liquid()));





    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
