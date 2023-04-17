package ch03.sec08;

public class BitShiftExample2 {

	public static void main(String[] args) {
		int value = 772;
		
		byte byte1 = (byte) (value >>> 24);
		int int1 = byte1 & 255;
		System.out.println("첫 번째 바이트 부호 없는 값: " + int1);

	}

}
