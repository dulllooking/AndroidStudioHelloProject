package com.example.helloproject1;

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

public class Persondatabase2 extends Activity {

	EditText et1=null;
	EditText et2=null;
	EditText et3=null;
	EditText et4=null;
	EditText et5=null;
	EditText et6=null;
	Button bt1=null;
	Button bt2=null;
	Button bt3=null;
	private List alist1=new ArrayList();
	private List alist2=new ArrayList();
	private List alist3=new ArrayList();
	private List alist4=new ArrayList();
	private List alist5=new ArrayList();
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
				openDatabase1 od=new openDatabase1(Persondatabase2.this);
				SQLiteDatabase sd=od.getWritableDatabase();
				String sql="select * from INFO";
				alist1.clear();
				alist2.clear();
				alist3.clear();
				alist4.clear();
				alist5.clear();
				Cursor c=sd.rawQuery(sql, null);
				c.moveToFirst();
				for(int i=0; i<c.getCount(); i++){
					int sid=c.getInt(0);
					if(sid==qid){
						String sname=c.getString(1);
						String sblood=c.getString(2);
						String sage=c.getString(3);
						String sschool=c.getString(4);
						alist1.add(sid);
						alist2.add(sname);
						alist3.add(sblood);
						alist4.add(sage);
						alist5.add(sschool);
						x=true;
					}
					c.moveToNext();
				}
				if(x==true){
					et2.setText(alist1.get(0).toString());
					et3.setText(alist2.get(0).toString());
					et4.setText(alist3.get(0).toString());
					et5.setText(alist4.get(0).toString());
					et6.setText(alist5.get(0).toString());
					x=false;
				}
				else{
					AlertDialog.Builder ad1=new AlertDialog.Builder(Persondatabase2.this);
					ad1.setTitle("訊息輸出");
					ad1.setMessage("無此筆資料存在");
					ad1.setPositiveButton("確定", null);
					ad1.show();
				}
				c.close();
				sd.close();
				od.close();
			}
			else{
				AlertDialog.Builder ad1=new AlertDialog.Builder(Persondatabase2.this);
				ad1.setTitle("訊息輸出");
				ad1.setMessage("請輸入整數編號");
				ad1.setPositiveButton("確定", null);
				ad1.show();
			}
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			openDatabase1 od=new openDatabase1(Persondatabase2.this);
			SQLiteDatabase sd=od.getWritableDatabase();
			int mid=Integer.parseInt(et2.getText().toString());
			String mname=et3.getText().toString();
			String mblood=et4.getText().toString();
			String mage=et5.getText().toString();
			String mtel=et6.getText().toString();
			ContentValues cv=new ContentValues();
			cv.put("name", mname);
			cv.put("blood", mblood);
			cv.put("age", mage);
			cv.put("tel", mtel);
			sd.update("INFO", cv, "_id="+mid, null);
			
			od.close();
			sd.close();
			
			Toast.makeText(Persondatabase2.this, "資料修改成功", Toast.LENGTH_LONG).show();
		}
	};
	
	Button.OnClickListener btlistener3=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			openDatabase1 od=new openDatabase1(Persondatabase2.this);
			SQLiteDatabase sd=od.getWritableDatabase();
			int did=Integer.parseInt(et2.getText().toString());
			sd.delete("INFO", "_id="+did, null);
			
			od.close();
			sd.close();
			Toast.makeText(Persondatabase2.this, "資料刪除成功", Toast.LENGTH_LONG).show();
		}
	};

}
