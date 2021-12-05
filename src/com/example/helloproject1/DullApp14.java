package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.*;

public class DullApp14 extends Activity {
	int r=0;
	int g=0;
	int b=0;
	TextView tv=null;
	EditText rt=null;
	EditText gt=null;
	EditText bt=null;
	SeekBar sbr=null;
	SeekBar sbg=null;
	SeekBar sbb=null;
	Button bt1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app14);
		tv=(TextView)findViewById(R.id.textView2);
		rt=(EditText)findViewById(R.id.editText1);
		gt=(EditText)findViewById(R.id.editText2);
		bt=(EditText)findViewById(R.id.editText3);
		sbr=(SeekBar)findViewById(R.id.seekBar1);
		sbg=(SeekBar)findViewById(R.id.seekBar2);
		sbb=(SeekBar)findViewById(R.id.seekBar3);
		bt1=(Button)findViewById(R.id.button1);
		
		sbr.setOnSeekBarChangeListener(slistener1);
		sbg.setOnSeekBarChangeListener(slistener2);
		sbb.setOnSeekBarChangeListener(slistener3);
		bt1.setOnClickListener(btlistener1);
		
		tv.setBackgroundColor(Color.rgb(r, g, b));
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
			// TODO Auto-generated method stub
			rt.setText(String.valueOf(arg1));
			r=arg1;
			tv.setBackgroundColor(Color.rgb(r, g, b));
		}
	};
	
	SeekBar.OnSeekBarChangeListener slistener2=new SeekBar.OnSeekBarChangeListener() {
		
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
			// TODO Auto-generated method stub
			gt.setText(String.valueOf(arg1));
			g=arg1;
			tv.setBackgroundColor(Color.rgb(r, g, b));
		}
	};

	SeekBar.OnSeekBarChangeListener slistener3=new SeekBar.OnSeekBarChangeListener() {
		
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
			// TODO Auto-generated method stub
			bt.setText(String.valueOf(arg1));
			b=arg1;
			tv.setBackgroundColor(Color.rgb(r, g, b));
		}
	};
	
	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			sbr.setProgress(0);
			sbg.setProgress(0);
			sbb.setProgress(0);
			int r=0;
			int g=0;
			int b=0;
			rt.setText("");
			gt.setText("");
			bt.setText("");
		}
		
	};
}
