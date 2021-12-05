package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;//畫面動作監測套件
import android.widget.*;//按鈕UI套件
import android.app.AlertDialog;
import java.text.NumberFormat;

public class DullApp4 extends Activity {
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
			
			if(!(t1.getText().toString().equals("")))
			{
				try
				{
					if(Float.parseFloat(t1.getText().toString())>=1.0 && Float.parseFloat(t1.getText().toString())<=50.0)
					{
						float r=Float.parseFloat(t1.getText().toString());
						double sum1=3.14*r*r;
						double sum2=2*3.14*r;
						NumberFormat nf=NumberFormat.getInstance();
						nf.setMaximumFractionDigits(2);
						t2.setText(String.valueOf(nf.format(sum1)));
						t3.setText(String.valueOf(nf.format(sum2)));
					}
					else
					{
						t1.setText("");
						t2.setText("");
						t3.setText("");
						AlertDialog.Builder ad1=new AlertDialog.Builder(DullApp4.this);
						ad1.setTitle("範圍限制");
						ad1.setMessage("超出範圍-請重新輸入");
						ad1.setPositiveButton("確定", null);
						ad1.show();
					}
				}	
				catch(Exception e)
				{
					t1.setText("");
					t2.setText("");
					t3.setText("");
					AlertDialog.Builder ad2=new AlertDialog.Builder(DullApp4.this);
					ad2.setTitle("不正常輸入");
					ad2.setMessage("資料型態錯誤-請重新輸入");
					ad2.setPositiveButton("確定", null);
					ad2.show();
				}
			}
			else
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");AlertDialog.Builder ad3=new AlertDialog.Builder(DullApp4.this);
				ad3.setTitle("無數值");
				ad3.setMessage("無輸入-請重新輸入");
				ad3.setPositiveButton("確定", null);
				ad3.show();
			}
		}
	};
	Button.OnClickListener btlistener2=new Button.OnClickListener()
	{
		@Override
		public void onClick(View arg0) 
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			AlertDialog.Builder ad4=new AlertDialog.Builder(DullApp4.this);
			ad4.setTitle("關於");
			ad4.setMessage("資料已清除");
			ad4.setPositiveButton("確定", null);
			ad4.show();
		}
	};
}
