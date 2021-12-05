package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.*;


public class DullSpinner2 extends Activity {
	ImageView iv1=null;
	Spinner sp1=null;
	Button bt1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_spinner2);
		
		iv1=(ImageView)findViewById(R.id.imageView1);
		sp1=(Spinner)findViewById(R.id.spinner1);
		bt1=(Button)findViewById(R.id.button1);
		
		//String[] data={"預設選項","春天","夏天","秋天","冬天"}; //index 0,1,2,3,4 //方法1 直接設字串陣列
		String[] data=getResources().getStringArray(R.array.datasource); //方法2:需先在資源檔/res/values/strings.xml寫好字串陣列選項
		ArrayAdapter<String> ad1=new ArrayAdapter<String>(this,R.layout.myspinner1,data); //放到自訂的layout用於改變spinner文字大小顏色樣式
		sp1.setAdapter(ad1); //<String>泛型(限制)
		
		bt1.setOnClickListener(btlistener1);
		sp1.setOnItemSelectedListener(ilistener1);
		
	}

	Spinner.OnItemSelectedListener ilistener1=new Spinner.OnItemSelectedListener(){

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position,
				long id) {
			if (position==0)
			{
				iv1.setImageResource(R.drawable.fine);
			}
			if (position==1)
			{
				iv1.setImageResource(R.drawable.flower1);
			}
			if (position==2)
			{
				iv1.setImageResource(R.drawable.flower2);
			}
			if (position==3)
			{
				iv1.setImageResource(R.drawable.flower3);
			}
			if (position==4)
			{
				iv1.setImageResource(R.drawable.flower4);
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			sp1.setSelection(0);
			iv1.setImageResource(R.drawable.fine);
		}
		
	};
	

}
