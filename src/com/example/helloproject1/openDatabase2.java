package com.example.helloproject1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class openDatabase2 extends SQLiteOpenHelper{

	private static final int databaseversion=1; //資料庫版本
	private static final String databasename="productdata2.db"; //資料庫名稱
	private Context mycontext;
	private String strcreate="CREATE TABLE PRODUCT(_id INTEGER PRIMARY KEY,name TEXT,cost TEXT)"; //中介語言
	
	public openDatabase2(Context context) {
		super(context, databasename, null, databaseversion);
		mycontext=context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(strcreate); //開始執行資料庫建立
		Toast.makeText(mycontext, "資料庫建立完成", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		Toast.makeText(mycontext, "資料庫已開啟", Toast.LENGTH_SHORT).show();
	}

}
