package com.example.helloproject1;

import java.util.Timer; //時間
import java.util.TimerTask; //排程元件
import java.util.Date; //日期
import java.text.SimpleDateFormat; //日期時間格式化
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.*;
import android.app.Activity;


public class DullTimer1 extends Activity {

	TextView tv1=null;
	Timer t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_timer1);
		
		tv1=(TextView)findViewById(R.id.textView1);
		t1=new Timer();
		
		t1.schedule(tt1, 1000, 1000); //(排程函數, delay, 週期) 1秒=1000
	}

	//排程函數
	private TimerTask tt1=new TimerTask(){
		
		@Override
		public void run() {
			Message msg=new Message();
			msg.what=1; //int what旗標值(無意義),給Handler接收用
			ha.sendMessage(msg);
		}
	};

	private Handler ha=new Handler(){
		
		public void handleMessage(Message msg){
			
			if(msg.what == 1){
				SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss"); //HH,24小時制 //hh,12小時制
				tv1.setText(String.valueOf(sdf.format(new Date())));
			}
		}
	};
}
