package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;


public class DullApp13 extends Activity {
	EditText t1=null;
	SeekBar sb1=null;
	Button bt1=null;
	Button bt2=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app13);
		t1=(EditText)findViewById(R.id.editText1);
		sb1=(SeekBar)findViewById(R.id.seekBar1);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		
		sb1.setOnSeekBarChangeListener(slistener1);
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
	}
	
	SeekBar.OnSeekBarChangeListener slistener1=new SeekBar.OnSeekBarChangeListener() {
		
		@Override
		public void onStopTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onStartTrackingTouch(SeekBar arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override						
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
			t1.setText(String.valueOf(arg1));
			
		}
	};
	
	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			int s=Integer.parseInt(t1.getText().toString());
			AlertDialog.Builder ad1=new AlertDialog.Builder(DullApp13.this);
			ad1.setTitle("訊息輸出");
			ad1.setMessage(String.valueOf(s));
			ad1.setPositiveButton("確定", null);
			ad1.show();
		}
	};

	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			sb1.setProgress(0);
			t1.setText("");
			
		}
	};

}
