package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
import android.view.View;
import android.app.AlertDialog;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class DullHashMap2 extends Activity {

	ListView lv1 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_hash_map2);
		
		lv1=(ListView)findViewById(R.id.listView1);
		String idtitle="TITLE";
		String idsubtitle="SUBTITLE";
		ArrayList<HashMap<String,String>> mylist = new ArrayList<HashMap<String,String>>();
		String[] sdata={"程式設計班","美工設計班","系統設計班","資料庫設計班","網頁設計班"};
		String[] cost={"5000","3000","2500","4500","3500"}; 
		for(int i=0; i<sdata.length; i++){
			HashMap<String, String> item = new HashMap<String, String>();
			item.put(idtitle, sdata[i]); //第一圈:("TITLE","程式設計班") 第二圈:("TITLE","美工設計班") ...
			item.put(idsubtitle, cost[i]); //第一圈:("SUBTITLE","5000") //第二圈:("SUBTITLE","3000") ... 
			mylist.add(item);
		}
		SimpleAdapter ap1=new SimpleAdapter(DullHashMap2.this,mylist,android.R.layout.simple_list_item_2,new String[]{idtitle,idsubtitle},new int[]{android.R.id.text1,android.R.id.text2});
		//SimpleAdapter(主類別,來源資料,版型,來源資料陣列實體,目的陣列實體)
		
		lv1.setAdapter(ap1);
		
		lv1.setOnItemClickListener(lvlistener1);
		
	}

	ListView.OnItemClickListener lvlistener1=new ListView.OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			String s=arg0.getItemAtPosition(arg2).toString(); //s取得內容為"{a=key輸入值,b=資料輸入值}"
			String[] kdata=s.split(","); //將s字串用split(,)依","分割字串為kdata[0]字串"{a=key輸入值",kdata[1]字串"b=資料輸入值}"
			String[] tdata=kdata[0].split("="); //將kdata[0]字串依"="分割字串為tdata[0]字串"{a",tdata[1]字串"key輸入值",取得結果1:tdata[1]
			String[] pdata=kdata[1].split("="); //將kdata[1]字串依"="分割字串為pdata[0]字串"b",pdata[1]字串"資料輸入值}"
			int len1=pdata[1].length(); //為了去掉pdata[1]字串"資料輸入值}"後方的"}"用
			String pdata2=pdata[1].substring(0,len1-1); //字串擷取substring(int beginIndex, int endIndex)
			// 結果1:tdata[1] , 結果2:pdata2
					
			AlertDialog.Builder ad1=new AlertDialog.Builder(DullHashMap2.this);
			ad1.setTitle("訊息輸出");
			ad1.setMessage(tdata[1] + "  " + pdata2);
			ad1.setPositiveButton("確定",null);
			ad1.show();
		}
		
	};

	
}
