
package net.mcreator.blahmod.item;

@BlahmodModElements.ModElement.Tag
public class ArgonCrystalItem extends BlahmodModElements.ModElement {

	@ObjectHolder("blahmod:argon_crystal")
	public static final Item block = null;

	public ArgonCrystalItem(BlahmodModElements instance) {
		super(instance, 1724);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(CreativeTabBlahItemsItemGroup.tab).maxStackSize(64).isImmuneToFire().rarity(Rarity.COMMON));
			setRegistryName("argon_crystal");
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