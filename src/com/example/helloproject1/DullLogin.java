package com.example.helloproject1;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.*;


public class DullLogin extends Activity {

	EditText et1=null;
	EditText et2=null;
	Button bt1=null;
	Button bt2=null;
	int count=1;
	String acountName="Dull";
	String password="1103";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_login);
		
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		
		bt1.setOnClickListener(btlistner1);
		bt2.setOnClickListener(btlistner2);
	}

	Button.OnClickListener btlistner1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			if(!(et1.getText().toString().equals("")) && !(et2.getText().toString().equals(""))){
				String s1=et1.getText().toString();
				String s2=et2.getText().toString();
				if(count<=3){
					if(s1.equals(acountName) && s2.equals(password)){
						Intent i1=new Intent(DullLogin.this,DullLoginSub.class);
						startActivity(i1);
					}
					else{
						AlertDialog.Builder b=new AlertDialog.Builder(DullLogin.this);
						b.setTitle("登入失敗");
						b.setMessage("帳號或密碼錯誤");
						b.setPositiveButton("重新輸入", null);
						b.show();
						count++;
					}
				}
				else{
					AlertDialog.Builder b=new AlertDialog.Builder(DullLogin.this);
					b.setTitle("錯誤三次");
					b.setMessage("系統拒絕登入");
					b.setPositiveButton("確定", null);
					b.show();
					bt1.setEnabled(false);
					bt2.setEnabled(false);
					et1.setEnabled(false);
					et2.setEnabled(false);
				}
			}
			else{
				AlertDialog.Builder b=new AlertDialog.Builder(DullLogin.this);
				b.setTitle("登入失敗");
				b.setMessage("請輸入完整帳號和密碼");
				b.setPositiveButton("確定", null);
				b.show();
			}
		}
	};
	
	Button.OnClickListener btlistner2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			et1.setText("");
			et2.setText("");
		}
	};
}
