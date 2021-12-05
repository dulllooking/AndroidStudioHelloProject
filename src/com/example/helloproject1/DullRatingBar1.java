package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.*;

public class DullRatingBar1 extends Activity {

	RatingBar rb1=null;
	Button bt1=null;
	Button bt2=null;
	EditText et1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_rating_bar1);
		
		rb1=(RatingBar)findViewById(R.id.ratingBar1);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		et1=(EditText)findViewById(R.id.editText1);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		rb1.setOnRatingBarChangeListener(rblistener1);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			float k=rb1.getProgress(); //被控事件取值
			Toast.makeText(DullRatingBar1.this, String.valueOf(k), Toast.LENGTH_SHORT).show();
		}
	};
	
	RatingBar.OnRatingBarChangeListener rblistener1=new RatingBar.OnRatingBarChangeListener(){

		//主控事件
		@Override
		public void onRatingChanged(RatingBar arg0, float arg1, boolean arg2) {
			et1.setText(String.valueOf(arg1));
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			rb1.setProgress(0);
			et1.setText("");
		}
	};
}
