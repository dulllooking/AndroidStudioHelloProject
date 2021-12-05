package com.example.helloproject1;

import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;


public class DullAutoComplete1 extends Activity {

	AutoCompleteTextView actv1 = null;
	Button bt1=null;
	Button bt2=null;
	ArrayAdapter<CharSequence> ad1 = null;
	String s="";
	private static final int x=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_auto_complete1);
		
		actv1=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		
		CharSequence[] data={"arduino","android","app","c","c++","cbuilder","raspberry","ruby","python"};
		ad1=new ArrayAdapter<CharSequence>(this,android.R.layout.simple_dropdown_item_1line,data);
		//<CharSequence>只能用字元序列這個型別
		actv1.setAdapter(ad1);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			//自定義對話方塊用
			s=actv1.getText().toString();
			showDialog(x);	//驅動AlertDialog
		}
	};

	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			actv1.setText("");
		}
	};
	
	//自定義對話方塊(視覺排版)
	@Override
	protected Dialog onCreateDialog(int d){ //建立:Dialog(元件),onCreateDialog(對話方塊),int d(識別參數)
		Toast.makeText(getApplicationContext(), String.valueOf(d), Toast.LENGTH_LONG).show();
		Builder b=null; //類別名稱
		Dialog dialog=null;
		b=new AlertDialog.Builder(DullAutoComplete1.this); //建構子,標準實體對話方塊(可和第1行合併編寫)
		
		b.setTitle("輸出訊號");
		b.setIcon(R.drawable.almondmilk);
		b.setMessage("輸出內文");
		b.setPositiveButton("確定", null);
		dialog=b.create(); //將實體元件重新建立給第2行的Dialog元件
		
		return dialog; //回傳給protected Dialog元件
	}
	
	//自定義對話方塊(資料更新)
	@Override
	protected void onPrepareDialog(int id, Dialog dialog, Bundle args){
		switch (id){
			case x: //id索引值從0開始,可以不宣告x都改成0
			{
				dialog.setTitle(actv1.getText());
				//onPrepareDialog無setMessage需強迫轉型成AlertDialog才能修改內容
				((AlertDialog) dialog).setMessage(actv1.getText()); 
				break;
			}
		}
		super.onPrepareDialog(id, dialog, args); //呼叫類別函數
	}
}
