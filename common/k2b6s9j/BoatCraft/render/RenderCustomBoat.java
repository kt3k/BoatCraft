package k2b6s9j.BoatCraft.render;

import k2b6s9j.BoatCraft.entity.item.EntityCustomBoat;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderBoat;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderCustomBoat extends RenderBoat {

    /** instance of ModelBoat for rendering */
    protected ModelBase modelBoat;
    
    protected final RenderBlocks renderBlocks;

    public RenderCustomBoat()
    {
        this.shadowSize = 0.5F;
        this.modelBoat = new ModelBoat();
        this.renderBlocks = new RenderBlocks();
    }
    
    public void renderBoat(EntityCustomBoat boat, double par2, double par4, double par6, float par8, float par9) {
    	GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glRotatef(180.0F - par8, 0.0F, 1.0F, 0.0F);
        float f2 = (float)boat.getTimeSinceHit() - par9;
        float f3 = boat.getDamageTaken() - par9;

        if (f3 < 0.0F)
        {
            f3 = 0.0F;
        }

        if (f2 > 0.0F)
        {
            GL11.glRotatef(MathHelper.sin(f2) * f2 * f3 / 10.0F * (float)boat.getForwardDirection(), 1.0F, 0.0F, 0.0F);
        }

        float f4 = 0.75F;
        GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
        this.func_110777_b(boat);
        
        int j = boat.getDisplayTileOffset();
        Block block = boat.getDisplayTile();
        int k = boat.getDisplayTileData();

        if (block != null)
        {
            GL11.glPushMatrix();
            this.func_110776_a(TextureMap.field_110575_b);
            float f8 = 0.75F;
            GL11.glScalef(f8, f8, f8);
            GL11.glTranslatef(0.0F, (float)j / 16.0F, 0.0F);
            this.renderBlockInBoat(boat, par9, block, k);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.func_110777_b(boat);
        }
        
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.modelBoat.render(boat, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public static ResourceLocation texture(EntityCustomBoat par1EntityBoat, ResourceLocation resource)
    {
        return resource;
    }

    public ResourceLocation texture(Entity par1Entity)
    {
        return this.func_110781_a((EntityCustomBoat)par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderBoat((EntityCustomBoat)par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected void renderBlockInBoat(EntityCustomBoat entityBoat, float par2, Block par3Block, int par4)
    {
    	// TODO Look into boat brightness later
    	//float f1 = entityBoat.getBrightness(par2);
        GL11.glPushMatrix();
        //this.renderBlocks.renderBlockAsItem(par3Block, par4, f1);
        this.renderBlocks.renderBlockAsItem(par3Block, par4, 0);
        GL11.glPopMatrix();
    }
}
