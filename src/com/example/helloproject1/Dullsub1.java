package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;


public class Dullsub1 extends Activity {

	Button bt1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dullsub1);
		
		bt1=(Button)findViewById(R.id.button1);
		
		bt1.setOnClickListener(btlistener1);
	}
	
	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			Intent i5=new Intent(Dullsub1.this,DullIntent1.class);
			startActivity(i5);
		}
	};
}
