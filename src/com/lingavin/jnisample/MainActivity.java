package com.lingavin.jnisample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv_message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();
		
		JavaToJni.intToJni(255);
		tv_message.setText("message from jni is :" + 
				JavaToJni.conversation("Hello i am java!"));
	}

	private void initViews() {
		tv_message = (TextView)findViewById(R.id.messagefromjni);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
