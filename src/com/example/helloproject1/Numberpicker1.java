package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.app.Activity;

public class Numberpicker1 extends Activity {

	private TextView tv1=null;
	private NumberPicker np1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_numberpicker1);
		
		np1=(NumberPicker)findViewById(R.id.numberPicker1);
		np1.setMaxValue(20);
		np1.setMinValue(1);
		np1.setValue(10);
		tv1=(TextView)findViewById(R.id.textView1);
		Button bt1=(Button)findViewById(R.id.button1);
		
		bt1.setOnClickListener(btlistener1);
		
		}

		Button.OnClickListener btlistener1=new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				int va=np1.getValue();
				tv1.setText(String.valueOf(va));
			}
		};

}
