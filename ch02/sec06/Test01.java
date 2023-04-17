package ch02.sec06;

public class Test01 {

	public static void main(String[] args) {
		
		int a = 10;
		int b= 3;
		
		double c = 0;
		
		c = (float)a/b; // float은 a에 붙던지 b에 붙던지 상관없다. 한 번만 쓰면 됨. 

//		System.out.println(c);
		System.out.printf("값은%10.4f", c); // 앞자리 수에 따라 앞에 문자나 숫자가 있을때 공백이 생긴다.

	}

}
