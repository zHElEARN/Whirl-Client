package tech.mcwhirl.modules.impl.Movement;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import tech.mcwhirl.events.EventUpdate;
import tech.mcwhirl.modules.Category;
import tech.mcwhirl.modules.Module;

public class NoSlow extends Module {
	
	public NoSlow(String name, String displayName, int color, int keyBind, Category category) {
		super(name, displayName, color, keyBind, category);
	}
	/*
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if (mc.thePlayer.onGround && mc.thePlayer.moveForward != 0 && (mc.thePlayer.isBlocking() || mc.thePlayer.isUsingItem())) {
			mc.thePlayer.motionX *= 1.4D;
			mc.thePlayer.motionY = 0.2D;
			mc.thePlayer.motionZ *= 1.4D;
		}
		
		if (mc.thePlayer.onGround && (mc.thePlayer.isBlocking() || mc.thePlayer.isUsingItem()) && mc.thePlayer.moveForward != 0) {
			mc.thePlayer.motionY = -1F;
		}
	}
	
	@Override
	public void onDisable() {
		EventManager.unregister(this);
	}
	
	@Override
	public void onEnable() {
		EventManager.register(this);
	}
	*/
}
