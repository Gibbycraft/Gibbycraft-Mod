/**
 * @author Gibby
 */

package gibbycraft.items.food;

import gibbycraft.Gibbycraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.src.*;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;

public class ItemCheeseburger extends ItemFood
{

	/**
	 * 
	 * @param par1 item ID
	 * @param par2 # of half drumsticks filled
	 * @param par3 saturation (higher = more time before the hunger returns)
	 * @param par4 can a wolf omnomnom it? 
	 */
	public ItemCheeseburger(int par1, int par2, float par3, boolean par4) 
	{
		super(par1, par2, par3, par4);

		//Wanna see a cool trick that gets this into the creative food tab?
		this.setCreativeTab(CreativeTabs.tabFood);
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
