package tech.mcwhirl.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import tech.mcwhirl.Whirl;

public class Logger {
	
	private Minecraft mc;
	
	public void Loading(String text) {
		System.out.println("Loading >" + text);
	}
	
	public void Info(String text) {
		System.out.println("Info >" + text);
	}
	
	public void Error(String text) {
		System.out.println("Error >" + text);
	}
	
	public void Downloading(String text) {
		System.out.println("Downloading >" + text);
	}
	
	public void Creating(String text) {
		System.out.println("Creating >" + text);
	}
	
}
