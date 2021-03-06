package tech.mcwhirl.modules.impl.Gui;

import java.util.ArrayList;

import de.Hero.settings.Setting;
import tech.mcwhirl.Whirl;
import tech.mcwhirl.modules.Category;
import tech.mcwhirl.modules.Module;

public class ClickGui extends Module {

	public ClickGui(String name, String displayName, int color, int keyBind, Category category) {
		super(name, displayName, color, keyBind, category);
	}
	
	@Override
    public void setup(){
    	ArrayList<String> options = new ArrayList<String>();
    	options.add("JellyLike");
    	options.add("New Style");
    	Whirl.instance.setmgr.rSetting(new Setting("Design", this, "New", options));
    	Whirl.instance.setmgr.rSetting(new Setting("Sound", this, false));
    	Whirl.instance.setmgr.rSetting(new Setting("GuiRed", this, 255, 0, 255, true));
    	Whirl.instance.setmgr.rSetting(new Setting("GuiGreen", this, 26, 0, 255, true));
    	Whirl.instance.setmgr.rSetting(new Setting("GuiBlue", this, 42, 0, 255, true));
    }
    
    @Override
    public void onEnable()
    {
    	mc.displayGuiScreen(Whirl.instance.clickgui);
    	toggle();
    	super.onEnable();
    }
    
    @Override
    public void onDisable() {
    }
}
