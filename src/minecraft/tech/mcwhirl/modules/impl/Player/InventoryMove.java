package tech.mcwhirl.modules.impl.Player;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiChat;
import tech.mcwhirl.events.EventUpdate;
import tech.mcwhirl.modules.Category;
import tech.mcwhirl.modules.Module;

public class InventoryMove extends Module {

	public InventoryMove(String name, String displayName, int color, int keyBind, Category category) {
		super(name, displayName, color, keyBind, category);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if (mc.currentScreen != null && !(mc.currentScreen instanceof GuiChat)) {
			if (Keyboard.isKeyDown(200)) {
				EntityPlayerSP thePlayer = mc.thePlayer;
				thePlayer.rotationPitch -= 5.0F;
			}
			if (Keyboard.isKeyDown(208)) {
				EntityPlayerSP thePlayer = mc.thePlayer;
				thePlayer.rotationPitch += 5.0F;
			}
			if (Keyboard.isKeyDown(203)) {
				EntityPlayerSP thePlayer = mc.thePlayer;
				thePlayer.rotationYaw -= 7.0F;
			}
			if (Keyboard.isKeyDown(205)) {
				EntityPlayerSP thePlayer = mc.thePlayer;
				thePlayer.rotationYaw += 7.0F;
			}
		}
	}
	
	@Override
	public void onEnable() {
		EventManager.register(this);
	}
	
	@Override
	public void onDisable() {
		EventManager.unregister(this);
	}
}
