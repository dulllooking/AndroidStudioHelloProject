package com.example.helloproject1;

import android.os.Bundle;//作業系統儲存容器
import android.app.Activity;//機動畫面函數庫
import android.view.View;//畫面動作監測套件
import android.widget.*;//UI套件
import android.app.AlertDialog;//對話方塊套件

public class DullApp2 extends Activity {
	EditText t1=null;
	EditText t2=null;
	Button bt1=null;
	Button bt2=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app2);
		t1=(EditText)findViewById(R.id.editText1);
		t2=(EditText)findViewById(R.id.editText2);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
	}
	
	Button.OnClickListener btlistener1=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			//動作函數
			String id=t1.getText().toString();
			String name=t2.getText().toString();
			Toast.makeText(DullApp2.this, id+":"+name, Toast.LENGTH_LONG).show();
		}
		
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			t1.setText("");
			t2.setText("");
			AlertDialog.Builder b=new AlertDialog.Builder(DullApp2.this);
			b.setTitle("關於");
			b.setMessage("資料已清除");
			b.setPositiveButton("確定", null);
			b.show();
		}
		
	};

}
