package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class DullArraymaxmin1 extends Activity {

	EditText et1=null;
	EditText et2=null;
	EditText et3=null;
	EditText et4=null;
	EditText et5=null;
	EditText et6=null;
	EditText et7=null;
	Button bt1=null;
	Button bt2=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_arraymaxmin1);
		
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		et3=(EditText)findViewById(R.id.editText3);
		et4=(EditText)findViewById(R.id.editText4);
		et5=(EditText)findViewById(R.id.editText5);
		et6=(EditText)findViewById(R.id.editText6);
		et7=(EditText)findViewById(R.id.editText7);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
	}

	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			try
			{
				int[] data=new int[5];
				data[0]=Integer.parseInt(et1.getText().toString());
				data[1]=Integer.parseInt(et2.getText().toString());
				data[2]=Integer.parseInt(et3.getText().toString());
				data[3]=Integer.parseInt(et4.getText().toString());
				data[4]=Integer.parseInt(et5.getText().toString());
				
				Dullmaxmin1 dmn1=new Dullmaxmin1();
				dmn1.setvalue(data);
				int max=dmn1.getMax();
				int min=dmn1.getMin();
						
				et6.setText(String.valueOf(max));
				et7.setText(String.valueOf(min));	
			}catch (Exception ex){
				et1.setText("");
				et2.setText("");
				et3.setText("");
				et4.setText("");
				et5.setText("");
				et6.setText("");
				et7.setText("");
				
				AlertDialog.Builder b3=new AlertDialog.Builder(DullArraymaxmin1.this);
				b3.setTitle("非輸入正常數字");
				b3.setMessage("請輸入數字");
				b3.setPositiveButton("確定", null);
				b3.show();
			}
		}
	};

	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			et1.setText("");
			et2.setText("");
			et3.setText("");
			et4.setText("");
			et5.setText("");
			et6.setText("");
			et7.setText("");
		}
	};

}
