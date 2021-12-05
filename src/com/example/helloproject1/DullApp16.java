package com.example.helloproject1;

import java.text.NumberFormat;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.*;
import java.text.NumberFormat;

public class DullApp16 extends Activity {
	EditText t1=null;
	EditText t2=null;
	EditText t3=null;
	EditText t4=null;
	Button bt1=null;
	Button bt2=null;
	ImageView iv1=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app16);
		iv1=(ImageView)findViewById(R.id.imageView1);
		t1=(EditText)findViewById(R.id.editText1);
		t2=(EditText)findViewById(R.id.editText2);
		t3=(EditText)findViewById(R.id.editText3);
		t4=(EditText)findViewById(R.id.editText4);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		
		
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			try
			{
				double h=0.0;
				double w=0.0;
				double bmi=0.0;
				h=Double.parseDouble(t1.getText().toString());
				w=Double.parseDouble(t2.getText().toString());
				bmi=w/Math.pow(h/100,2);
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMaximumFractionDigits(2);
				t3.setText(String.valueOf(nf.format(bmi)));
				if (t1.getText().toString().equals("") || t2.getText().toString().equals(""))
				{
					t1.setText("");
					t2.setText("");
					AlertDialog.Builder b3=new AlertDialog.Builder(DullApp16.this);
					b3.setTitle("非輸入正常數字");
					b3.setMessage("請輸入數字");
					b3.setPositiveButton("確定", null);
					b3.show();
				}
				else if(bmi<18.5)
				{
		            t4.setText("太輕");
					iv1.setImageResource(R.drawable.thin);
				}
		        else if (bmi<24)
		        {
		        	t4.setText("正常");
					iv1.setImageResource(R.drawable.fine);
		        }
		        else if (bmi<27)
		        {
		        	t4.setText("過重");
		        	iv1.setImageResource(R.drawable.fat);
		        }
		        else if (bmi<30)
		        {
		        	t4.setText("輕肥");
		        	iv1.setImageResource(R.drawable.fat2);
		        }
		        else if (bmi<35)
		        {
		        	t4.setText("中肥");
		        	iv1.setImageResource(R.drawable.fat3);
		        }
		        else
		        {
		        	t4.setText("重肥");
		        	iv1.setImageResource(R.drawable.fat4);
		        }
			}
			catch (Exception e)
			{
				t1.setText("");
				t2.setText("");
				
				AlertDialog.Builder b2=new AlertDialog.Builder(DullApp16.this);
				b2.setTitle("非輸入正常數字");
				b2.setMessage("請輸入數字");
				b2.setPositiveButton("確定", null);
				b2.show();
			}	
				
		}
		
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			iv1.setImageResource(R.drawable.fine);
			
		}
		
	};


}
