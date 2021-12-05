package com.example.helloproject1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.*;

public class DullOptionmenu1 extends Activity {

	EditText et1=null;
	MenuInflater minflater=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_optionmenu1);
		
		et1=(EditText)findViewById(R.id.editText1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.dull_optionmenu1, menu); //元件產生時自動生成
		minflater=getMenuInflater();
		minflater.inflate(R.menu.dullmenu2, menu);
		return super.onCreateOptionsMenu(menu); //抽象介面回傳給父類別,也可寫return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
			case R.id.a1:
			{
				et1.setText("功能一");
				break;
			}
			case R.id.a2:
			{
				et1.setText("功能二");
				break;
			}
			case R.id.a3:
			{
				et1.setText("功能三");
				break;
			}
			case R.id.a4:
			{
				et1.setText("功能四");
				break;
			}
			case R.id.a5:
			{
				et1.setText("功能五");
				break;
			}
		}
		return super.onOptionsItemSelected(item); //可用return true
	}

}
