
package net.mcreator.blahmod.block;

import net.minecraft.block.material.Material;

@BlahmodModElements.ModElement.Tag
public class KryptonCrystalOreBlock extends BlahmodModElements.ModElement {

	@ObjectHolder("blahmod:krypton_crystal_ore")
	public static final Block block = null;

	public KryptonCrystalOreBlock(BlahmodModElements instance) {
		super(instance, 1736);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(CreativeTabBlahBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2f, 6f).setLightLevel(s -> 0).harvestLevel(1)
							.harvestTool(ToolType.PICKAXE).setRequiresTool());

			setRegistryName("krypton_crystal_ore");
		}

	}

}
