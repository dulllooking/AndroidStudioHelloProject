package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;

public class DullApp8 extends Activity {
	CheckBox cb1=null;
	CheckBox cb2=null;
	CheckBox cb3=null;
	CheckBox cb4=null;
	CheckBox cb5=null;
	EditText t1=null;
	String str1="";
	String str2="";
	String str3="";
	String str4="";
	String str5="";
	String str="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app8);
		cb1=(CheckBox)findViewById(R.id.checkBox1);
		cb2=(CheckBox)findViewById(R.id.checkBox2);
		cb3=(CheckBox)findViewById(R.id.checkBox3);
		cb4=(CheckBox)findViewById(R.id.checkBox4);
		cb5=(CheckBox)findViewById(R.id.checkBox5);
		
		t1=(EditText)findViewById(R.id.editText1);
		
		cb1.setOnCheckedChangeListener(cblistener1);
		cb2.setOnCheckedChangeListener(cblistener2);
		cb3.setOnCheckedChangeListener(cblistener3);
		cb4.setOnCheckedChangeListener(cblistener4);
		cb5.setOnCheckedChangeListener(cblistener5);
		
	}

	CheckBox.OnCheckedChangeListener cblistener1=new CheckBox.OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			if(arg1==true)
			{
				str1=cb1.getText().toString()+"\n";
			}
			else
			{
				str1="";
			}
			str=str1+str2+str3+str4+str5;
			t1.setText(str);
		}
		
	};

	CheckBox.OnCheckedChangeListener cblistener2=new CheckBox.OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			if(arg1==true)
			{
				str2=cb2.getText().toString()+"\n";
			}
			else
			{
				str2="";
			}
			str=str1+str2+str3+str4+str5;
			t1.setText(str);
		}
		
	};

	CheckBox.OnCheckedChangeListener cblistener3=new CheckBox.OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			if(arg1==true)
			{
				str3=cb3.getText().toString()+"\n";
			}
			else
			{
				str3="";
			}
			str=str1+str2+str3+str4+str5;
			t1.setText(str);
		}
		
	};
	
	CheckBox.OnCheckedChangeListener cblistener4=new CheckBox.OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			if(arg1==true)
			{
				str4=cb4.getText().toString()+"\n";
			}
			else
			{
				str4="";
			}
			str=str1+str2+str3+str4+str5;
			t1.setText(str);
		}
		
	};

	CheckBox.OnCheckedChangeListener cblistener5=new CheckBox.OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			if(arg1==true)
			{
				str5=cb5.getText().toString()+"\n";
			}
			else
			{
				str5="";
			}
			str=str1+str2+str3+str4+str5;
			t1.setText(str);
}
		
	};
	
	

}
