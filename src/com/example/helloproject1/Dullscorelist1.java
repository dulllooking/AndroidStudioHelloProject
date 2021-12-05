package com.example.helloproject1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class Dullscorelist1 extends Activity {

	ListView lv1=null;
	Button bt1=null;
	ArrayList kid1=new ArrayList();
	ArrayList kname1=new ArrayList();
	ArrayList kch1=new ArrayList();
	ArrayList ken1=new ArrayList();
	ArrayList kmath1=new ArrayList();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dullscorelist1);
		
		lv1=(ListView)findViewById(R.id.listView1);
		bt1=(Button)findViewById(R.id.button1);
		
		try{
			FileInputStream fis=openFileInput("score.txt"); //檔案輸入字串流
			InputStreamReader isr=new InputStreamReader(fis); //標準輸入字串流元件
			BufferedReader bis=new BufferedReader(isr); //標準讀取緩衝器元件
			String line1="";
			while((line1=bis.readLine()) != null){
				String[] sdata=line1.split(" ");
				kid1.add(sdata[0]);
				kname1.add(sdata[1]);
				kch1.add(sdata[2]);
				ken1.add(sdata[3]);
				kmath1.add(sdata[4]);
			}
			bis.close(); //Stream類關閉
			isr.close(); //Stream類關閉
			fis.close(); //Stream類關閉
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		myadapter2 adapt2=new myadapter2(Dullscorelist1.this);
		lv1.setAdapter(adapt2);
		
		bt1.setOnClickListener(btlistener1);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			Intent i2=new Intent(Dullscorelist1.this,StudentScore.class);
			startActivity(i2);
		}
	};

	public class myadapter2 extends BaseAdapter{
		LayoutInflater myinfla2;
		public myadapter2(Context c){
			myinfla2=LayoutInflater.from(c);
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return kid1.size();
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
			// TODO Auto-generated method stub
			v=myinfla2.inflate(R.layout.scorelist2, null);
			TextView tv1=(TextView)v.findViewById(R.id.textView1);
			TextView tv2=(TextView)v.findViewById(R.id.textView2);
			TextView tv3=(TextView)v.findViewById(R.id.textView3);
			TextView tv4=(TextView)v.findViewById(R.id.textView4);
			TextView tv5=(TextView)v.findViewById(R.id.textView5);
			tv1.setText(kid1.get(arg0).toString());
			tv2.setText(kname1.get(arg0).toString());
			tv3.setText(kch1.get(arg0).toString());
			tv4.setText(ken1.get(arg0).toString());
			tv5.setText(kmath1.get(arg0).toString());
			return v;
		}
	}
}
