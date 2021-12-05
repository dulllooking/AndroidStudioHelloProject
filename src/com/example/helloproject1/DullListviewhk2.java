package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.content.Context;

public class DullListviewhk2 extends Activity {
	private int[] imgid={R.drawable.almondmilk,R.drawable.animaltrafficking,R.drawable.birdcage,R.drawable.juggling,R.drawable.sandbox,R.drawable.monkey,R.drawable.monitor,R.drawable.map,R.drawable.strategy};
	private String[] product={"java","c++","delphi","html","css","dart","groovy","kotlin","lua"};
	private String[] price={"價格"};
	private double[] cost={3360.00,5580.00,2350.00,3450.00,1550.00,4560.00,3780.00,1050.00,1300.00};
	GridView gv1=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_listviewhk2);
		gv1=(GridView)findViewById(R.id.gridView1);
		myadapterhk2 comhk2 = new myadapterhk2(DullListviewhk2.this);
		gv1.setAdapter(comhk2);
		gv1.setOnItemClickListener(glistener1);
	}
	
	
	class myadapterhk2 extends BaseAdapter{

		private LayoutInflater myinflaterhk2;
		
		public myadapterhk2(Context hk2){
			myinflaterhk2=LayoutInflater.from(hk2);
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
		public View getView(int arg0, View hk2v, ViewGroup arg2) {
			// TODO Auto-generated method stub
			hk2v=myinflaterhk2.inflate(R.layout.sublistviewhw2, null);
			ImageView iv1=(ImageView)hk2v.findViewById(R.id.imageView1);
			TextView tv1=(TextView)hk2v.findViewById(R.id.textView1);
			iv1.setImageResource(imgid[arg0]);
			tv1.setText(product[arg0]);
			return hk2v;
		}
	};

	GridView.OnItemClickListener glistener1=new GridView.OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			int kimg=imgid[arg2];
			String s1=product[arg2];
			String s2=price[0];
			double cst=cost[arg2];
			
			AlertDialog.Builder ad1=new AlertDialog.Builder(DullListviewhk2.this);
			ad1.setTitle("訊息輸出");
			ad1.setMessage(String.valueOf(kimg) + " " + s1 + "\n" + s2 + " : " + String.valueOf(cst));
			ad1.setPositiveButton("確定", null);
			ad1.show();
		}
	};
}
