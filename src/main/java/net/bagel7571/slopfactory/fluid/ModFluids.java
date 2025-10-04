package net.bagel7571.slopfactory.fluid;

import net.bagel7571.slopfactory.SlopFactory;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, SlopFactory.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, SlopFactory.MOD_ID);
    public static final DeferredRegister<Item> BUCKETS = DeferredRegister.createItems(SlopFactory.MOD_ID);
    public static final DeferredRegister<Block> SOURCEBLOCKS = DeferredRegister.createBlocks(SlopFactory.MOD_ID);

    public static final DeferredHolder<FluidType, FluidType> MEAT_EMULSION_TYPE = FLUID_TYPES.register("meat_emulsion",
            () -> new FluidType(FluidType.Properties.create().descriptionId("fluid.meatemulsion")));

    public static final DeferredHolder<Fluid, FlowingFluid> MEAT_EMULSION_SOURCE = FLUIDS.register("meat_emulsion_source",
            () -> new BaseFlowingFluid.Source(liquidProperties()));
    public static final DeferredHolder<Fluid, FlowingFluid> MEAT_EMULSION_FLOWING = FLUIDS.register("meat_emulsion_flowing",
            () -> new BaseFlowingFluid.Flowing(liquidProperties()));

    public static final DeferredHolder<Item, BucketItem> MEAT_EMULSION_BUCKET = BUCKETS.register("meat_emulsion_bucket",
            () -> new BucketItem(MEAT_EMULSION_SOURCE.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Block, LiquidBlock> MEAT_EMULSION_BLOCK = SOURCEBLOCKS.register("meat_emulsion_block",
            () -> new LiquidBlock(MEAT_EMULSION_SOURCE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        FLUIDS.register(eventBus);
        BUCKETS.register(eventBus);
        SOURCEBLOCKS.register(eventBus);
        eventBus.addListener(ModFluids::clientExt);
    }

    public static final IClientFluidTypeExtensions liquidExt = new IClientFluidTypeExtensions() {
        @Override
        public ResourceLocation getStillTexture() {
            return ResourceLocation.fromNamespaceAndPath(SlopFactory.MOD_ID, "block/meat_emulsion_still");
        }

        @Override
        public ResourceLocation getFlowingTexture() {
            return ResourceLocation.fromNamespaceAndPath(SlopFactory.MOD_ID, "block/meat_emulsion_flowing");
        }
    };

    private static void clientExt(RegisterClientExtensionsEvent event) {
        event.registerFluidType(liquidExt, MEAT_EMULSION_TYPE.get());
    }


    private static Properties liquidProperties() {
        return new Properties(MEAT_EMULSION_TYPE, MEAT_EMULSION_SOURCE, MEAT_EMULSION_FLOWING).bucket(MEAT_EMULSION_BUCKET).block(MEAT_EMULSION_BLOCK);
    }
}
