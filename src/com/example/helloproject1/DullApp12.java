package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class DullApp12 extends Activity {
	ImageButton ibt1=null;
	ImageButton ibt2=null;
	ImageButton ibt3=null;
	ImageButton ibt4=null;
	ImageButton ibt5=null;
	ImageButton ibt6=null;
	ImageButton ibt7=null;
	ImageButton ibt8=null;
	ImageButton ibt9=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app12);
		ibt1=(ImageButton)findViewById(R.id.imageButton1);
		ibt2=(ImageButton)findViewById(R.id.imageButton2);
		ibt3=(ImageButton)findViewById(R.id.imageButton3);
		ibt4=(ImageButton)findViewById(R.id.imageButton4);
		ibt5=(ImageButton)findViewById(R.id.imageButton5);
		ibt6=(ImageButton)findViewById(R.id.imageButton6);
		ibt7=(ImageButton)findViewById(R.id.imageButton7);
		ibt8=(ImageButton)findViewById(R.id.imageButton8);
		ibt9=(ImageButton)findViewById(R.id.imageButton9);
		
		ibt1.setOnClickListener(btlistener);
		ibt2.setOnClickListener(btlistener);
		ibt3.setOnClickListener(btlistener);
		ibt4.setOnClickListener(btlistener);
		ibt5.setOnClickListener(btlistener);
		ibt6.setOnClickListener(btlistener);
		ibt7.setOnClickListener(btlistener);
		ibt8.setOnClickListener(btlistener);
		ibt9.setOnClickListener(btlistener);
		
		
	}

	View.OnClickListener btlistener=new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			String str="";
			if(arg0.getId()==R.id.imageButton1)
			{
				str="子畫面一";
			}
			if(arg0.getId()==R.id.imageButton2)
			{
				str="子畫面二";
			}
			if(arg0.getId()==R.id.imageButton3)
			{
				str="子畫面三";
			}
			if(arg0.getId()==R.id.imageButton4)
			{
				str="子畫面四";
			}
			if(arg0.getId()==R.id.imageButton5)
			{
				str="子畫面五";
			}
			if(arg0.getId()==R.id.imageButton6)
			{
				str="子畫面六";
			}
			if(arg0.getId()==R.id.imageButton7)
			{
				str="子畫面七";
			}
			if(arg0.getId()==R.id.imageButton8)
			{
				str="子畫面八";
			}
			if(arg0.getId()==R.id.imageButton9)
			{
				str="子畫面九";
			}
			
			
			AlertDialog.Builder ad1=new AlertDialog.Builder(DullApp12.this);
			ad1.setTitle("訊息輸出");
			ad1.setMessage(str);
			ad1.setPositiveButton("確定",new DialogInterface.OnClickListener() 
				{
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						Toast.makeText(getBaseContext(), "下次建構--續集", Toast.LENGTH_LONG).show();
					}	//getBaseCintext()等於去抓DullApp12.this(用DullApp12.this也可以)
				});	//小括號);為.setPositiveButton的結束末段
				ad1.setNegativeButton("取消", null);
				ad1.show();
				}
		
		};
	
}
