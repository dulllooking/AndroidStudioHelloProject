package com.example.helloproject1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class openDatabase1 extends SQLiteOpenHelper{
	//用來讓所有應用程式檔案共用
	
	private static final int databaseversion=1; //資料庫版本
	private static final String databasename="productdata3.db"; //資料庫名稱
	private Context mycontext;
	private String strcreate="CREATE TABLE INFO(_id INTEGER PRIMARY KEY,name TEXT,blood TEXT,age TEXT,tel TEXT)";
	
	public openDatabase1(Context context) {
		super(context, databasename, null, databaseversion);
		mycontext=context;
		//建構子,內容溝通用
		
		//Context context:正在執行中類別元件文本
		//String name:資料庫名稱
		//CursorFactory factory:指標操作器,一般寫null
		//version:資料庫版本
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//建立SQLite資料庫和資料表
		
		//SQLiteDatabase db:資料庫元件
		db.execSQL(strcreate); //開始執行資料庫建立
		Toast.makeText(mycontext, "資料庫建立完成", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//判斷資料庫是否存在,或是否有更新資料庫
		
		//SQLiteDatabase db:資料庫元件
		//oldVersion:過時版本
		//newVersion:新的版本
		Toast.makeText(mycontext, "資料庫已開啟", Toast.LENGTH_SHORT).show();
	}

}
