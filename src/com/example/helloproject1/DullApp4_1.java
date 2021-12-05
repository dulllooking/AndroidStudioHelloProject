package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.widget.*;
import android.view.View;
import java.text.NumberFormat;


public class DullApp4_1 extends Activity {
	EditText t1=null;
	EditText t2=null;
	EditText t3=null;
	
	Button bt1=null;
	Button bt2=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app4);
		t1=(EditText)findViewById(R.id.editText1);
		t2=(EditText)findViewById(R.id.editText2);
		t3=(EditText)findViewById(R.id.editText3);
		
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);

	}

	Button.OnClickListener btlistener1=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			float pi=(float) 3.14;
			try
			{
				if (t1.getText().toString().equals(""))
				{
					t1.setText("");
					t2.setText("");
					t3.setText("");
					
					AlertDialog.Builder b1=new AlertDialog.Builder(DullApp4_1.this);
					b1.setTitle("無輸入");
					b1.setMessage("請輸入半徑");
					b1.setPositiveButton("確定", null);
					b1.show();
				}
				else if(Float.parseFloat(t1.getText().toString())<1.0 || Float.parseFloat(t1.getText().toString())>50.0)
				{
					t1.setText("");
					t2.setText("");
					t3.setText("");
					
					AlertDialog.Builder b2=new AlertDialog.Builder(DullApp4_1.this);
					b2.setTitle("半徑範圍1~50");
					b2.setMessage("超出範圍");
					b2.setPositiveButton("確定", null);
					b2.show();
				}
				else 
				{
					float t1num = Float.parseFloat(t1.getText().toString());
					float t2num = t1num*t1num*pi;
					float t3num = 2*pi*t1num;
					NumberFormat nf = NumberFormat.getInstance();
					nf.setMaximumFractionDigits(2);
					t2.setText(String.valueOf(nf.format(t2num)));
					t3.setText(String.valueOf(nf.format(t3num)));
				}
			}
			catch (Exception e)
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
				
				AlertDialog.Builder b3=new AlertDialog.Builder(DullApp4_1.this);
				b3.setTitle("非輸入正常數字");
				b3.setMessage("請輸入數字");
				b3.setPositiveButton("確定", null);
				b3.show();
			}
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			
			AlertDialog.Builder b=new AlertDialog.Builder(DullApp4_1.this);
			b.setTitle("關於");
			b.setMessage("資料已清除");
			b.setPositiveButton("確定",null);
			b.show();
		}
	};	
}
