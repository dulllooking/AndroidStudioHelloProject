package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.*;

public class DullApp7 extends Activity {
	CheckBox cb1=null;
	CheckBox cb2=null;
	CheckBox cb3=null;
	CheckBox cb4=null;
	CheckBox cb5=null;
	Button bt1=null;
	Button bt2=null;
	EditText t1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app7);
		cb1=(CheckBox)findViewById(R.id.checkBox1);
		cb2=(CheckBox)findViewById(R.id.checkBox2);
		cb3=(CheckBox)findViewById(R.id.checkBox3);
		cb4=(CheckBox)findViewById(R.id.checkBox4);
		cb5=(CheckBox)findViewById(R.id.checkBox5);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		t1=(EditText)findViewById(R.id.editText1);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			String str="";
			if(cb1.isChecked())
			{
				str=str+cb1.getText()+"\n";
			}
			if(cb2.isChecked())
			{
				str=str+cb2.getText()+"\n";
			}
			if(cb3.isChecked())
			{
				str=str+cb3.getText()+"\n";
			}
			if(cb4.isChecked())
			{
				str=str+cb4.getText()+"\n";
			}
			if(cb5.isChecked())
			{
				str=str+cb5.getText()+"\n";
			}
			t1.setText(str.toString());
		}
		
	};

	Button.OnClickListener btlistener2=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			cb1.setChecked(false);
			cb2.setChecked(false);
			cb3.setChecked(false);
			cb4.setChecked(false);
			cb5.setChecked(false);
			t1.setText("");
		}
		
	};
	
}
