package com.example.helloproject1;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Androiddb extends Activity {

	EditText et1=null;
	EditText et2=null;
	EditText et3=null;
	EditText et4=null;
	EditText et5=null;
	EditText et6=null;
	Button bt1=null;
	Button bt2=null;
	Button bt3=null;
	Button bt4=null;
	Button bt5=null;
	Button bt6=null;
	Button bt7=null;
	Button bt8=null;
	TextView tv1=null;
	boolean db=false; //判斷資料庫是否存在
	boolean savecheck=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_androiddb);
		
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		et3=(EditText)findViewById(R.id.editText3);
		et4=(EditText)findViewById(R.id.editText4);
		et5=(EditText)findViewById(R.id.editText5);
		et6=(EditText)findViewById(R.id.editText6);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		bt4=(Button)findViewById(R.id.button4);
		bt5=(Button)findViewById(R.id.button5);
		bt6=(Button)findViewById(R.id.button6);
		bt7=(Button)findViewById(R.id.button7);
		bt8=(Button)findViewById(R.id.button8);
		tv1=(TextView)findViewById(R.id.textView7);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
		bt4.setOnClickListener(btlistener4);
		bt5.setOnClickListener(btlistener5);
		bt6.setOnClickListener(btlistener6);
		bt7.setOnClickListener(btlistener7);
		bt8.setOnClickListener(btlistener8);
		//et1.setOnFocusChangeListener(etlistener1);
	}
