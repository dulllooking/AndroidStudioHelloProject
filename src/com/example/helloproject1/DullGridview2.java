package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class DullGridview2 extends Activity {
	String[] obj={"c++","c","delphi","html","lua","python","dart","grooy","kotlin"};
	String[] cost={"100","200","150","300","450","50","700","250","200"};
	EditText et1=null;
	EditText et2=null;
	GridView gv1=null;
	
	List<HashMap<String,String>> alist1=new ArrayList<HashMap<String,String>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_gridview2);
		
		gv1=(GridView)findViewById(R.id.gridView1);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		
		int len1=obj.length;
		for(int i=0; i<len1; i++){
			HashMap<String,String> mp1=new HashMap<String,String>();
			mp1.put("x", obj[i]);
			mp1.put("y", cost[i]);
			alist1.add(mp1);
		}
		
		SimpleAdapter sda1=new SimpleAdapter(this,alist1,android.R.layout.simple_list_item_2,new String[]{"x","y"},new int[]{android.R.id.text1,android.R.id.text2});
		gv1.setAdapter(sda1);
		
		gv1.setOnItemClickListener(glistener1);
		
	}
	GridView.OnItemClickListener glistener1=new GridView.OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			String s1=obj[arg2];
			String s2=cost[arg2];
			
			et1.setText(s1);
			et2.setText(s2);
		}
		
	};
	
}
