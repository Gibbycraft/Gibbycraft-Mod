/**
 * @author Gibby
 */

package gibbycraft.items.food;

import net.minecraft.src.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;

public class ItemBreakfastBurrito extends ItemFood
{

	/**
	 * 
	 * @param par1 item ID
	 * @param par2 # of half drumsticks filled
	 * @param par3 saturation (higher = more time before the hunger returns)
	 * @param par4 can a wolf omnomnom it? 
	 */
	public ItemBreakfastBurrito(int par1, int par2, float par3, boolean par4) 
	{
		super(par1, par2, par3, par4);

		//Wanna see a cool trick that gets this into the creative food tab?
		this.setCreativeTab(CreativeTabs.tabFood);
	}

	/**
	 * @return the location of the image, used by ClientProxy
	 */
	public String getTextureFile()
	{
		return "/gibbycraft/gui/BreakfastBurrito.png";
	}
}
