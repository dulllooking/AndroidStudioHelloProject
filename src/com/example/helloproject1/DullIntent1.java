package com.example.helloproject1;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class DullIntent1 extends Activity {

	Button bt1=null;
	Button bt2=null;
	Button bt3=null;
	Button bt4=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_intent1);
		
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		bt4=(Button)findViewById(R.id.button4);
		
		bt1.setOnClickListener(btlistner1);
		bt2.setOnClickListener(btlistner2);
		bt3.setOnClickListener(btlistner3);
		bt4.setOnClickListener(btlistner4);
	}
	
	Button.OnClickListener btlistner1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
		
			Uri u1=Uri.parse("http://www.pchome.com.tw");
			Intent i1=new Intent(Intent.ACTION_VIEW, u1);
			startActivity(i1);
		}
	};
	
	Button.OnClickListener btlistner2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
		
			Uri u2=Uri.parse("tel:117");
			Intent i2=new Intent(Intent.ACTION_DIAL, u2);
			startActivity(i2);
		}
	};
	
	Button.OnClickListener btlistner3=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
		
			Uri u3=Uri.parse("tel:117");
			Intent i3=new Intent(Intent.ACTION_CALL, u3);
			startActivity(i3);
		}
	};
	
	Button.OnClickListener btlistner4=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			Intent i4=new Intent(DullIntent1.this,Dullsub1.class);
			startActivity(i4);
		}
	};
}
