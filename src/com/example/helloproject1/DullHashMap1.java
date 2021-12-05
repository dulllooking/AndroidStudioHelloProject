package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
import android.view.View;
import android.app.AlertDialog;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class DullHashMap1 extends Activity {
	EditText et1 = null;
	EditText et2 = null;
	EditText et3 = null;
	Button bt1 = null;
	Button bt2 = null;
	Button bt3 = null;
	ListView lv1 = null;
	
	//HashMap<String,String> hm1=null; //HashMap作法
	List<HashMap<String,String>> alist=null; //ArrayList包HashMap作法用
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_hash_map1);
		
		//hm1=new HashMap<String,String>(); //HashMap作法
		alist=new ArrayList<HashMap<String,String>>();//ArrayList包HashMap作法用
		
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		et3=(EditText)findViewById(R.id.editText3);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		lv1=(ListView)findViewById(R.id.listView1);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
		lv1.setOnItemClickListener(lvlistener1);
	}
	
	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String sid=et1.getText().toString();
			String sname=et2.getText().toString();
			HashMap<String,String> hm1=new HashMap<String,String>();
			hm1.put("a", sid); //put置入容器
			hm1.put("b", sname); //put(key,value)
			alist.add(hm1); //add(object)置入容器
		}
		
	};

	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			et1.setText("");
			et2.setText("");
		}
		
	};

	Button.OnClickListener btlistener3=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String strall="";
			et3.setText("");
			
			for(int i=0; i<alist.size(); i++){
				HashMap<String,String> hm2=alist.get(i);
				strall=strall + hm2.get("a") + "  "+hm2.get("b") + "\n";
			} //get(key)取值
			et3.setText(strall);
			SimpleAdapter ad1=new SimpleAdapter(DullHashMap1.this,alist,android.R.layout.simple_list_item_2,new String[]{"a","b"},new int[]{android.R.id.text1,android.R.id.text2});
			//SimpleAdapter(主類別,來源資料,版型,來源資料陣列實體,目的陣列實體)
			lv1.setAdapter(ad1); //顯示輸出
		}
		
	};
	
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
					
			AlertDialog.Builder ad1=new AlertDialog.Builder(DullHashMap1.this);
			ad1.setTitle("訊息輸出");
			ad1.setMessage(tdata[1] + "  " + pdata2);
			ad1.setPositiveButton("確定",null);
			ad1.show();
		}
		
	};

	
}
