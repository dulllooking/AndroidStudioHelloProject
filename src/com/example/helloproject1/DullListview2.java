package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.*;

public class DullListview2 extends Activity {
	ImageView iv1= null;
	Button bt1 = null;
	Button bt2 = null;
	Button bt3 = null;
	Button bt4 = null;
	int imageIndex = 0;
	int [] imageid={R.drawable.fine, R.drawable.fat, R.drawable.fat2, R.drawable.fat3, R.drawable.fat4, R.drawable.flower1, R.drawable.flower2, R.drawable.flower3, R.drawable.flower4, R.drawable.t1};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_listview2);
	
		iv1=(ImageView)findViewById(R.id.imageView1);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		bt4=(Button)findViewById(R.id.button4);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
		bt4.setOnClickListener(btlistener4);
	}
	
	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			imageIndex=0;
			iv1.setImageResource(imageid[0]);
		}
		
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if(imageIndex>0){
				imageIndex=imageIndex-1;
				iv1.setImageResource(imageid[imageIndex]);
			}
			if(imageIndex==0){
				Toast.makeText(DullListview2.this, "這是第一張!", Toast.LENGTH_SHORT).show();
			}
		}
		
	};
	
	Button.OnClickListener btlistener3=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if(imageIndex<(imageid.length-1)){
				imageIndex=imageIndex+1;
				iv1.setImageResource(imageid[imageIndex]);
			}
			if(imageIndex==(imageid.length-1)){
				Toast.makeText(DullListview2.this, "這是最後一張!", Toast.LENGTH_SHORT).show();
			}
		}
		
	};
	
	Button.OnClickListener btlistener4=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			imageIndex=(imageid.length-1);
			iv1.setImageResource(imageid[(imageid.length-1)]);
		}
		
	};
	
	
}
