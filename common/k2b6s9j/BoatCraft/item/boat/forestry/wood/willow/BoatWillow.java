package k2b6s9j.BoatCraft.item.boat.forestry.wood.willow;

import k2b6s9j.BoatCraft.entity.boat.EntityCustomBoat;
import k2b6s9j.BoatCraft.entity.boat.forestry.wood.willow.EntityBoatWillow;
import k2b6s9j.BoatCraft.item.boat.ItemCustomBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class BoatWillow extends ItemCustomBoat {

	public static int ID;
	public static int shiftedID;
	
	public BoatWillow(int id) {
		super(id);
		setUnlocalizedName("boat.forestry.wood.willow.empty");
        func_111206_d("boatcraft:boat.forestry.wood.willow.empty");
    	GameRegistry.registerItem(this, "Willow Wood Boat");
    	shiftedID = this.itemID;
    	OreDictionary.registerOre("itemBoat", new ItemStack(this));
    	OreDictionary.registerOre("boat", new ItemStack(this));
    	OreDictionary.registerOre("boatWillow", new ItemStack(this));
	}
	
	@Override
	public EntityCustomBoat getEntity(World world, int x, int y, int z) {
		EntityBoatWillow entity = new EntityBoatWillow(world, (double)((float)x + 0.5F), (double)((float)y + 1.0F), (double)((float)z + 0.5F));
		return entity;
	}
}
