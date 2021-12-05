package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.content.Context;

public class DullListviewhk1 extends Activity {

	private int[] imgid={R.drawable.almondmilk,R.drawable.animaltrafficking,R.drawable.birdcage,R.drawable.juggling,R.drawable.sandbox,R.drawable.monkey,R.drawable.monitor,R.drawable.map,R.drawable.strategy};
	private String[] product={"栗子牛奶","鮮魚湯","鸚鵡蛋糕","棉花糖假髮","貓屎香咖啡","猴子樂團","廢材電腦","藏寶圖","大師簽名板"};
	private String[] location={"栗山農場","水生館","澳洲","佛光山","喵島","壽山動物園","PChome","ONE PIECE","10元商店"};
	private String[] price={"價格"};
	private double[] cost={60.00,80.00,230.00,340.00,150.00,560.00,780.00,10000.00,10.00};
	ListView lv1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_listviewhk1);
		
		lv1=(ListView)findViewById(R.id.listView1);
		myadapterhk1 comhk1 = new myadapterhk1(DullListviewhk1.this);
		lv1.setAdapter(comhk1);
		lv1.setOnItemClickListener(mylistenner1);
	}
	
	
	class myadapterhk1 extends BaseAdapter{

		private LayoutInflater myinflaterhk1;
		
		public myadapterhk1(Context hk1){
			myinflaterhk1=LayoutInflater.from(hk1);
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
		public View getView(int arg0, View hk1v, ViewGroup arg2) {
			// TODO Auto-generated method stub
			hk1v=myinflaterhk1.inflate(R.layout.sublistviewhw1, null);
			ImageView iv1=(ImageView)hk1v.findViewById(R.id.imageView1);
			TextView tv1=(TextView)hk1v.findViewById(R.id.textView1);
			TextView tv2=(TextView)hk1v.findViewById(R.id.textView2);
			TextView tv3=(TextView)hk1v.findViewById(R.id.textView3);
			TextView tv4=(TextView)hk1v.findViewById(R.id.textView4);
			iv1.setImageResource(imgid[arg0]);
			tv1.setText(product[arg0]);
			tv2.setText(location[arg0]);
			tv3.setText(price[0]);
			tv4.setText(String.valueOf(cost[arg0]));
			return hk1v;
		}
	};

	
	ListView.OnItemClickListener mylistenner1=new ListView.OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			int kimg=imgid[arg2];
			String s1=product[arg2];
			String s2=location[arg2];
			String s3=price[0];
			double cst=cost[arg2];
			
			AlertDialog.Builder ad1=new AlertDialog.Builder(DullListviewhk1.this);
			ad1.setTitle("訊息輸出");
			ad1.setMessage(String.valueOf(kimg) + "\n" + s1 + " " + s2 + "\n" +  s3 + " " + String.valueOf(cst));
			ad1.setPositiveButton("確定", null);
			ad1.show();

		}
	};
	
}
