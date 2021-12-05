package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.*;
import android.app.AlertDialog;

public class DullApp9 extends Activity {
	EditText t1=null;
	EditText t2=null;
	EditText t3=null;
	Button bt1=null;
	Button bt2=null;
	Button bt3=null;
	Button bt4=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app9);
		t1=(EditText)findViewById(R.id.editText1);
		t2=(EditText)findViewById(R.id.editText2);
		t3=(EditText)findViewById(R.id.editText3);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		bt4=(Button)findViewById(R.id.button4);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
		bt4.setOnClickListener(btlistener4);
				
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			try{
			int t1num=Integer.parseInt(t1.getText().toString());
			int t2num=Integer.parseInt(t2.getText().toString());
			int sum=0;
			if (t1num<t2num)
				for (int i=t1num;i<=t2num;i++)
				{
					sum=sum+i;
				}
			else
				{
				AlertDialog.Builder b=new AlertDialog.Builder(DullApp9.this);
				b.setTitle("關於");
				b.setMessage("開始值不可大於終止值");
				b.setPositiveButton("修改", null);
				b.show();
				}
			t3.setText(String.valueOf(sum));
			}
			catch(Exception e)
			{
				AlertDialog.Builder ad1=new AlertDialog.Builder(DullApp9.this);
				ad1.setTitle("不正常輸入");
				ad1.setMessage("資料型態錯誤-請重新輸入");
				ad1.setPositiveButton("確定", null);
				ad1.show();
			}
		}
		
	};

	Button.OnClickListener btlistener2=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			try{
			int t1num=Integer.parseInt(t1.getText().toString());
			int t2num=Integer.parseInt(t2.getText().toString());
			int sum=0;
			if (t1num<t2num)
				for (int i=t1num;i<=t2num;i++)
				{
					if ((i%2)==0)
						sum=sum+i;
				}
			else
				{
				AlertDialog.Builder b=new AlertDialog.Builder(DullApp9.this);
				b.setTitle("關於");
				b.setMessage("開始值不可大於終止值");
				b.setPositiveButton("修改", null);
				b.show();
				}
			t3.setText(String.valueOf(sum));
			}
			catch(Exception e)
			{
				AlertDialog.Builder ad1=new AlertDialog.Builder(DullApp9.this);
				ad1.setTitle("不正常輸入");
				ad1.setMessage("資料型態錯誤-請重新輸入");
				ad1.setPositiveButton("確定", null);
				ad1.show();
			}
		}
		
	};

	Button.OnClickListener btlistener3=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			try{
			int t1num=Integer.parseInt(t1.getText().toString());
			int t2num=Integer.parseInt(t2.getText().toString());
			int sum=0;
			if (t1num<t2num)
				for (int i=t1num;i<=t2num;i++)
				{
					if ((i%2)!=0)
						sum=sum+i;
				}
			else
				{
				AlertDialog.Builder b=new AlertDialog.Builder(DullApp9.this);
				b.setTitle("關於");
				b.setMessage("開始值不可大於終止值");
				b.setPositiveButton("修改", null);
				b.show();
				}
			t3.setText(String.valueOf(sum));
			}
			catch(Exception e)
			{
				AlertDialog.Builder ad1=new AlertDialog.Builder(DullApp9.this);
				ad1.setTitle("不正常輸入");
				ad1.setMessage("資料型態錯誤-請重新輸入");
				ad1.setPositiveButton("確定", null);
				ad1.show();
			}
		}
		
	};

	Button.OnClickListener btlistener4=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
		
		}
		
	};

}
