package ch09.sec07.exam01;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;



	public class Java_Jinsu {

	 public static void main(String[] args) throws IOException{

	  BufferedReader my_in = new BufferedReader(new InputStreamReader(System.in));

	  int ken;
	  
	  System.out.print("10진수를 입력하세요 : ");
	  ken = Integer.parseInt(my_in.readLine());

	  System.out.println("10진수 :" +ken);
	  System.out.println("2진수 :" +Integer.toBinaryString(ken));
	  System.out.println("8진수 :" +Integer.toOctalString(ken));
	  System.out.println("16진수 :" +Integer.toHexString(ken));
	 }
	}



