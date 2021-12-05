package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.*;

public class DullListview3 extends Activity {
	private int[] imgid={R.drawable.icon1,R.drawable.icon2,R.drawable.icon3,R.drawable.icon4,R.drawable.icon5};
	private String[] location={"合歡山","大壩山","太武山","玉山","雪山"};
	private int[] cost={500,2500,2000,3000,4000,3500};
	ListView lv1=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_listview3);
		
		lv1=(ListView)findViewById(R.id.listView1);
		myadapter2 com2=new myadapter2(DullListview3.this); //傳給外部類別
		lv1.setAdapter(com2);
		lv1.setOnItemClickListener(mylistenner1);
	}

	class myadapter2 extends BaseAdapter{
		
		private LayoutInflater myinflater; //LayoutInflater加載版面用
		public myadapter2(Context c){ //接收主類別資料
			myinflater=LayoutInflater.from(c);
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imgid.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View v, ViewGroup arg2) {
			//getView(索引位置,視圖,視圖群組)
			v=myinflater.inflate(R.layout.sublistview3, null);
			ImageView img1=(ImageView)v.findViewById(R.id.imageView1);//用v接收外部
			TextView tv1=(TextView)v.findViewById(R.id.textView1);
			TextView tv2=(TextView)v.findViewById(R.id.textView2);
			img1.setImageResource(imgid[arg0]);
			tv1.setText(location[arg0]);
			tv2.setText(String.valueOf(cost[arg0]));
			return v; //回傳給Listview1元件
		}
		
	}
	
	ListView.OnItemClickListener mylistenner1=new ListView.OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			int kimg=imgid[arg2];
			String s1=location[arg2];
			int cst=cost[arg2];
			
			AlertDialog.Builder ad1=new AlertDialog.Builder(DullListview3.this);
			ad1.setTitle("訊息輸出");
			ad1.setMessage(String.valueOf(kimg) + " " + s1 + " " + String.valueOf(cst));
			ad1.setPositiveButton("確定", null);
			ad1.show();
		}
		
	};
}
