package com.lingavin.jnisample;

public class JavaToJni {
	static{
		System.loadLibrary("nativejni");
	}
	
	public static native void intToJni(int num);
	public static native String conversation(String toJni);

}
