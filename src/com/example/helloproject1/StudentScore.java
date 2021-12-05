package com.example.helloproject1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;

public class StudentScore extends Activity {

	EditText et1=null;
	EditText et2=null;
	EditText et3=null;
	EditText et4=null;
	EditText et5=null;
	EditText et6=null;
	EditText et7=null;
	EditText et8=null;
	Button bt1=null;
	Button bt2=null;
	Button bt3=null;
	Button bt4=null;
	Toast toast;
	int total=0;
	float avg=0;
	int count=0; //計算輸入資料數量用
	boolean flag=false; //判斷學號是否重複用
	boolean check=false; //查詢判斷用
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_score);
	
		et1=(EditText)findViewById(R.id.editText1); //學號
		et2=(EditText)findViewById(R.id.editText2); //姓名
		et3=(EditText)findViewById(R.id.editText3); //國文分數
		et4=(EditText)findViewById(R.id.editText4); //英文分數
		et5=(EditText)findViewById(R.id.editText5); //數學分數
		et6=(EditText)findViewById(R.id.editText6); //學號查詢
		et7=(EditText)findViewById(R.id.editText7); //總分
		et8=(EditText)findViewById(R.id.editText8); //平均
		bt1=(Button)findViewById(R.id.button1); //新增
		bt2=(Button)findViewById(R.id.button2); //清除
		bt3=(Button)findViewById(R.id.button3); //查詢學號
		bt4=(Button)findViewById(R.id.button4); //列表
		
		bt1.setOnClickListener(btlistener1);
		bt2.setOnClickListener(btlistener2);
		bt3.setOnClickListener(btlistener3);
		bt4.setOnClickListener(btlistener4);
	}
	
	Button.OnClickListener btlistener1=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			try{
				String s1=et1.getText().toString();
				String s2=et2.getText().toString();
				String s3=et3.getText().toString();
				String s4=et4.getText().toString();
				String s5=et5.getText().toString();
				if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")){
					AlertDialog.Builder b1=new AlertDialog.Builder(StudentScore.this);
					b1.setTitle("部分無輸入");
					b1.setMessage("請填滿所有數值");
					b1.setPositiveButton("確定", null);
					b1.show();
				}
				else if(s1.length()<4){
					AlertDialog.Builder b2=new AlertDialog.Builder(StudentScore.this);
					b2.setTitle("學號為四碼數字");
					b2.setMessage("請填入四碼數字\n不足四碼前方請補0");
					b2.setPositiveButton("確定", null);
					b2.show();
				}
				else if(!(Integer.parseInt(s1)>=0
						&& Integer.parseInt(s1)<=9999
						&& Integer.parseInt(s3)>=0
						&& Integer.parseInt(s3)<=100
						&& Integer.parseInt(s4)>=0
						&& Integer.parseInt(s4)<=100
						&& Integer.parseInt(s5)>=0
						&& Integer.parseInt(s5)<=100)){
					AlertDialog.Builder b3=new AlertDialog.Builder(StudentScore.this);
					b3.setTitle("非輸入正常數字範圍");
					b3.setMessage("學號範圍0~9999\n分數範圍0~100");
					b3.setPositiveButton("確定", null);
					b3.show();
				}
				else{
					try{
						flag=true;
						if(count>0){
							FileInputStream fis=openFileInput("score.txt"); //檔案輸入字串流
							InputStreamReader isr=new InputStreamReader(fis); //標準輸入字串流元件
							BufferedReader bis=new BufferedReader(isr); //標準讀取緩衝器元件
							String line1="";
							//bis.mark(0); //標記起始位置
							while((line1=bis.readLine()) != null){
								String [] kdata=line1.split(" "); //拆分字串
								if(kdata[0].equals(s1)){
									AlertDialog.Builder b4=new AlertDialog.Builder(StudentScore.this);
									b4.setTitle("學號重複");
									b4.setMessage("請輸入新學號");
									b4.setPositiveButton("確定", null);
									b4.show();
									flag=false;
								}
							}
							//bis.reset(); //回到起始位置
							bis.close(); //Stream類關閉
							isr.close(); //Stream類關閉
							fis.close(); //Stream類關閉
						}	
						if(flag == true){
							FileOutputStream fos=openFileOutput("score.txt", MODE_APPEND); //檔案輸出字串流
							BufferedOutputStream bos=new BufferedOutputStream(fos); //緩衝器輸出字串流
							bos.write(s1.getBytes()); //寫入緩衝器(位元編碼)
							bos.write(" ".getBytes()); //空格方便資料處理
							bos.write(s2.getBytes()); //寫入緩衝器(位元編碼)
							bos.write(" ".getBytes());
							bos.write(s3.getBytes()); //寫入緩衝器(位元編碼)
							bos.write(" ".getBytes());
							bos.write(s4.getBytes()); //寫入緩衝器(位元編碼)
							bos.write(" ".getBytes());
							bos.write(s5.getBytes()); //寫入緩衝器(位元編碼)
							bos.write(" ".getBytes());
							bos.write("\n".getBytes());//換行
							bos.flush(); //清空緩存
							bos.close(); //關閉緩衝器
							fos.close(); //Stream類關閉
							toast=Toast.makeText(getApplication(), "資料寫入完成", 1000);
							toast.show();
							count++;
							flag=false;
						}
					}catch(FileNotFoundException e){
						e.printStackTrace();
					}catch(IOException e){
						e.printStackTrace();
					}
				}	
			}catch(Exception e){
				AlertDialog.Builder b5=new AlertDialog.Builder(StudentScore.this);
				b5.setTitle("非輸入正常數字");
				b5.setMessage("請輸入正常數字");
				b5.setPositiveButton("確定", null);
				b5.show();
			}
		}
	};
	
	Button.OnClickListener btlistener2=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			et1.setText("");
			et2.setText("");
			et3.setText("");
			et4.setText("");
			et5.setText("");
			et6.setText("");
			et7.setText("");
			et8.setText("");
		}
	};
	
	Button.OnClickListener btlistener3=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			try{
				String s6=et6.getText().toString();
				if(!(Integer.parseInt(s6)>=0 && Integer.parseInt(s6)<=9999)){
					AlertDialog.Builder b6=new AlertDialog.Builder(StudentScore.this);
					b6.setTitle("學號範圍0~9999");
					b6.setMessage("請輸入正常數字");
					b6.setPositiveButton("確定", null);
					b6.show();
				}
				else if((s6.equals(""))){
					AlertDialog.Builder b7=new AlertDialog.Builder(StudentScore.this);
					b7.setTitle("無填入查詢學號");
					b7.setMessage("請輸入有分數存檔學號");
					b7.setPositiveButton("確定", null);
					b7.show();
				}
				else if(s6.length()<4){
					AlertDialog.Builder b2=new AlertDialog.Builder(StudentScore.this);
					b2.setTitle("學號為四碼數字");
					b2.setMessage("請填入四碼數字\n不足四碼前方請補0");
					b2.setPositiveButton("確定", null);
					b2.show();
				}
				else{
					try{
						FileInputStream fis=openFileInput("score.txt"); //檔案輸入
						InputStreamReader isr=new InputStreamReader(fis); //標準字串流元件
						BufferedReader bis=new BufferedReader(isr); //標準緩衝器元件
						String line2="";
						String str1="";
						String str2="";
						String str3="";
						String str4="";
						String str5="";
						//bis.mark(0);
						while((line2=bis.readLine()) != null){
							String [] qdata=line2.split(" ");
							if(qdata[0].equals(s6)){
								str1=qdata[0];
								str2=qdata[1];
								str3=qdata[2];
								str4=qdata[3];
								str5=qdata[4];
								check=true;
							}
						}
						//bis.reset();
						bis.close(); //關閉緩衝器
						isr.close(); //stream類關閉
						fis.close(); //stream類關閉
						if(check == true){
							et1.setText(str1);
							et2.setText(str2);
							et3.setText(str3);
							et4.setText(str4);
							et5.setText(str5);
							total=(Integer.parseInt(str3) + Integer.parseInt(str4) + Integer.parseInt(str5));
							avg=((float)total)/3;
							NumberFormat nf=NumberFormat.getInstance();
							nf.setMaximumFractionDigits(2);
							et7.setText(String.valueOf(total));
							et8.setText(String.valueOf(nf.format(avg)));
							toast=Toast.makeText(getApplication(), "資料查詢&計算完成", 1000);
							toast.show();
							check=false;
						}
					}catch(FileNotFoundException e){
						e.printStackTrace();
					}catch(IOException e){
						e.printStackTrace();
					}
				}
			}catch(Exception e){
				et6.setText("");
				et7.setText("");
				et8.setText("");
				AlertDialog.Builder b8=new AlertDialog.Builder(StudentScore.this);
				b8.setTitle("無該學號分數資料");
				b8.setMessage("請輸入有分數存檔學號\n學號共四碼數字");
				b8.setPositiveButton("確定", null);
				b8.show();
			}
		}
	};
	
	Button.OnClickListener btlistener4=new Button.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			Intent i1=new Intent(StudentScore.this,Dullscorelist1.class);
			startActivity(i1);
		}
	};
	
}
