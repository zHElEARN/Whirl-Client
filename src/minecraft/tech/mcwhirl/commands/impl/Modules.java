package tech.mcwhirl.commands.impl;

import org.lwjgl.input.Keyboard;

import tech.mcwhirl.Whirl;
import tech.mcwhirl.commands.Command;
import tech.mcwhirl.modules.Module;
import tech.mcwhirl.utils.KeyUtils;

public class Modules extends Command {

	public Modules(String name, String decription) {
		super(name, decription);
	}

	@Override
	public void execute(String[] args) {
		if (args.length != 0) {
			msgWithPrefix("¡ìcParameter error: ¡ì7$modules");
			return;
		}
		msgWithPrefix("¡ìa-----------All modules-----------");
		for (Module m : Whirl.instance.moduleManager.getModules()) {
			msgWithoutPrefix("¡ìeName:¡ìf " + m.getName() + "  ¡ìeKey:¡ìf " + Keyboard.getKeyName(m.getKeyBind()));
		}
	}

}
