package com.example.helloproject1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class openDatabase2 extends SQLiteOpenHelper{

	private static final int databaseversion=1; //��Ʈw����
	private static final String databasename="productdata2.db"; //��Ʈw�W��
	private Context mycontext;
	private String strcreate="CREATE TABLE PRODUCT(_id INTEGER PRIMARY KEY,name TEXT,cost TEXT)"; //�����y��
	
	public openDatabase2(Context context) {
		super(context, databasename, null, databaseversion);
		mycontext=context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(strcreate); //�}�l�����Ʈw�إ�
		Toast.makeText(mycontext, "��Ʈw�إߧ���", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		Toast.makeText(mycontext, "��Ʈw�w�}��", Toast.LENGTH_SHORT).show();
	}

}
