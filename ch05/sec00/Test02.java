package ch05.sec00;

import java.util.Scanner;

public class Test02 { //3개의 정수를 입력받아 최대 공약수 구하기
	public static int function(int a, int b, int c) {
		int min = 0;
		if (a > b) {
			if (b > c) {
				min = c;
			}
			else {
				min = b;
			}
		} else {
			if (a > c) {
				min = c;
			} else {
				min = a;
			}
		}
		for (int i = min; i > 0; i--) {
			if (a % i == 0 && b % i == 0 && c % 1 == 0) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("3개의 정수를 입력하세요. : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println("최대 공약수 : " + function(a, b, c));

	}

}
