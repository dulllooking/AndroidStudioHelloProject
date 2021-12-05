package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.app.Activity;

public class Dullprogress1 extends Activity {

	Button bt1=null;
	Button bt2=null;
	Button bt3=null;
	ProgressBar pb1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dullprogress1);
		
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		pb1=(ProgressBar)findViewById(R.id.progressBar1);
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			pb1.setProgress(45);
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			pb1.setProgress(120);
		}
	};
	
	Button.OnClickListener btlistener3=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			pb1.setProgress(180);
		}
	};
}
