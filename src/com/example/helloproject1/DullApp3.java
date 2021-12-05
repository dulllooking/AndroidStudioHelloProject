package com.example.helloproject1;

import android.os.Bundle;//作業系統儲存容器
import android.app.Activity;//機動畫面函數庫
import android.view.View;//畫面動作監測套件
import android.widget.*;//按鈕UI套件
import android.app.AlertDialog;//對話方塊套件

public class DullApp3 extends Activity {
	EditText t1=null;
	EditText t2=null;
	EditText t3=null;
	EditText t4=null;
	EditText t5=null;
	EditText t6=null;
	EditText t7=null;
	EditText t8=null;
	EditText t9=null;
	
	Button bt1=null;
	Button bt2=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app3);
		t1=(EditText)findViewById(R.id.editText1);
		t2=(EditText)findViewById(R.id.editText2);
		t3=(EditText)findViewById(R.id.editText3);
		t4=(EditText)findViewById(R.id.editText4);
		t5=(EditText)findViewById(R.id.editText5);
		t6=(EditText)findViewById(R.id.editText6);
		t7=(EditText)findViewById(R.id.editText7);
		t8=(EditText)findViewById(R.id.editText8);
		t9=(EditText)findViewById(R.id.editText9);
		
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		
	}
	//主控按鈕->類別事件->動作函數->邏輯程式
	//主控按鈕類別事件new轉實體元件
	Button.OnClickListener btlistener1=new Button.OnClickListener()// 類別事件按鈕動作監測
	{

		//view視圖,arg0m元件變數(自訂名稱)
		@Override
		public void onClick(View arg0) {
			//執行按鈕,動作函數
			String id=t1.getText().toString();
			String name=t2.getText().toString();
			Toast.makeText(DullApp3.this, id+":"+name+"\n"+"分數計算中", Toast.LENGTH_LONG).show();//臨時輸出方塊
			//Toast.makeText(正在執行的類別.this,訊息內容,長時間顯示).show()顯示
			
			int t3num = Integer.parseInt(t3.getText().toString());
			int t4num = Integer.parseInt(t4.getText().toString());
			int t5num = Integer.parseInt(t5.getText().toString());
			int t6num = Integer.parseInt(t6.getText().toString());
			int t7num = Integer.parseInt(t7.getText().toString());
			//getText()為物件Object用toString()轉成字串Stringy再用int a = Integer.parseInt轉整數
			
			int t8num = (t3num + t4num + t5num + t6num + t7num);
			int t9num = t8num/5;
			
			t8.setText(String.valueOf(t8num));
			t9.setText(String.valueOf(t9num));
			//數值轉字串顯示在文字框
		}
		
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener()
	{

		@Override
		public void onClick(View arg0) {
			//清除按鈕,動作函數
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t9.setText("");
			
			AlertDialog.Builder b=new AlertDialog.Builder(DullApp3.this);//輸出對話方塊
			b.setTitle("關於");
			b.setMessage("資料已清除");
			b.setPositiveButton("確定", null);
			b.show();
		}
		
	};

}
