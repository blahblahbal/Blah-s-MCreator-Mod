
package net.mcreator.blahmod.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.blahmod.block.CedarSlabBlock;
import net.mcreator.blahmod.BlahmodModElements;

@BlahmodModElements.ModElement.Tag
public class CedarSlabFuelFuel extends BlahmodModElements.ModElement {
	public CedarSlabFuelFuel(BlahmodModElements instance) {
		super(instance, 709);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(CedarSlabBlock.block, (int) (1)).getItem())
			event.setBurnTime(150);
	}
}
