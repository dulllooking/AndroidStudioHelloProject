package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;//畫面動作監測套件
import android.widget.*;//按鈕UI套件
import android.app.AlertDialog;

public class DullApp5 extends Activity {
	
	RadioButton rb1=null;
	RadioButton rb2=null;
	RadioButton rb3=null;
	RadioButton rb4=null;
	RadioButton rb5=null;
	Button bt1=null;
	Button bt2=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app5);
		rb1=(RadioButton)findViewById(R.id.radioButton1);
		rb2=(RadioButton)findViewById(R.id.radioButton2);
		rb3=(RadioButton)findViewById(R.id.radioButton3);
		rb4=(RadioButton)findViewById(R.id.radioButton4);
		rb5=(RadioButton)findViewById(R.id.radioButton5);
		
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button4);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener()// 類別事件按鈕動作監測
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String str="";
			if (rb1.isChecked()) //判斷有無被選,回傳布林
			{
				str=rb1.getText().toString(); //取文字,回傳字串
			}
			
			if (rb2.isChecked())
			{
				str=rb2.getText().toString();
			}
			
			if (rb3.isChecked())
			{
				str=rb3.getText().toString();
			}
			
			if (rb4.isChecked())
			{
				str=rb4.getText().toString();
			}
			
			if (rb5.isChecked())
			{
				str=rb5.getText().toString();
			}
			AlertDialog.Builder b=new AlertDialog.Builder(DullApp5.this);
			b.setTitle("訊息輸出");
			b.setMessage(str);
			b.setPositiveButton("確定", null);
			b.show();
			
		}
		
	};

	Button.OnClickListener btlistener2=new Button.OnClickListener()// 類別事件按鈕動作監測
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			rb1.setChecked(false); //設定成被選或未選,true被選(或用在初始化),false未選(清除)
			rb2.setChecked(false);
			rb3.setChecked(false);
			rb4.setChecked(false);
			rb5.setChecked(false);
		}
		
	};
}
