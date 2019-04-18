package tech.mcwhirl.utils;

import org.lwjgl.input.Keyboard;

public class KeyUtils {
	public static char getChar(int code) {
		switch (code) {
		case Keyboard.KEY_A: return 'A';
		case Keyboard.KEY_B: return 'B';
		case Keyboard.KEY_C: return 'C';
		case Keyboard.KEY_D: return 'D';
		case Keyboard.KEY_E: return 'E';
		case Keyboard.KEY_F: return 'F';
		case Keyboard.KEY_G: return 'G';
		case Keyboard.KEY_H: return 'H';
		case Keyboard.KEY_I: return 'I';
		case Keyboard.KEY_J: return 'J';
		case Keyboard.KEY_K: return 'K';
		case Keyboard.KEY_L: return 'L';
		case Keyboard.KEY_M: return 'M';
		case Keyboard.KEY_N: return 'N';
		case Keyboard.KEY_O: return 'O';
		case Keyboard.KEY_P: return 'P';
		case Keyboard.KEY_Q: return 'Q';
		case Keyboard.KEY_R: return 'R';
		case Keyboard.KEY_S: return 'S';
		case Keyboard.KEY_T: return 'T';
		case Keyboard.KEY_U: return 'U';
		case Keyboard.KEY_V: return 'V';
		case Keyboard.KEY_W: return 'W';
		case Keyboard.KEY_X: return 'X';
		case Keyboard.KEY_Y: return 'Y';
		case Keyboard.KEY_Z: return 'Z';
		}
		return 0;
	}
	
	public static int toKeyCode(char key) {
		key = Character.toUpperCase(key);
		switch (key) {
		case 'A':return Keyboard.KEY_A;
		case 'B':return Keyboard.KEY_B;
		case 'C':return Keyboard.KEY_C;
		case 'D':return Keyboard.KEY_D;
		case 'E':return Keyboard.KEY_E;
		case 'F':return Keyboard.KEY_F;
		case 'G':return Keyboard.KEY_G;
		case 'H':return Keyboard.KEY_H;
		case 'I':return Keyboard.KEY_I;
		case 'J':return Keyboard.KEY_J;
		case 'K':return Keyboard.KEY_K;
		case 'L':return Keyboard.KEY_L;
		case 'M':return Keyboard.KEY_M;
		case 'N':return Keyboard.KEY_N;
		case 'O':return Keyboard.KEY_O;
		case 'P':return Keyboard.KEY_P;
		case 'Q':return Keyboard.KEY_Q;
		case 'R':return Keyboard.KEY_R;
		case 'S':return Keyboard.KEY_S;
		case 'T':return Keyboard.KEY_T;
		case 'U':return Keyboard.KEY_U;
		case 'V':return Keyboard.KEY_V;
		case 'W':return Keyboard.KEY_W;
		case 'X':return Keyboard.KEY_X;
		case 'Y':return Keyboard.KEY_Y;
		case 'Z':return Keyboard.KEY_Z;
		}
		return 0;
	}
}
