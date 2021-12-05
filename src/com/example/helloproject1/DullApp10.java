package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.app.Activity;


public class DullApp10 extends Activity {
	ImageView iv1=null;
	Button bt1=null;
	Button bt2=null;
	Button bt3=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app10);
		iv1=(ImageView)findViewById(R.id.imageView1);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener1);
		bt3.setOnClickListener(btlistener1);
		
	}

	View.OnClickListener btlistener1=new View.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			if(arg0.getId()==R.id.button1)
			{
				iv1.setImageResource(R.drawable.t1);
			};
			
			if(arg0.getId()==R.id.button2)
			{
				iv1.setImageResource(R.drawable.t2);
			};
			
			if(arg0.getId()==R.id.button3)
			{
				iv1.setImageResource(R.drawable.t3);
			};
			
		}
		
	};
}
