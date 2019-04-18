package tech.mcwhirl.modules.impl.Render;

import com.darkmagician6.eventapi.EventTarget;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import tech.mcwhirl.modules.Category;
import tech.mcwhirl.modules.Module;
import tech.mcwhirl.utils.RenderUtils;

public class Tracers extends Module {

	public Tracers(String name, String displayName, int color, int keyBind, Category category) {
		super(name, displayName, color, keyBind, category);
	}
	
	@Override
	public void onRender() {
		
		if (!this.isEnabled()) return;

		for (Object theObject : mc.theWorld.loadedEntityList) {
			if (!(theObject instanceof EntityLivingBase))
				continue;
			EntityLivingBase entity = (EntityLivingBase)theObject;
			
			if (entity instanceof EntityPlayer) {
				if (entity != mc.thePlayer)
					player(entity);
				continue;
			}
			if (entity instanceof EntityMob) {
				mob(entity);
				continue;
			}
			if (entity instanceof EntityAnimal) {
				animal(entity);
				continue;
			}
			
			passive(entity);
			
		}
		
		super.onRender();
	}
	

	public void player(EntityLivingBase entity) {
		float red = 0.5F;
		float green = 0.5F;
		float blue = 1F;
		
		double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;
		double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
		double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;
	
		render(red, green, blue, xPos, yPos, zPos);
	}
	
	public void mob(EntityLivingBase entity) {
		float red = 0.5F;
		float green = 0.5F;
		float blue = 1F;
		
		double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;
		double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
		double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;
	
		render(red, green, blue, xPos, yPos, zPos);
	}
	
	public void animal(EntityLivingBase entity) {
		float red = 0.5F;
		float green = 1F;
		float blue = 0.5F;
		
		double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;
		double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
		double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;
	
		render(red, green, blue, xPos, yPos, zPos);
	}
	
	public void passive(EntityLivingBase entity) {
		float red = 0.5F;
		float green = 0.5F;
		float blue = 0.5F;
		
		double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;
		double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
		double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;
	
		render(red, green, blue, xPos, yPos, zPos);
	}
	
	public void render(float red, float green, float blue, double xPos, double yPos, double zPos) {
		RenderUtils.drawTracerLine(xPos, yPos, zPos, red, green, blue, 0.45F, 1F);
	}
}
