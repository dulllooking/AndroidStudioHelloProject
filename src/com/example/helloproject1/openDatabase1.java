package com.example.helloproject1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class openDatabase1 extends SQLiteOpenHelper{
	//�Ψ����Ҧ����ε{���ɮצ@��
	
	private static final int databaseversion=1; //��Ʈw����
	private static final String databasename="productdata3.db"; //��Ʈw�W��
	private Context mycontext;
	private String strcreate="CREATE TABLE INFO(_id INTEGER PRIMARY KEY,name TEXT,blood TEXT,age TEXT,tel TEXT)";
	
	public openDatabase1(Context context) {
		super(context, databasename, null, databaseversion);
		mycontext=context;
		//�غc�l,���e���q��
		
		//Context context:���b���椤���O����奻
		//String name:��Ʈw�W��
		//CursorFactory factory:���оާ@��,�@��gnull
		//version:��Ʈw����
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//�إ�SQLite��Ʈw�M��ƪ�
		
		//SQLiteDatabase db:��Ʈw����
		db.execSQL(strcreate); //�}�l�����Ʈw�إ�
		Toast.makeText(mycontext, "��Ʈw�إߧ���", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//�P�_��Ʈw�O�_�s�b,�άO�_����s��Ʈw
		
		//SQLiteDatabase db:��Ʈw����
		//oldVersion:�L�ɪ���
		//newVersion:�s������
		Toast.makeText(mycontext, "��Ʈw�w�}��", Toast.LENGTH_SHORT).show();
	}

}
