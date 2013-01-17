package gibbycraft.blocks.plants;

import java.util.Random;

import gibbycraft.Gibbycraft;
import gibbycraft.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockTomatoCrop extends Block
{

	public BlockTomatoCrop(int id, int par2) 
	{
		super(id, par2, Material.plants);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
        setTickRandomly(true);
	}
	
	  @Override
	    public AxisAlignedBB getCollisionBoundingBoxFromPool (World world, int x,
	            int y, int z) {
	        return null;
	    }

	    @Override
	    public int getRenderType () {
	        return 6;
	    }

	    @Override
	    public boolean isOpaqueCube () {
	        return false;
	    }

	    @Override
	    public int getBlockTextureFromSideAndMetadata (int side, int metadata) 
	    {
	    	//TODO figure out how I can make this correspond to the individual png files
	        return 0 + metadata;
	    }

	    @Override
	    public void updateTick (World world, int x, int y, int z, Random random) 
	    {
	    	
	    	super.updateTick(world, x, y, z, random);
	    	if (world.getBlockLightValue(x, y + 1, z) >= 9)
	    	{
	    	int i = world.getBlockMetadata(x, y, z);
	    	if (i < 8)
	    	{
	    	        float f = 1.0F;
	    	        if (random.nextInt((int)(25F / f) + 1) == 0)
	    	        {
	    	         i++;
	    	         world.setBlockMetadataWithNotify(x, y, z, i);
	    	        }
	    	}
	    	}

	    }

	    @Override
	    public void onNeighborBlockChange (World world, int x, int y, int z,
	            int neighborId) {
	        if (!canBlockStay(world, x, y, z)) {
	            dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
	            world.setBlockWithNotify(x, y, z, 0);
	        }
	    }

	    @Override
	    public boolean canBlockStay (World world, int x, int y, int z) {
	        Block soil = blocksList[world.getBlockId(x, y - 1, z)];
	        return (world.getFullBlockLightValue(x, y, z) >= 8 || world
	                .canBlockSeeTheSky(x, y, z))
	                && (soil != null && soil.canSustainPlant(world, x, y - 1, z,
	                        ForgeDirection.UP, Gibbycraft.ItemTomatoSeed));
	    }

	    @Override
	    public int idDropped (int metadata, Random random, int par2) {
	        switch (metadata) {
	        case 0:
	            return Gibbycraft.TomatoSeedID;
	        case 1:
	            return Gibbycraft.TomatoID;
	        default:
	            // Error case!
	            return -1; // air
	        }
	    }

	    @Override
	    public int idPicked (World world, int x, int y, int z) {
	        return Gibbycraft.TomatoSeedID;
	    }
	

}