/*
	EditText.OnFocusChangeListener etlistener1=new EditText.OnFocusChangeListener(){

		@Override
		public void onFocusChange(View arg0, boolean arg1) {
			String cid=et1.getText().toString();
			openDatabase2 od=new openDatabase2(Androiddb.this);
			SQLiteDatabase sd=od.getWritableDatabase();
			String sql="SELECT * FROM PRODUCT WHERE _id="+cid;
			Cursor c=sd.rawQuery(sql, null); //rawQuery查詢
			int len1=c.getCount();
			if((len1 != 0) && !(et1.getText().toString().trim().equals(""))){
				savecheck=true;
				AlertDialog.Builder ad1=new AlertDialog.Builder(Androiddb.this);
				ad1.setTitle("此筆資料已存在");
				ad1.setMessage("請重新輸入");
				ad1.setPositiveButton("確定", null);
				ad1.show();
				et1.setText("");
			}
			else{
				savecheck=false;
			}
			
			c.close();
			sd.close();
			od.close();
		}
	};
	*/
	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			openDatabase2 od=new openDatabase2(Androiddb.this); //建立資料庫介面實體元件
			SQLiteDatabase sd=od.getWritableDatabase(); //元件執行模式
			String sql="select * from PRODUCT"; //*表示全部,INFO資料表名稱
			Cursor c=sd.rawQuery(sql, null); //建立資料表指標器並加資料庫語言
			int ct=c.getColumnCount(); //總欄位數
			int rt=c.getCount(); //總記錄數
			Toast.makeText(Androiddb.this, "總欄位數:"+String.valueOf(ct)+"\n總記錄數:"+String.valueOf(rt), Toast.LENGTH_LONG).show();
			
			sd.close();
			od.close();
			db=true;
		}
	};

	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			openDatabase2 od=new openDatabase2(Androiddb.this);
			SQLiteDatabase sd=od.getWritableDatabase();
			boolean x=false;
			if(db==true){
				//新增資料
				if(et1.getText().toString().trim().equals("")){
					et1.setError("請輸入編號");
					et1.setFocusable(true);
				}
				else{
					if(savecheck==false){
						x=true;
						String strid=et1.getText().toString();
						String strname=et2.getText().toString();
						String strprice=et3.getText().toString();
					
						ContentValues cv=new ContentValues();
						cv.put("_id", Integer.parseInt(strid));
						cv.put("name", strname);
						cv.put("cost", strprice);
						sd.insert("PRODUCT", null, cv);
					}
				}
				//新增資料
				od.close();
				sd.close();
				if(x==true){
					Toast.makeText(Androiddb.this, "新增資料成功", Toast.LENGTH_SHORT).show();
				}
			}
		}
	};
	
	Button.OnClickListener btlistener3=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			et1.setText("");
			et2.setText("");
			et3.setText("");
		}
	};
	
	Button.OnClickListener btlistener4=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			if(db==true){
				openDatabase2 od=new openDatabase2(Androiddb.this);
				SQLiteDatabase sd=od.getWritableDatabase();
				boolean x=false;
				
				if(et1.getText().toString().trim().equals("")){
					et1.setError("無主鍵編號不可執行修改");
					et1.setFocusable(true);
				}
				else{
					x=true;
					int strid=Integer.parseInt(et1.getText().toString());
					String strname=et2.getText().toString();
					String strcost=et3.getText().toString();
					ContentValues cv=new ContentValues();
					cv.put("name", strname);
					cv.put("cost", strcost);
					sd.update("PRODUCT", cv, "_id="+strid, null);
				}
				
				od.close();
				sd.close();
				
				if(x==true){
					Toast.makeText(Androiddb.this, "資料修改成功", Toast.LENGTH_SHORT).show();
				}
			}
		}
	};
	
	Button.OnClickListener btlistener5=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			if(db==true){
				openDatabase2 od=new openDatabase2(Androiddb.this);
				SQLiteDatabase sd=od.getWritableDatabase();
				boolean x=false;
				if(et1.getText().toString().trim().equals("")){
					et1.setError("無主鍵編號不可執行刪除");
					et1.setFocusable(true);
				}
				else{
					x=true;
					int strid=Integer.parseInt(et1.getText().toString());
					sd.delete("PRODUCT", "_id="+strid, null);
				}
				od.close();
				sd.close();
				if(x==true){
					Toast.makeText(Androiddb.this, "資料刪除成功", Toast.LENGTH_SHORT).show();
				}
			}
		}
	};
	
	Button.OnClickListener btlistener6=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			if(db==true){
				openDatabase2 od=new openDatabase2(Androiddb.this);
				SQLiteDatabase sd=od.getWritableDatabase();
				if(et4.getText().toString().trim().equals("")){ //trim去掉使用者輸入空格
					et4.setError("請輸入編號");
					et4.setFocusable(true);
				}
				else{
					int qid=Integer.parseInt(et4.getText().toString());
					String sql="SELECT * FROM PRODUCT WHERE _id="+qid;
					Cursor c=sd.rawQuery(sql, null); //rawQuery查詢
					if(c.getCount() != 0){
						c.moveToFirst(); //cursor定位
						tv1.setText("");
						String alldata=String.valueOf(c.getInt(0))+" "+c.getString(1)+" "+c.getString(2);
						tv1.setText(alldata);
						et1.setText(String.valueOf(c.getInt(0)));
						et2.setText(c.getString(1).toString());
						et3.setText(c.getString(2).toString());
					}
					else{
						Toast.makeText(Androiddb.this, "查無此筆資料", Toast.LENGTH_SHORT).show();
					}
					c.close();
					sd.close();
					od.close();
				}
			}
			else{
				AlertDialog.Builder ad1=new AlertDialog.Builder(Androiddb.this);
				ad1.setTitle("訊息輸出");
				ad1.setMessage("無此筆資料存在");
				ad1.setPositiveButton("確定", null);
				ad1.show();
			}
		}
	};
	
	Button.OnClickListener btlistener7=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			if(db==true){
				tv1.setText("");
				openDatabase2 od=new openDatabase2(Androiddb.this); //建立資料庫介面實體元件
				SQLiteDatabase sd=od.getWritableDatabase(); //元件執行模式
				String sql="select * from PRODUCT"; //*表示全部,INFO資料表名稱
				Cursor c=sd.rawQuery(sql, null);
				c.moveToFirst();
				for(int i=0; i<c.getCount(); i++){
					String alldata=String.valueOf(c.getInt(0))+" "+c.getString(1)+" "+c.getString(2);
					tv1.append(alldata+"\n");
					c.moveToNext();
				}
				c.close();
				sd.close();
				od.close();
			}
		}
	};
	
	Button.OnClickListener btlistener8=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			if(db==true){
				tv1.setText("");
				boolean x=false;
				
				openDatabase2 od=new openDatabase2(Androiddb.this);
				SQLiteDatabase sd=od.getWritableDatabase();
				
				if(et5.getText().toString().trim().equals("") && et6.getText().toString().trim().equals("")){
					et5.setError("請輸入開始編號");
					et6.setError("請輸入結束編號");
					et5.setFocusable(true);
				}
				else{
					if(et5.getText().toString().trim().equals("")){
						et5.setError("請輸入開始編號");
						et5.setFocusable(true);
					}
					else if(et6.getText().toString().trim().equals("")){
						et6.setError("請輸入結束編號");
						et6.setFocusable(true);
					}
					else{
						x=true;
					}
				}
				if(x==true){
					int starid=Integer.parseInt(et5.getText().toString());
					int endid=Integer.parseInt(et6.getText().toString());
					String sql="SELECT * FROM PRODUCT WHERE _id>="+starid+" AND _id<="+endid;
					Cursor c=sd.rawQuery(sql, null);
					c.moveToFirst();
					for(int i=0; i<c.getCount(); i++){
						String alldata=String.valueOf(c.getInt(0))+" "+c.getString(1)+" "+c.getString(2);
						tv1.append(alldata+"\n");
						c.moveToNext();
					}
					c.close();
					sd.close();
					od.close();
				}
			}
			else{
				AlertDialog.Builder ad1=new AlertDialog.Builder(Androiddb.this);
				ad1.setTitle("資料範圍錯誤");
				ad1.setMessage("請填入範圍編號");
				ad1.setPositiveButton("確定", null);
				ad1.show();
			}
		}
	};
	
}
