
package net.mcreator.blahmod.block;

import net.minecraft.block.material.Material;

@BlahmodModElements.ModElement.Tag
public class XenonCrystalClusterBlock extends BlahmodModElements.ModElement {

	@ObjectHolder("blahmod:xenon_crystal_cluster")
	public static final Block block = null;

	public XenonCrystalClusterBlock(BlahmodModElements instance) {
		super(instance, 1723);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(CreativeTabBlahBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.SHROOMLIGHT).hardnessAndResistance(0.9f, 0f).setLightLevel(s -> 8)
							.doesNotBlockMovement().notSolid().setOpaque((bs, br, bp) -> false));

			setRegistryName("xenon_crystal_cluster");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public MaterialColor getMaterialColor() {
			return MaterialColor.DIAMOND;
		}

	}

}
