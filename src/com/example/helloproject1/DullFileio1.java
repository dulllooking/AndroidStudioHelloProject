package com.example.helloproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DullFileio1 extends Activity {

	EditText et1=null;
	EditText et2=null;
	EditText et3=null;
	Button bt1=null;
	Button bt2=null;
	Button bt3=null;
	Toast toast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dull_fileio1);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		et3=(EditText)findViewById(R.id.editText3);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		
		bt1.setOnClickListener(btlistner1);
		bt2.setOnClickListener(btlistner2);
		bt3.setOnClickListener(btlistner3);
		
	}

	Button.OnClickListener btlistner1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			try{
				FileOutputStream fos=openFileOutput("dull2.txt", MODE_APPEND); //檔案輸出字串流
				BufferedOutputStream bos=new BufferedOutputStream(fos); //緩衝器輸出字串流
				String s1=et1.getText().toString();
				bos.write(s1.getBytes()); //寫入緩衝器(位元編碼)
				bos.write(" ".getBytes()); //空格方便資料處理
				String s2=et2.getText().toString();
				bos.write(s2.getBytes());
				bos.write("\n".getBytes()); //換行
				bos.close(); //關閉緩衝器
				toast=Toast.makeText(getApplication(), "資料寫入完成", 1000);
				toast.show();
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
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
	
	Button.OnClickListener btlistner3=new Button.OnClickListener(){
		
		@Override
		public void onClick(View arg0) {
			try{
				String str="";
				FileInputStream fis=openFileInput("dull2.txt");
				/* //此方法較複雜
				BufferedInputStream bis=new BufferedInputStream(fis);
				byte[] by=new byte[1024]; //位元陣列預設1024
				
				do{
					int flag=bis.read(by); //read讀取資料
					if(flag==-1){
						break;
					}
					else{
						str=new String(by);
					}
				}while(true);
				*/
				
				//此寫法較簡單,中文不易出現亂碼
				String line="";
				int p=1;
				InputStreamReader isr=new InputStreamReader(fis); //標準字串流元件
				BufferedReader bis=new BufferedReader(isr); //標準緩衝器元件
				while((line=bis.readLine()) != null){ //readLine讀取列
					str=str+String.valueOf(p) + "." + line + "\n";
					p=p+1;
				}
				bis.close(); //關閉標準緩衝器
				et3.setText(str);
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	};
	
}
