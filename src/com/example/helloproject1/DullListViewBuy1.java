package com.example.helloproject1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.*;

public class DullListViewBuy1 extends Activity {

	ListView lv1=null;
	ListView lv2=null;
	EditText et1=null;
	Button bt1=null;
	Button bt2=null;
	private String[] location={"合歡山","大壩山","太武山","玉山","雪山"};
	private String[] cost={"5000","2500","2000","3000","4000","3500"};
	
	HashMap<String,String> hm1=null;
	List<HashMap<String,String>> adata1=new ArrayList<HashMap<String,String>>();
	
	HashMap<String,String> hm2=null;
	List<HashMap<String,String>> adata2=new ArrayList<HashMap<String,String>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_list_view_buy1);
		lv1=(ListView)findViewById(R.id.listView1);
		lv2=(ListView)findViewById(R.id.listView2);
		et1=(EditText)findViewById(R.id.editText1);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		
		int len1=location.length;
		for(int i=0; i<len1; i++)
		{
			hm1=new HashMap<String,String>();
			hm1.put("a", location[i]);
			hm1.put("b", cost[i]);
			adata1.add(hm1);
		}
		SimpleAdapter ap1=new SimpleAdapter(DullListViewBuy1.this,adata1,android.R.layout.simple_expandable_list_item_2,new String[]{"a", "b"}
												,new int[]{android.R.id.text1, android.R.id.text2});
		lv1.setAdapter(ap1);
		
		lv1.setOnItemClickListener(mylistenner1);
		lv2.setOnItemClickListener(mylistenner2);
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
	}

	ListView.OnItemClickListener mylistenner1=new ListView.OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			String s1=location[arg2];
			String s2=cost[arg2];
			
			hm2=new HashMap<String,String>();
			hm2.put("c", s1);
			hm2.put("d", s2);
			adata2.add(hm2);
			SimpleAdapter ap2=new SimpleAdapter(DullListViewBuy1.this,adata2,android.R.layout.simple_expandable_list_item_2,new String[]{"c", "d"}
													,new int[]{android.R.id.text1, android.R.id.text2});
			lv2.setAdapter(ap2);
		}
	};
	
	ListView.OnItemClickListener mylistenner2=new ListView.OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			adata2.remove(arg2);
			SimpleAdapter ap2=new SimpleAdapter(DullListViewBuy1.this,adata1,android.R.layout.simple_expandable_list_item_2,new String[]{"c", "d"}
												,new int[]{android.R.id.text1, android.R.id.text2});
			lv2.setAdapter(ap2);
		}
	};
	
	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			int len2=lv2.getCount(); //計算有幾筆資料
			int sum=0;
			for(int i=0; i<len2; i++){
				HashMap<String,String> k=adata2.get(i);
				int p=Integer.parseInt(k.get("d").toString());
				sum=sum+p;
			}
			et1.setText(String.valueOf(sum));
		}
	};

	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			et1.setText("");
			int len3=adata2.size();
			
			for(int j=0; j<len3; j++){
				adata2.remove(0); //集合資料刪除第0筆,因為集合資料刪除後,後方資料會往前推
			}
			SimpleAdapter ap2=new SimpleAdapter(DullListViewBuy1.this,adata1,android.R.layout.simple_expandable_list_item_2,new String[]{"c", "d"}
												,new int[]{android.R.id.text1, android.R.id.text2});
			lv2.setAdapter(ap2);
		}
	};

}
