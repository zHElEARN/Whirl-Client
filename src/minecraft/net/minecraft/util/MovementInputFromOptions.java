package net.minecraft.util;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.GameSettings;
import tech.mcwhirl.Whirl;

public class MovementInputFromOptions extends MovementInput
{
    private final GameSettings gameSettings;
    private static final String __OBFID = "CL_00000937";

    public MovementInputFromOptions(GameSettings p_i1237_1_)
    {
        this.gameSettings = p_i1237_1_;
    }

    public void updatePlayerMoveState()
    {
    	if (Whirl.instance.moduleManager.getModuleByName("InventoryMove").isEnabled() && !(Minecraft.getMinecraft().currentScreen instanceof GuiChat)) {
    	
    		this.moveStrafe = 0.0F;
        	this.moveForward = 0.0F;
        	
        	if (Keyboard.isKeyDown(this.gameSettings.keyBindForward.getKeyCode())) {
        		++this.moveForward;
        	}
        	
        	if (Keyboard.isKeyDown(this.gameSettings.keyBindBack.getKeyCode())) {
        		--this.moveForward;
        	}
        	
        	if (Keyboard.isKeyDown(this.gameSettings.keyBindLeft.getKeyCode())) {
        		++this.moveStrafe;
        	}
        	
        	if (Keyboard.isKeyDown(this.gameSettings.keyBindRight.getKeyCode())) {
        		--this.moveStrafe;
        	}
        	
        	this.jump = Keyboard.isKeyDown(this.gameSettings.keyBindJump.getKeyCode());
        	this.sneak = Keyboard.isKeyDown(this.gameSettings.keyBindSneak.getKeyCode());
        	if (this.sneak) {
        		this.moveStrafe *= 0.3;
        		this.moveForward *= 0.3;
        	}
    	} else {
        	this.moveStrafe = 0.0F;
        	this.moveForward = 0.0F;

        	if (this.gameSettings.keyBindForward.getIsKeyPressed())
        	{
            	++this.moveForward;
        	}

        	if (this.gameSettings.keyBindBack.getIsKeyPressed())
        	{
        		--this.moveForward;
        	}

        	if (this.gameSettings.keyBindLeft.getIsKeyPressed())
        	{
        		++this.moveStrafe;
        	}

        	if (this.gameSettings.keyBindRight.getIsKeyPressed())
        	{
        		--this.moveStrafe;
        	}

        	this.jump = this.gameSettings.keyBindJump.getIsKeyPressed();
        	this.sneak = this.gameSettings.keyBindSneak.getIsKeyPressed();

        	if (this.sneak)
        	{
        		this.moveStrafe = (float)((double)this.moveStrafe * 0.3D);
        		this.moveForward = (float)((double)this.moveForward * 0.3D);
        	}
    	}
    }
}
