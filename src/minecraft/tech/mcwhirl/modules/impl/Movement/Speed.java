package tech.mcwhirl.modules.impl.Movement;

import java.util.ArrayList;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import de.Hero.settings.Setting;
import net.minecraft.util.MathHelper;
import tech.mcwhirl.Whirl;
import tech.mcwhirl.events.EventUpdate;
import tech.mcwhirl.modules.Category;
import tech.mcwhirl.modules.Module;

public class Speed extends Module {

	public static String mode = "Timer";
	private double prevY = 0;
	private int i = 0;
	
	public Speed(String name, String displayName, int color, int keyBind, Category category) {
		super(name, displayName, color, keyBind, category);
	}
	
	@Override
	public void setup() {
		ArrayList<String> options = new ArrayList<String>();
		options.add("Y-Port");
		options.add("Timer");
		Whirl.instance.setmgr.rSetting(new Setting("Mode", this, "Timer", options));
		Whirl.instance.setmgr.rSetting(new Setting("Timer Speed", this, 2, 1, 10, false));
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		
		if (Whirl.instance.setmgr.getSettingByName("Mode").getValString().equalsIgnoreCase("Y-Port")) {
			mode = "Y-Port";
		}
		
		if (Whirl.instance.setmgr.getSettingByName("Mode").getValString().equalsIgnoreCase("Timer")) {
			mode = "Timer";
		}
		
		if (mode.equalsIgnoreCase("Y-Port")) {
			this.setDisplayName("Speed [Y-Port]");
			yPort();
		}
		
		if (mode.equalsIgnoreCase("Timer")) {
			this.setDisplayName("Speed [Timer]");
			timer();
		}
	}
	
	public void yPort() {
		if(mc.thePlayer.onGround) {
			mc.thePlayer.jump();
		} else {
			mc.thePlayer.motionY = -0.42D;
		}
	}
	
	public void timer() {
		mc.timer.timerSpeed = (float)Whirl.instance.setmgr.getSettingByName("Timer Speed").getValDouble();
	}
	
	public void setSpeed(float speed) {
		mc.thePlayer.motionX = (-(Math.sin(this.getPlayerDirection()) * speed));
		mc.thePlayer.motionZ = (Math.cos(this.getPlayerDirection() * speed));
		mc.thePlayer.setPositionAndUpdate(mc.thePlayer.posX - (double)(MathHelper.sin(this.getPlayerDirection() * 0.0005F)), this.prevY, mc.thePlayer.posZ + (double) (MathHelper.cos(this.getPlayerDirection() * 0.0005F)));
	}
	
	public float getPlayerDirection() {
		float yaw = mc.thePlayer.rotationYaw;
		if(mc.thePlayer.moveForward < 0.0F) {
			yaw += 180.0F;
		}
		
		float forward = 1.0F;
		
		if(mc.thePlayer.moveForward < 0.0F) {
			forward = -0.5F;
		} else if(mc.thePlayer.moveForward > 0.0F) {
			forward = 0.5F;
		}
		
		if(mc.thePlayer.moveStrafing > 0.0F) {
			yaw -= 90.0F * forward;
		}
		
		if(mc.thePlayer.moveStrafing < 0.0F) {
			yaw += 90.0F * forward;
		}
		
		yaw *= 0.01598576234F;
		
		return yaw;
	}

	@Override
	public void onEnable() {
		EventManager.register(this);
	}
	
	@Override
	public void onDisable() {
		EventManager.unregister(this);
		mc.timer.timerSpeed = 1F;
	}
	
}