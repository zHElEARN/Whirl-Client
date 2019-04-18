package tech.mcwhirl.modules.impl.Movement;

import com.darkmagician6.eventapi.EventTarget;

import tech.mcwhirl.events.EventUpdate;
import tech.mcwhirl.modules.Category;
import tech.mcwhirl.modules.Module;

public class Fly extends Module {

	public Fly(String name, String displayName, int color, int keyBind, Category category) {
		super(name, displayName, color, keyBind, category);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		mc.thePlayer.capabilities.isFlying = true;
	}
	
	@Override
	public void onEnable() {
		mc.thePlayer.capabilities.isFlying = true;
	}
	
	@Override
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
	}

}
