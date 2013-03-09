package com.lingavin.jnisample;

import android.util.Log;

public class JavaToJni {
	static{
		System.loadLibrary("nativejni");
	}
	
	public native void intToJni(int num);
	public native String conversation(String toJni);
	public native void printTime();
	public native void callMethod();
	public native void exceptionCall() throws IllegalArgumentException;

	private void callback(){
		Log.i("JavaToJni","in Java");
	}
	
	private void callbackThrowException() throws NullPointerException{
		throw new NullPointerException("JavaToJni.callbackThrowException");
	}
}
