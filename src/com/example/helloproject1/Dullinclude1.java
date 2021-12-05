package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.app.Activity;

public class Dullinclude1 extends Activity {

	EditText et1=null;
	EditText et2=null;
	EditText et3=null;
	Button bt1=null;
	Button bt2=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dullinclude1);
		
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		et3=(EditText)findViewById(R.id.editText3);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			int a=Integer.parseInt(et1.getText().toString());
			int b=Integer.parseInt(et2.getText().toString());
			int sum=a+b;
			et3.setText(String.valueOf(sum));
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			et1.setText("");
			et2.setText("");
			et3.setText("");
		}
	};
	
}
