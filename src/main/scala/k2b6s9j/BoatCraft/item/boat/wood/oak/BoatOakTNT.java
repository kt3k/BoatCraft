package k2b6s9j.BoatCraft.item.boat.wood.oak;

import cpw.mods.fml.common.registry.GameRegistry;
import k2b6s9j.BoatCraft.entity.boat.EntityCustomBoat;
import k2b6s9j.BoatCraft.entity.boat.wood.oak.EntityBoatOakTNT;
import k2b6s9j.BoatCraft.item.boat.ItemCustomBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class BoatOakTNT extends ItemCustomBoat {
	
	public static int ID;
	public static int shiftedID;
	
	public BoatOakTNT(int id) {
		super(id);
		setUnlocalizedName("boat.wood.oak.tnt");
        func_111206_d("boatcraft:boat.wood.oak.tnt");
    	GameRegistry.registerItem(this, "Oak TNT Boat");
    	shiftedID = this.itemID;
    	OreDictionary.registerOre("itemBoat", new ItemStack(this));
    	OreDictionary.registerOre("boat", new ItemStack(this));
    	OreDictionary.registerOre("boatOak", new ItemStack(this));
    	OreDictionary.registerOre("boatTNT", new ItemStack(this));
    	OreDictionary.registerOre("boatOakTNT", new ItemStack(this));
	}
	
	@Override
	public EntityCustomBoat getEntity(World world, int x, int y, int z) {
		EntityBoatOakTNT entity = new EntityBoatOakTNT(world, (double)((float)x + 0.5F), (double)((float)y + 1.0F), (double)((float)z + 0.5F));
		return entity;
	}
}