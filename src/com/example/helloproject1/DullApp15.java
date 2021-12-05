package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.*;

public class DullApp15 extends Activity {
	EditText t1=null;
	EditText t2=null;
	EditText t3=null;
	Button bt1=null;
	Button bt2=null;
	RadioButton rbt1=null;
	RadioButton rbt2=null;
	RadioButton rbt3=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_app15);
		t1=(EditText)findViewById(R.id.editText1);
		t2=(EditText)findViewById(R.id.editText2);
		t3=(EditText)findViewById(R.id.editText3);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		rbt1=(RadioButton)findViewById(R.id.radio1);
		rbt2=(RadioButton)findViewById(R.id.radio2);
		rbt3=(RadioButton)findViewById(R.id.radio3);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener1);
		
	}

	View.OnClickListener btlistener1=new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			t2.setText("");
			String sdata2="";
			String sdata="";
			sdata=t1.getText().toString();
			int len1=sdata.length();
			char k=',';	//預設逗點防止未選
			int p=0;	//計算區塊數,最後要+1
			
			switch(arg0.getId())
			{
			case R.id.button1:
				{
				if(rbt1.isChecked())
				{
					k=rbt1.getText().toString().charAt(0);
				}
				if(rbt2.isChecked())
				{
					k=rbt2.getText().toString().charAt(0);
				}
				if(rbt3.isChecked())
				{
					k=rbt3.getText().toString().charAt(0);
				}
				
				for(int i=0;i<len1;i++)
				{
					char c=sdata.charAt(i);
					if(c==k)
					{
						p=p+1;
						sdata2=sdata2+"\n";
					}
					else
					{
						sdata2=sdata2+String.valueOf(c);
					}
				}
				t2.setText(sdata2);
				t3.setText(String.valueOf(p+1));
				break;
				}
			case R.id.button2:
				{
				rbt1.setChecked(false);
				rbt2.setChecked(false);
				rbt3.setChecked(false);
				t1.setText("");
				t2.setText("");
				t3.setText("");
				break;
				}
			}	
	
		}
	};
}
