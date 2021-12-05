package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.app.Activity;

public class DullApp11 extends Activity {
	ImageView iv1=null;
	RadioButton rbt1=null;
	RadioButton rbt2=null;
	RadioButton rbt3=null;
	RadioButton rbt4=null;
	ImageButton ibt1=null;
	ImageButton ibt2=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app11);
		iv1=(ImageView)findViewById(R.id.imageView1);
		rbt1=(RadioButton)findViewById(R.id.radioButton1);
		rbt2=(RadioButton)findViewById(R.id.radioButton2);
		rbt3=(RadioButton)findViewById(R.id.radioButton3);
		rbt4=(RadioButton)findViewById(R.id.radioButton4);
		ibt1=(ImageButton)findViewById(R.id.imageButton1);
		ibt2=(ImageButton)findViewById(R.id.imageButton2);
		
		ibt1.setOnClickListener(btlistener1);
		ibt2.setOnClickListener(btlistener1);
		
		}
		View.OnClickListener btlistener1=new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0) 
			{
				switch(arg0.getId())
				{
				case R.id.imageButton1:
					{
					if(rbt1.isChecked())
					{
						iv1.setImageResource(R.drawable.flower1);
					};
					if(rbt2.isChecked())
					{
						iv1.setImageResource(R.drawable.flower2);
					};
					if(rbt3.isChecked())
					{
						iv1.setImageResource(R.drawable.flower3);
					};
					if(rbt4.isChecked())
					{
						iv1.setImageResource(R.drawable.flower4);
					};
					break;
					}
				case R.id.imageButton2:
					{
					rbt1.setChecked(false);
					rbt2.setChecked(false);
					rbt3.setChecked(false);
					rbt4.setChecked(false);
					iv1.setImageResource(R.drawable.t1);
					break;
					}
				}
			}
		};
		

}
