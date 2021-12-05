package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.*;


public class DullGridview1 extends Activity {

	//private String[] str={"A","B","C","D","E","F","G","H","I","J","K","L","M"}; //直接給值方式
	private String[] str=null; //從strings.xml抓值用
	GridView gv1=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_gridview1);
		
		str=getResources().getStringArray(R.array.datasource2); //從/res/values/strings.xml抓值方式
		
		gv1=(GridView)findViewById(R.id.gridView1);
		ArrayAdapter<String> ads=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str);
		gv1.setAdapter(ads);
		
		gv1.setOnItemClickListener(glistener1);
		
	}

	GridView.OnItemClickListener glistener1=new GridView.OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			String s=str[arg2];
			
			AlertDialog.Builder ad1=new AlertDialog.Builder(DullGridview1.this);
			ad1.setTitle("訊息輸出");
			ad1.setMessage(s);
			ad1.setPositiveButton("確定", null);
			ad1.show();
		}
		
	};
}
