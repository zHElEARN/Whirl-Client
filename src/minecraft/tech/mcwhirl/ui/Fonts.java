package tech.mcwhirl.ui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import net.minecraft.client.Minecraft;

public class Fonts {

	public static UnicodeFontRenderer smallWhirl;
	public static UnicodeFontRenderer menuWhirl;
	public static UnicodeFontRenderer logoWhirl;
	public static UnicodeFontRenderer tabWhirl;
	
	public static void loadFonts() {
		InputStream is = Fonts.class.getResourceAsStream("fonts/Tencent.ttf");
		
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		smallWhirl = new UnicodeFontRenderer(font.deriveFont(18F));
		menuWhirl = new UnicodeFontRenderer(font.deriveFont(60F));
		logoWhirl = new UnicodeFontRenderer(font.deriveFont(30F));
		tabWhirl = new UnicodeFontRenderer(font.deriveFont(15F));
		
		if (Minecraft.getMinecraft().gameSettings.language != null) {
			Fonts.smallWhirl.setUnicodeFlag(true);
			Fonts.menuWhirl.setUnicodeFlag(true);
			Fonts.logoWhirl.setUnicodeFlag(true);
			Fonts.tabWhirl.setUnicodeFlag(true);
			
			Fonts.smallWhirl.setBidiFlag(Minecraft.getMinecraft().mcLanguageManager.isCurrentLanguageBidirectional());
			Fonts.menuWhirl.setBidiFlag(Minecraft.getMinecraft().mcLanguageManager.isCurrentLanguageBidirectional());
			Fonts.logoWhirl.setBidiFlag(Minecraft.getMinecraft().mcLanguageManager.isCurrentLanguageBidirectional());
			Fonts.tabWhirl.setBidiFlag(Minecraft.getMinecraft().mcLanguageManager.isCurrentLanguageBidirectional());
		}
	}
	
	public static enum FontType {
		EMBOSS_BOTTOM, EMBOSS_TOP, NOMAL, OUTLINE_THIN, SHADOW_THICK, SHADOW_THIN;
	}
	
}
