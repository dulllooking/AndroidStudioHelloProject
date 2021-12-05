package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.app.Activity;

public class DullDate2 extends Activity {


	EditText et1=null;
	EditText et2=null;
	Button bt1=null;
	TimePicker tk1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_date2);
		
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		bt1=(Button)findViewById(R.id.button1);
		tk1=(TimePicker)findViewById(R.id.timePicker1);
		
		tk1.setIs24HourView(true);
		bt1.setOnClickListener(btlistener1);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			int h=tk1.getCurrentHour();
			int m=tk1.getCurrentMinute();
			
			et1.setText(String.valueOf(h));
			et2.setText(String.valueOf(m));
			
		}
	};
}
