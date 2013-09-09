package gibbycraft.items.plants;

import gibbycraft.Gibbycraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSeeds;

public class ItemTomatoSeed extends ItemSeeds
{

	public ItemTomatoSeed(int id, int plantId, int soilId) 
	{
		super(id, plantId, soilId);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	/**
	 * Overrides the client proxy's need to register the texture. 
	 * @param icon The request for the icon
	 */
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		this.itemIcon = icon.registerIcon(Gibbycraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
		
	}

}
