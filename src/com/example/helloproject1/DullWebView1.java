package com.example.helloproject1;

import android.os.Bundle;
import android.widget.*;
import android.app.Activity;
import android.webkit.WebView;
import android.view.View;

public class DullWebView1 extends Activity {

	Button bt1=null;
	WebView wv1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_web_view1);
		
		bt1=(Button)findViewById(R.id.button1);
		wv1=(WebView)findViewById(R.id.webView1);
		
		bt1.setOnClickListener(btlistener1);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			wv1.loadUrl("htttp://www.google.com/");
		}
	};
}
