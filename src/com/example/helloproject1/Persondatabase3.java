package com.example.helloproject1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.helloproject1.Persondatabase1.mydblistener1;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Persondatabase3 extends Activity {

	EditText et1=null;
	EditText et2=null;
	EditText et3=null;
	EditText et4=null;
	EditText et5=null;
	EditText et6=null;
	Button bt1=null;
	Button bt2=null;
	Button bt3=null;
	
	boolean x=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_persondatabase2);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		et3=(EditText)findViewById(R.id.editText3);
		et4=(EditText)findViewById(R.id.editText4);
		et5=(EditText)findViewById(R.id.editText5);
		et6=(EditText)findViewById(R.id.editText6);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			if(!(et1.getText().toString().equals(""))){
				int qid=Integer.parseInt(et1.getText().toString());
				openDatabase1 od=new openDatabase1(Persondatabase3.this);
				SQLiteDatabase sd=od.getWritableDatabase();
				String sql="SELECT * FROM INFO WHERE _id="+qid;
				Cursor c=sd.rawQuery(sql, null); //rawQuery查詢
				int len1=c.getCount();
				
				if(len1 != 0){
					c.moveToFirst();
					et2.setText(String.valueOf(c.getInt(0)));
					et3.setText(c.getString(1).toString());
					et4.setText(c.getString(2).toString());
					et5.setText(c.getString(3).toString());
					et6.setText(c.getString(4).toString());
				}
				sd.close();
				od.close();
			}
			else{
				AlertDialog.Builder ad1=new AlertDialog.Builder(Persondatabase3.this);
				ad1.setTitle("訊息輸出");
				ad1.setMessage("無此筆資料存在");
				ad1.setPositiveButton("確定", null);
				ad1.show();
			}
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			openDatabase1 od=new openDatabase1(Persondatabase3.this);
			SQLiteDatabase sd=od.getWritableDatabase();
			int mid=Integer.parseInt(et2.getText().toString());
			String sn=et3.getText().toString();
			String sb=et4.getText().toString();
			String sa=et5.getText().toString();
			String st=et6.getText().toString();
			String sql="update INFO set name='"+sn+"',blood='"+sb+"',age='"+sa+"',tel='"+st+"' where _id="+mid;
			
			sd.execSQL(sql); //新增刪除修改都可使用
			od.close();
			sd.close();
			
			Toast.makeText(Persondatabase3.this, "資料修改成功", Toast.LENGTH_LONG).show();
		}
	};
	
	Button.OnClickListener btlistener3=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			openDatabase1 od=new openDatabase1(Persondatabase3.this);
			SQLiteDatabase sd=od.getWritableDatabase();
			int did=Integer.parseInt(et2.getText().toString());
			String sql="delete from INFO where _id="+did;
			
			sd.execSQL(sql);
			od.close();
			sd.close();
			Toast.makeText(Persondatabase3.this, "資料刪除成功", Toast.LENGTH_LONG).show();
		}
	};

}
