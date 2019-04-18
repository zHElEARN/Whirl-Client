package tech.mcwhirl.commands.impl;

import tech.mcwhirl.Whirl;
import tech.mcwhirl.commands.Command;
import tech.mcwhirl.utils.KeyUtils;

public class Bind extends Command {

	public Bind(String name, String decription) {
		super(name, decription);
	}

	@Override
	public void execute(String[] args) {
		if (args.length != 2) {
			msgWithPrefix("��cParameter error: ��7$bind ��2<Module> <Key>");
			return;
		}
		
		String module = args[0];
		char key = args[1].charAt(0);
		int keyCode = KeyUtils.toKeyCode(key);
		
		if (Whirl.instance.moduleManager.getModuleByName(module) != null) {
			Whirl.instance.moduleManager.getModuleByName(module).setKeyBind(keyCode);
			msgWithPrefix("��aSetted ��6<" + module + ">��a to: ��6 <" + key + ">");
		} else {
			msgWithPrefix("��cModule:��a <" + args[0] + "> ��cnot found!");
		}
	}
	

}
