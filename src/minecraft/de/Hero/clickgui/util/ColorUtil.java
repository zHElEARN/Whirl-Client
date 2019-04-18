package de.Hero.clickgui.util;

import java.awt.Color;

//Deine Imports
import tech.mcwhirl.Whirl;

/**
 *  Made by HeroCode
 *  it's free to use
 *  but you have to credit me
 *
 *  @author HeroCode
 */
public class ColorUtil {
	
	public static Color getClickGUIColor(){
		return new Color((int)Whirl.instance.setmgr.getSettingByName("GuiRed").getValDouble(), (int)Whirl.instance.setmgr.getSettingByName("GuiGreen").getValDouble(), (int)Whirl.instance.setmgr.getSettingByName("GuiBlue").getValDouble());
	}
}
