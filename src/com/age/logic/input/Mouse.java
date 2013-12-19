package com.age.logic.input;

import com.age.Age;
import com.age.Screen;

public class Mouse {

	private static boolean hasLeftBeenPressed = false;
	private static boolean hasRightBeenPressed = false;
	
	public static boolean isLeftMouseButtonDown(){
		hasLeftBeenPressed = true;
		return org.lwjgl.input.Mouse.isButtonDown(0);
	}
	public static boolean isRightMouseButtonDown(){
		hasRightBeenPressed = true;
		return org.lwjgl.input.Mouse.isButtonDown(1);
	}
	
	public static int getX(){
		return (int) (org.lwjgl.input.Mouse.getX() / Age.ratioX());
	}
	public static int getY(){
		return (int) ((Screen.getHeight() - org.lwjgl.input.Mouse.getY()) / Age.ratioY());
	}
	
	
	public static void onUpdate() {
		
		
		
		
		
		
	}
}