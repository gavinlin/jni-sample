package com.lingavin.jnisample;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv_message;
	JavaToJni jtj;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();
		
		jtj.intToJni(255);
		tv_message.setText("message from jni is :" + 
				jtj.conversation("Hello i am java!"));
		jtj.printTime();
		jtj.callMethod();
		try{
			jtj.exceptionCall();
		}catch(Exception e){
			Log.e("MainActivity", "exception from c :" + e);
		}
		
	}

	private void initViews() {
		tv_message = (TextView)findViewById(R.id.messagefromjni);
		jtj = new JavaToJni();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
