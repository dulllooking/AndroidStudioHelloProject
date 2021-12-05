package com.example.helloproject1;

public class Dullmaxmin1 {
	
	private int max;
	private int min;
	
	public void setvalue(int[] data){
		
		int len1=data.length;
		max=0;
		for (int i=0; i<len1; i++){
			if (max<data[i]){
				max=data[i];
			}
		}
		min=data[0];
		for (int j=0; j<len1; j++){
			if (min>data[j]){
				min=data[j];
			}
		}
	}
	
	public int getMax(){
		return max;
	}
	
	public int getMin(){
		return min;
	}
}
