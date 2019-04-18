package tech.mcwhirl.modules.impl.Gui;

import de.Hero.settings.Setting;
import tech.mcwhirl.Whirl;
import tech.mcwhirl.modules.Category;
import tech.mcwhirl.modules.Module;

public class HUD extends Module {

	public HUD(String name, String displayName, int color, int keyBind, Category category) {
		super(name, displayName, color, keyBind, category);
	}
	
	@Override
	public void setup() {
		Whirl.instance.setmgr.rSetting(new Setting("Hotbar", this, true));
		Whirl.instance.setmgr.rSetting(new Setting("TabGUI", this, true));
		Whirl.instance.setmgr.rSetting(new Setting("Module List", this, true));
	}

}