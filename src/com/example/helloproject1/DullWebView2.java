package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class DullWebView2 extends Activity {

	Button bt1=null;
	WebView wv1=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_web_view2);
		
		bt1=(Button)findViewById(R.id.button1);
		wv1=(WebView)findViewById(R.id.webView1);
		
		bt1.setOnClickListener(btlistener1);
	}
	
	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String shtml="<html><head><title></title></head>";
			shtml+="<body>";
			shtml+="<font size='6' color='#0000ff'>阿里山影像</font>";
			shtml+="</body>";
			shtml+="</html>";
			
			wv1.loadData(shtml, "text/html;charset=utf-*", null);
		}
	};
}
