package tech.mcwhirl.commands.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

import tech.mcwhirl.Whirl;
import tech.mcwhirl.commands.Command;
import tech.mcwhirl.modules.Module;

public class SaveBinds extends Command {

	public SaveBinds(String name, String decription) {
		super(name, decription);
	}
	
	public String fileName;
	
	@Override
	@SuppressWarnings("resource")
	public void execute(String[] args) {
		fileName = Whirl.instance.directory.getAbsolutePath();
		if (args.length != 0) {
			msgWithPrefix("��cParameter error: ��7$save");
			return;
		}
		
		fileName += "\\Binds.json";
		System.out.println(fileName);
		
		Gson gson = new Gson();
		try {
			JsonWriter writer = new JsonWriter(new FileWriter(fileName));
			writer.beginObject();
			writer.name("Binds");
			writer.beginArray();
			writer.beginObject();
			
			for (Module m : Whirl.instance.moduleManager.getModules()) {
				writer.name(m.getName()).value(m.getKeyBind());
			}

			writer.endObject();
			writer.endArray();
			writer.endObject();
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		msgWithPrefix("��aSave:��6 Success!");
	}

}