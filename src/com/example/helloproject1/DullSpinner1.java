package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.app.Activity;
import android.app.AlertDialog;


public class DullSpinner1 extends Activity {
	Spinner sp1=null;
	Button bt1=null;
	Button bt2=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_spinner1);
		
		sp1=(Spinner)findViewById(R.id.spinner1);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		
		//String[] data={"程式設計","美工設計","系統設計","網頁設計","資料庫設計"}; //index 0,1,2,3,4 //方法1 直接設字串陣列
		String[] data=getResources().getStringArray(R.array.data2); //方法2:需先在資源檔/res/values/strings.xml寫好字串陣列選項
		ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,data);
		sp1.setAdapter(ad1); //<String>泛型(限制)
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		
	}
	
	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String s=sp1.getSelectedItem().toString(); //取值
			AlertDialog.Builder adb1=new AlertDialog.Builder(DullSpinner1.this);
			adb1.setTitle("訊息輸出");
			adb1.setMessage(s);
			adb1.setPositiveButton("確定",null);
			adb1.show();
			
		}
		
	};

	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			sp1.setSelection(0); //index從0開始 //設定值
		}
		
	};
	
}
