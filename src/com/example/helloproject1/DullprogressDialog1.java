package com.example.helloproject1;

import java.util.Timer;

import com.example.helloproject1.DullThread1.mythread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.Button;

public class DullprogressDialog1 extends Activity {

	private ProgressDialog pd1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dullprogress_dialog1);
		
		Button bt1=(Button)findViewById(R.id.button1);
		bt1.setOnClickListener(btlistener1);
	}

	View.OnClickListener btlistener1=new View.OnClickListener(){

		@Override
		public void onClick(View v) {
			
			pd1=ProgressDialog.show(DullprogressDialog1.this, "訊息", "加載中...請稍後");
			new Thread(new Runnable(){
				
				public void run(){
					
					try{
						Thread.sleep(5000);
						h.sendEmptyMessage(0);
					}catch(Exception e){
						e.getStackTrace();
					}
				}
			}).start();
		}
	};

	private Handler h=new Handler(){
		
		public void handleMessage(Message msg){
			pd1.dismiss();
		}
	};
}
