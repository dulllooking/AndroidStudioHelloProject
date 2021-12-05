package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.annotation.SuppressLint;
import android.app.Activity;

public class Dulldate1 extends Activity {

	EditText et1=null;
	EditText et2=null;
	EditText et3=null;
	Button bt1=null;
	DatePicker dk1=null;
	@SuppressLint("NewApi") protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dulldate1);

		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		et3=(EditText)findViewById(R.id.editText3);
		bt1=(Button)findViewById(R.id.button1);
		dk1=(DatePicker)findViewById(R.id.datePicker1);
		dk1.setSpinnersShown(true);
		
		bt1.setOnClickListener(btlistener1);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			//dk1.updateDate(2020, 12, 3);
			int y=dk1.getYear();
			int m=dk1.getMonth()+1;
			int d=dk1.getDayOfMonth();
			et1.setText(String.valueOf(y));
			et2.setText(String.valueOf(m));
			et3.setText(String.valueOf(d));
		}
	};

}
