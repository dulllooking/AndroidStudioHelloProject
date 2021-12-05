package com.example.helloproject1;

import android.os.Bundle;
import android.os.Handler;
import android.widget.*;
import android.app.Activity;

public class DullThread1 extends Activity {

	TextView tv1=null;
	Handler ha=new Handler(); //用來掌控所有執行緒流程
	int i=1;
	mythread mth;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_thread1);
		
		tv1=(TextView)findViewById(R.id.textView1);
		mth=new mythread(); //執行緒
		mth.start();
	}

	public class mythread extends Thread{
		public void run(){ //第一次啟動
			tv1.setText(String.valueOf(i));
			i++;
			ha.postDelayed(mth, 1000); //第二次以上循環
			if(i==9){
				i=1;
			}
		}
	}
}
