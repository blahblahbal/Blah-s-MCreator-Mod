
package net.mcreator.blahmod.item;

@BlahmodModElements.ModElement.Tag
public class UraniumIngotItem extends BlahmodModElements.ModElement {

	@ObjectHolder("blahmod:uranium_ingot")
	public static final Item block = null;

	public UraniumIngotItem(BlahmodModElements instance) {
		super(instance, 1770);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(CreativeTabBlahItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("uranium_ingot");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
