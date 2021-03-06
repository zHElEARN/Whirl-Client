package tech.mcwhirl.commands.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import tech.mcwhirl.Whirl;
import tech.mcwhirl.commands.Command;
import tech.mcwhirl.modules.Module;
import tech.mcwhirl.utils.KeyUtils;

public class LoadBinds extends Command {

	public String fileName;
	
	public LoadBinds(String name, String decription) {
		super(name, decription);
	}
	
	public String readToString(String fileName) {
		String encoding = "ISO-8859-1";
		File file = new File(fileName);
		Long filelength = file.length();
		byte[] filecontent = new byte[filelength.intValue()];
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return new String(filecontent, encoding);
		} catch (UnsupportedEncodingException e) {
			System.err.println("The OS does not support " + encoding);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void execute(String[] args) {
		if (args.length != 0) {
			msgWithPrefix("��cParameter error: ��7$load");
			return;
		}
		
		fileName = Whirl.instance.directory.getAbsolutePath();

		fileName += "\\Binds.json";
		System.out.println(fileName);
		
		String json = readToString(fileName);
		
		JsonElement element = new JsonParser().parse(json);
		JsonObject object = element.getAsJsonObject();
		
		JsonArray array = object.getAsJsonArray("Binds");
		object = array.get(0).getAsJsonObject();
		
		for (Module m : Whirl.instance.moduleManager.getModules()) {
			String name = m.getName();
			int key = object.get(name).getAsInt();
			m.setKeyBind(key);
		}
		
		msgWithPrefix("��aLoad:��6 Success!");
	}
	
}
