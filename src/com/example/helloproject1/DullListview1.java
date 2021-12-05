package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.*;

public class DullListview1 extends Activity {
	ListView lv1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_listview1);
		
		lv1=(ListView)findViewById(R.id.listView1);
		String[] sdata={"程式設計班","美工設計班","系統設計班","資料庫設計班","網頁設計班"};
		ArrayAdapter<String> ap1=new ArrayAdapter<String>(DullListview1.this,android.R.layout.simple_list_item_1,sdata);
		lv1.setAdapter(ap1);
		
		lv1.setOnItemClickListener(lvlistener1);
		
	}

	ListView.OnItemClickListener lvlistener1=new ListView.OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			String s=arg0.getItemAtPosition(arg2).toString();
			AlertDialog.Builder ad1=new AlertDialog.Builder(DullListview1.this);
			ad1.setTitle("訊息輸出");
			ad1.setMessage(s);
			ad1.setPositiveButton("確定",null);
			ad1.show();
			
		}
		
	};

}
