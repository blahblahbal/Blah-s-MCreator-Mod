
package net.mcreator.blahmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.feature.RandomPatchFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Direction;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.item.TallBlockItem;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.blahmod.itemgroup.CreativeTabBlahBlocksItemGroup;
import net.mcreator.blahmod.BlahmodModElements;

import java.util.Random;

@BlahmodModElements.ModElement.Tag
public class EtherealDoubleTallGrassBlock extends BlahmodModElements.ModElement {
	@ObjectHolder("blahmod:ethereal_double_tall_grass")
	public static final Block block = null;
	public EtherealDoubleTallGrassBlock(BlahmodModElements instance) {
		super(instance, 1824);
		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FeatureRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(() -> new TallBlockItem(block, new Item.Properties().group(CreativeTabBlahBlocksItemGroup.tab))
				.setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	private static Feature<BlockClusterFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;
	private static class FeatureRegisterHandler {
		@SubscribeEvent
		public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			feature = new RandomPatchFeature(BlockClusterFeatureConfig.field_236587_a_) {
				@Override
				public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, BlockClusterFeatureConfig config) {
					RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
					boolean dimensionCriteria = false;
					if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("blahmod:skylands")))
						dimensionCriteria = true;
					if (!dimensionCriteria)
						return false;
					return super.generate(world, generator, random, pos, config);
				}
			};
			configuredFeature = feature.withConfiguration(
					(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(block.getDefaultState()), new DoublePlantBlockPlacer()))
							.tries(64).build())
					.withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8, 0, 5)));
			event.getRegistry().register(feature.setRegistryName("ethereal_double_tall_grass"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("blahmod:ethereal_double_tall_grass"), configuredFeature);
		}
	}
	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("blahmod:ethereal_glade").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> configuredFeature);
	}
	public static class BlockCustomFlower extends DoublePlantBlock {
		public BlockCustomFlower() {
			super(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT).hardnessAndResistance(0f, 0f)
					.setLightLevel(s -> 0));
			setRegistryName("ethereal_double_tall_grass");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 100;
		}

		@Override
		public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 60;
		}

		@Override
		public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
			Block block = state.getBlock();
			return (block == EtherealGrassBlockBlock.block.getDefaultState().getBlock());
		}

		@Override
		public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
			BlockPos blockpos = pos.down();
			BlockState blockstate = worldIn.getBlockState(blockpos);
			if (state.get(HALF) == DoubleBlockHalf.UPPER)
				return blockstate.isIn(this) && blockstate.get(HALF) == DoubleBlockHalf.LOWER;
			else
				return this.isValidGround(blockstate, worldIn, blockpos);
		}

		@Override
		public PlantType getPlantType(IBlockReader world, BlockPos pos) {
			return PlantType.PLAINS;
		}
	}
}
