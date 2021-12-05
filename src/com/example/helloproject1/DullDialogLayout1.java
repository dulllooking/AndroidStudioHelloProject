package com.example.helloproject1;

import android.os.Bundle;
import android.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class DullDialogLayout1 extends Activity {
	
	Button bt1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_dialog_layout1);
		
		bt1=(Button)findViewById(R.id.button1);
		bt1.setOnClickListener(btlistener1);
	}

	
	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			AlertDialog.Builder ad1=new AlertDialog.Builder(DullDialogLayout1.this);
			ad1.setTitle("請輸入您的分數 : ");
			LayoutInflater inflater=LayoutInflater.from(DullDialogLayout1.this);
			final View v=inflater.inflate(R.layout.selfdialog1, null);
			ad1.setView(v);
			
			ad1.setPositiveButton("確定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					EditText et1=(EditText)(v.findViewById(R.id.editText1));
					dullfun1(et1.getText().toString());
				}
			});
			ad1.show();
		}
	};
	
	public void dullfun1(String s){ //自訂函數
		Toast.makeText(getApplicationContext(), "您的分數是 : " + s, Toast.LENGTH_LONG).show();
	}
	
}
