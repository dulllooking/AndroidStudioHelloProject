package com.example.helloproject1;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Persondatabase1 extends Activity {

	private EditText et1=null;
	private EditText et2=null;
	private EditText et3=null;
	private EditText et4=null;
	private EditText et5=null;
	private ListView lv1=null;
	private List alist=new ArrayList();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_persondatabase1);
		
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		et3=(EditText)findViewById(R.id.editText3);
		et4=(EditText)findViewById(R.id.editText4);
		et5=(EditText)findViewById(R.id.editText5);
		lv1=(ListView)findViewById(R.id.listView1);
		
		Button bt1=(Button)findViewById(R.id.button1);
		Button bt2=(Button)findViewById(R.id.button2);
		Button bt3=(Button)findViewById(R.id.button3);
		Button bt4=(Button)findViewById(R.id.button4);
		
		bt1.setOnClickListener(new mydblistener1());
		bt2.setOnClickListener(new mydblistener1());
		bt3.setOnClickListener(new mydblistener1());
		bt4.setOnClickListener(new mydblistener1());
		
	}

	public class mydblistener1 implements OnClickListener{

		@Override
		public void onClick(View v) {
			switch(v.getId()){
				case R.id.button1:
				{
					openDatabase1 od=new openDatabase1(Persondatabase1.this); //建立資料庫介面實體元件
					SQLiteDatabase sd=od.getWritableDatabase(); //元件執行模式
					String sql="select * from INFO"; //*表示全部,INFO資料表名稱
					Cursor c=sd.rawQuery(sql, null); //建立資料表指標器並加資料庫語言
					int ct=c.getColumnCount();
					int rt=c.getCount();
					Toast.makeText(Persondatabase1.this, "總欄位數:"+String.valueOf(ct)+"\n總記錄數:"+String.valueOf(rt), Toast.LENGTH_LONG).show();
					c.close();
					sd.close();
					od.close();
					break;
				}
				case R.id.button2:
				{
					openDatabase1 od=new openDatabase1(Persondatabase1.this);
					SQLiteDatabase sd=od.getWritableDatabase();
					boolean x=false;
					
					//新增資料
					if(et1.getText().toString().trim().equals("")){
						et1.setError("請輸入編號");
						et1.setFocusable(true); //預設就是true,如為false欄位會鎖定無法輸入
					}
					else{
						x=true;
						String strid=et1.getText().toString();
						String strname=et2.getText().toString();
						String strblood=et3.getText().toString();
						String strage=et4.getText().toString();
						String strtel=et5.getText().toString();
						
						ContentValues cv=new ContentValues();
						cv.put("_id", Integer.parseInt(strid));
						cv.put("name", strname);
						cv.put("blood", strblood);
						cv.put("age", strage);
						cv.put("tel", strtel);
						sd.insert("INFO", null, cv);
					}
					//新增資料
					od.close();
					sd.close();
					if(x==true){
						Toast.makeText(Persondatabase1.this, "新增資料成功", Toast.LENGTH_LONG).show();
					}
					break;
				}
				case R.id.button3:
				{
					et1.setText("");
					et2.setText("");
					et3.setText("");
					et4.setText("");
					et5.setText("");
					break;
				}
				case R.id.button4:
				{
					String[] sfield={"_id","name","blood","age","tel"};
					int[] stext={R.id.textView2,R.id.textView4,R.id.textView6,R.id.textView8,R.id.textView10};
					//alist.clear();
					
					openDatabase1 od=new openDatabase1(Persondatabase1.this);
					SQLiteDatabase sd=od.getWritableDatabase();
					String sql="select * from INFO";
					/*
					Cursor c=sd.rawQuery(sql, null);
					c.moveToFirst();
					for(int i=0; i<c.getCount(); i++){
						String stel=c.getString(4);
						alist.add(stel);
						c.moveToNext();
					}
					c.close()
					*/
					Cursor c2=sd.rawQuery(sql, null);
					@SuppressWarnings("deprecation")
					SimpleCursorAdapter sca=new SimpleCursorAdapter(Persondatabase1.this,R.layout.persondataitem1,c2,sfield,stext);
					lv1.setAdapter(sca);
					
					//c2.close(); //如果關閉指標器只能抓到一筆資料
					sd.close();
					od.close();
					
					lv1.setOnItemClickListener(mylistsublistener1);
					break;
				}
			}
		}
	}
	
	ListView.OnItemClickListener mylistsublistener1=new ListView.OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			String stel=alist.get(arg2).toString();
			Toast.makeText(Persondatabase1.this, "電話:"+stel, Toast.LENGTH_SHORT);
		}
	};
}
