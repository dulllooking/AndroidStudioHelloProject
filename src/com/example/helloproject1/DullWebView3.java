package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;
import android.app.Activity;


public class DullWebView3 extends Activity {

	EditText et1=null;
	WebView wv1=null;
	Button bt1=null;
	Button bt2=null;
	Button bt3=null;
	Button bt4=null;
	Button bt5=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_web_view3);
		
		et1=(EditText)findViewById(R.id.editText1);
		wv1=(WebView)findViewById(R.id.webView1);
		WebViewClient webc=new WebViewClient();
		wv1.setWebViewClient(webc); //建立網頁端
		
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		bt4=(Button)findViewById(R.id.button4);
		bt5=(Button)findViewById(R.id.button5);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
		bt4.setOnClickListener(btlistener4);
		bt5.setOnClickListener(btlistener5);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			wv1.goBack(); //上一頁
			
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			wv1.goForward(); //下一頁
			
		}
	};
	
	Button.OnClickListener btlistener3=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			wv1.reload(); //重新載入
			
		}
	};
	
	Button.OnClickListener btlistener4=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			et1.setText("");
			
		}
	};
	
	Button.OnClickListener btlistener5=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			if(et1.getText().toString().trim().equals("")){
				Toast.makeText(getApplicationContext(), "請輸入網址", Toast.LENGTH_LONG).show();
			}else{
				String url=et1.getText().toString();
				wv1.loadUrl(url); //載入網頁
				WebSettings wset=wv1.getSettings();
				wset.setJavaScriptEnabled(true);
				wset.setBuiltInZoomControls(true); //縮放
				wset.setJavaScriptCanOpenWindowsAutomatically(true); //視窗自動彈出
			}
			
		}
	};
	
}
