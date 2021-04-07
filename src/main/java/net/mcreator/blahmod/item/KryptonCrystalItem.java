
package net.mcreator.blahmod.item;

@BlahmodModElements.ModElement.Tag
public class KryptonCrystalItem extends BlahmodModElements.ModElement {

	@ObjectHolder("blahmod:krypton_crystal")
	public static final Item block = null;

	public KryptonCrystalItem(BlahmodModElements instance) {
		super(instance, 1725);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(CreativeTabBlahItemsItemGroup.tab).maxStackSize(64).isImmuneToFire().rarity(Rarity.COMMON));
			setRegistryName("krypton_crystal");
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
