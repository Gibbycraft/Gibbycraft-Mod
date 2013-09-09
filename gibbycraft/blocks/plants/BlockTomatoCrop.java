package gibbycraft.blocks.plants;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import gibbycraft.Gibbycraft;
import gibbycraft.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockTomatoCrop extends BlockFlower
{

	private int seedID;
	private int cropID;
	private Icon[] iconArray;
	
	/**
	 * Creates the crop
	 * @param id The ID of this block
	 * @param seed The ID of the seed that makes this block
	 * @param crop The ID of the item this block drops when grown
	 */ 
	public BlockTomatoCrop(int id, int seed, int crop) 
	{
		super(id);
		seedID=seed;
		cropID=crop;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F); //dimensions, min X, minY, minZ, maxX, maxY, maxZ
        this.setTickRandomly(true); //grows at a random time
        this.disableStats(); //otherwise, you would be such flowerchild when you check stats&achievements
	}

		/**
		 * Minecraft has a lot of ways it can render blocks. Use 6 for plants, don't ask what the others are
		 */
	    public int getRenderType () 
	    {
	        return 6;
	    }
	    
	    /**
	     * Returns the crop ID
	     * @return The ID of the crop
	     */
	    protected int getCropID()
	    {
	    	return cropID;
	    }
	    
	    /**
	     * Returns the seed ID
	     * @return The ID of the seed
	     */
	    protected int getSeedID()
	    {
	    	return seedID;
	    }

	    /**
	     * Do I really have to explain what this does?
	     */
	    protected boolean canThisPlantGrowOnThisBlockID(int id)
	    {
	    	return id==Block.tilledField.blockID;
	    }

	    /**
	     * Every tick in game, do this. Note the Random random part, that will determine how it grows.
	     */
	    public void updateTick (World world, int x, int y, int z, Random random) 
	    {
	    	
	    	super.updateTick(world, x, y, z, random);
	    	if (world.getBlockLightValue(x, y + 1, z) >= 9) // kill it if there isn't any light
	    	{
		    	int i = world.getBlockMetadata(x, y, z);
		    	if (i < 7) // 0-7, which is all 8 textures
		    	{
		    	        float f = 1.0F;
		    	        if (random.nextInt((int)(25F / f) + 1) == 0)
		    	        {
		    	         i++;
		    	         world.setBlockMetadataWithNotify(x, y, z, i, 2); //change the block metadata (grow it), with a flag of type 2 in the world
		    	        }
		    	}
	    	}

	    }

	    /**
	     * This big, bad and messy code block determines if the conditions are right for the block to stay.
	     * In this case, if the soil is still good and there is enough light, the plant can live
	     */
	    public boolean canBlockStay (World world, int x, int y, int z) {
	        Block soil = blocksList[world.getBlockId(x, y - 1, z)];
	        return (world.getFullBlockLightValue(x, y, z) >= 8 || world
	                .canBlockSeeTheSky(x, y, z))
	                && (soil != null && soil.canSustainPlant(world, x, y - 1, z,
	                        ForgeDirection.UP, Gibbycraft.ItemTomatoSeed));
	    }
	    
	    /**
	     * What happens when bonemeal is applied. Grow the block from 2-5 steps, randomly.
	     * @param world The world the block is in
	     * @param x X position of the block
	     * @param y Y position of the block
	     * @param z Z position of the block
	     */
	    public void fertilize(World world, int x, int y, int z)
	    {
	    	int metadata = (world.getBlockMetadata(x, y, z) + MathHelper.getRandomIntegerInRange(world.rand, 2, 5)); // grow from 2-5 steps
	    	if (metadata>7)
	    		metadata=7;
	    	world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
	    	
	    }
	    
	    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int chance, float rate, int inc)
	    {
	    	super.dropBlockAsItemWithChance(world, x, y, z, chance, rate, inc);
	    	if(!world.isRemote) //checking to see if we are server or client side
	    	{
	    		if(chance>=7)
	    		{
	    			int temp = 3+chance;
	    			for(int i=0; i<temp; ++i)
	    			{
	    				if(world.rand.nextInt(15)<=chance)
	    				{
	    					this.dropBlockAsItem_do(world, x, y, z, new ItemStack(this.getSeedID(), 1, 0)); //drop a seed
	    				}
	    			}
	    		}
	    	}
	    }

	    /**
	     * Drop the item 
	     */
	    public int idDropped (int metadata, Random random, int par2) 
	    {
	    		if(metadata==7) //grown
	    		{
	    			return this.getCropID();
	    		}
	    		else
	    		{
	    			return this.getSeedID();
	    		}
	    }
	    
	    /**
	     * Drop this many items
	     */
	    public int quantityDropped(Random random)
	    {
	    	return 1;
	    }
	    
	    @SideOnly(Side.CLIENT)
	    public Icon getIcon(int side, int metadata)
	    {
	    	if(metadata<0 || metadata>7)
	    		metadata=7;
	    	return this.iconArray[metadata];
	    }

	    /**
	     * Used by creative mode middle mouse button
	     */
	    public int idPicked (World world, int x, int y, int z) {
	        return Gibbycraft.TomatoSeedID;
	    }
	    
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister icons)
	    {
	    	this.iconArray = new Icon[8];
	    	for(int i=0; i<this.iconArray.length; ++i) //note that this skips index 0
	    	{
	    		this.iconArray[i] = icons.registerIcon(Gibbycraft.modid + ":" + (this.getUnlocalizedName().substring(5))+i);
	    	}
	    }
	

}
