package tech.mcwhirl.modules.impl.Combat;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import net.minecraft.inventory.ContainerChest;
import tech.mcwhirl.events.EventUpdate;
import tech.mcwhirl.modules.Category;
import tech.mcwhirl.modules.Module;
import tech.mcwhirl.utils.TimeHelper;

public class ChestStealer extends Module {
	
	public TimeHelper time = new TimeHelper();

	public ChestStealer(String name, String displayName, int color, int keyBind, Category category) {
		super(name, displayName, color, keyBind, category);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if ((mc.thePlayer.openContainer != null) && (mc.thePlayer.openContainer instanceof ContainerChest)) {
			ContainerChest chest = (ContainerChest) this.mc.thePlayer.openContainer;
			for (int i = 0; i < chest.getLowerChestInventory().getSizeInventory(); i++) {
				if ((chest.getLowerChestInventory().getStackInSlot(i) != null) && (this.time.hasReached(40L))) {
					this.mc.playerController.windowClick(chest.windowId, i, 0, 1, this.mc.thePlayer);
					this.time.reset();
				}
			}
			
			if (chest.getInventory().isEmpty()) {
				this.mc.displayGuiScreen(null);
			}
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

}
