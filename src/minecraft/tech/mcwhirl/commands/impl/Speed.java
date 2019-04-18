package tech.mcwhirl.commands.impl;

import tech.mcwhirl.Whirl;
import tech.mcwhirl.commands.Command;

public class Speed extends Command {

	public Speed(String name, String decription) {
		super(name, decription);
	}

	@Override
	public void execute(String[] args) {
		if (args.length != 1) {
			msgWithPrefix("��cParameter error: ��7$speed ��2<Mode>");
			return;
		}
		String name = args[0];
		if (name.equalsIgnoreCase("Y-Port") || name.equalsIgnoreCase("Timer")) {
			tech.mcwhirl.modules.impl.Movement.Speed.mode = name;
			msgWithPrefix("��aSetted Speed mode to: ��6 <" + name + ">");
		} else if (name.equalsIgnoreCase("help")) {
			msgWithPrefix("��aY-Port, Timer");
		} else {
			msgWithPrefix("��cMode:��a <" + args[0] + "> ��cnot found!");
		}
	}

}
