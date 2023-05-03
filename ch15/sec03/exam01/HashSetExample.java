package ch15.sec03.exam01;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		//HashSet 생성
		Set<String> set = new HashSet<>();
		
		//객체 저장
		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Java");
		set.add("Spring");
		
		int size = set.size();
		System.out.println("총 객체 수: " + size);
	}
}
