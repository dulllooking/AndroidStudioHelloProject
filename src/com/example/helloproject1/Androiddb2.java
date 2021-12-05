package com.example.helloproject1;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Androiddb2 extends Activity {

	EditText et1=null;
	EditText et2=null;
	Button bt1=null;
	Button bt2=null;
	Button bt3=null;
	Button bt4=null;
	Button bt5=null;
	RadioButton rb1=null;
	RadioButton rb2=null;
	RadioButton rb3=null;
	ListView lv1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_androiddb2);
		rb1=(RadioButton)findViewById(R.id.radio0);
		rb2=(RadioButton)findViewById(R.id.radio1);
		rb3=(RadioButton)findViewById(R.id.radio2);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		bt4=(Button)findViewById(R.id.button4);
		bt5=(Button)findViewById(R.id.button5);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		lv1=(ListView)findViewById(R.id.listView1);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
		bt4.setOnClickListener(btlistener4);
		bt5.setOnClickListener(btlistener5);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			String np1=et1.getText().toString();
			openDatabase2 od=new openDatabase2(Androiddb2.this); //建立資料庫介面實體元件
			SQLiteDatabase sd=od.getWritableDatabase(); //元件執行模式
			String[] sfield={"_id","name","cost"};
			int[] stext={R.id.textView1,R.id.textView2,R.id.textView3};
			String sql="select * from PRODUCT where name like '%"+np1+"%'";
			Cursor c=sd.rawQuery(sql, null); //建立資料表指標器並加資料庫語言
			
			@SuppressWarnings("deprecation")
			SimpleCursorAdapter sca=new SimpleCursorAdapter(Androiddb2.this,R.layout.androidbd2sub,c,sfield,stext);
			lv1.setAdapter(sca);
			
			sd.close();
			od.close();
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			et1.setText("");
			et2.setText("");
		}
	};
	
	Button.OnClickListener btlistener3=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			int coco=Integer.parseInt(et2.getText().toString());
			openDatabase2 od=new openDatabase2(Androiddb2.this); //建立資料庫介面實體元件
			SQLiteDatabase sd=od.getWritableDatabase(); //元件執行模式
			String[] sfield={"_id","name","cost"};
			int[] stext={R.id.textView1,R.id.textView2,R.id.textView3};
			String sql="select * from PRODUCT where ";
			
			if(rb1.isChecked()){
				sql=sql+"cost>="+coco;
			}
			
			if(rb2.isChecked()){
				sql=sql+"cost<="+coco;
			}
			
			if(rb3.isChecked()){
				sql=sql+"cost="+coco;
			}
			
			Cursor c=sd.rawQuery(sql, null); //建立資料表指標器並加資料庫語言
			
			@SuppressWarnings("deprecation")
			SimpleCursorAdapter sca=new SimpleCursorAdapter(Androiddb2.this,R.layout.androidbd2sub,c,sfield,stext);
			lv1.setAdapter(sca);
			
			sd.close();
			od.close();
		}
	};
	
	Button.OnClickListener btlistener4=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			openDatabase2 od=new openDatabase2(Androiddb2.this); //建立資料庫介面實體元件
			SQLiteDatabase sd=od.getWritableDatabase(); //元件執行模式
			String[] sfield={"_id","name","cost"};
			int[] stext={R.id.textView1,R.id.textView2,R.id.textView3};
			String sql="select * from PRODUCT order by _id ASC";
			Cursor c=sd.rawQuery(sql, null); //建立資料表指標器並加資料庫語言
			
			@SuppressWarnings("deprecation")
			SimpleCursorAdapter sca=new SimpleCursorAdapter(Androiddb2.this,R.layout.androidbd2sub,c,sfield,stext);
			lv1.setAdapter(sca);
			
			sd.close();
			od.close();
		}
	};
	
	Button.OnClickListener btlistener5=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			openDatabase2 od=new openDatabase2(Androiddb2.this); //建立資料庫介面實體元件
			SQLiteDatabase sd=od.getWritableDatabase(); //元件執行模式
			String[] sfield={"_id","name","cost"};
			int[] stext={R.id.textView1,R.id.textView2,R.id.textView3};
			String sql="select * from PRODUCT order by _id DESC";
			Cursor c=sd.rawQuery(sql, null); //建立資料表指標器並加資料庫語言
			
			@SuppressWarnings("deprecation")
			SimpleCursorAdapter sca=new SimpleCursorAdapter(Androiddb2.this,R.layout.androidbd2sub,c,sfield,stext);
			lv1.setAdapter(sca);
			
			sd.close();
			od.close();
		}
	};
}
