package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;

public class DullApp6 extends Activity {
	EditText t1=null;
	RadioButton rb1=null;
	RadioButton rb2=null;
	RadioButton rb3=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app6);
		t1=(EditText)findViewById(R.id.editText1);
		rb1=(RadioButton)findViewById(R.id.radio0);
		rb2=(RadioButton)findViewById(R.id.radio1);
		rb3=(RadioButton)findViewById(R.id.radio2);
		
		rb1.setOnCheckedChangeListener(rblistrner1);
		rb2.setOnCheckedChangeListener(rblistrner2);
		rb3.setOnCheckedChangeListener(rblistrner3);
		
	}

	RadioButton.OnCheckedChangeListener rblistrner1=new RadioButton.OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			if(arg1==true)
			{
				t1.setText(arg0.getText().toString());
			}
			
		}
		
	};

	RadioButton.OnCheckedChangeListener rblistrner2=new RadioButton.OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			if(arg1==true)
			{
				t1.setText(arg0.getText().toString());
			}
			
		}
		
	};

	RadioButton.OnCheckedChangeListener rblistrner3=new RadioButton.OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			if(arg1==true)
			{
				t1.setText(arg0.getText().toString());
			}
			
		}
		
	};

}
