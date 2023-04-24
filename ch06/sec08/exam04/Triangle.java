package ch06.sec08.exam04;

import java.util.Scanner;

public class Triangle {
	public static void main(String args []) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삼각형의 넓이를 구합니다.");
        
		System.out.print("밑변:");
		double a = sc.nextDouble();
        
		System.out.print("높이:");
		double b = sc.nextDouble();
        
		System.out.print("넓이는 "+(a*b/2)+"입니다.");
	}
}
