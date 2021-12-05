package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.app.AlertDialog;

public class DullButtonChange1 extends Activity {

	Button bt1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_button_change1);
		
		bt1=(Button)findViewById(R.id.button1);
		bt1.setOnClickListener(btlistener1);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			String s=bt1.getText().toString();
			if(s.equals("開啟")){
				bt1.setText("關閉");
				
				AlertDialog.Builder ad1=new AlertDialog.Builder(DullButtonChange1.this);
				ad1.setTitle("訊息輸出");
				ad1.setMessage("裝置啟動中......");
				ad1.setPositiveButton("確定", null);
				ad1.show();
			}
			
			if(s.equals("關閉")){
				bt1.setText("開啟");
				
				AlertDialog.Builder ad1=new AlertDialog.Builder(DullButtonChange1.this);
				ad1.setTitle("訊息輸出");
				ad1.setMessage("裝置關閉中......");
				ad1.setPositiveButton("確定", null);
				ad1.show();
			}
		}
	};
}
