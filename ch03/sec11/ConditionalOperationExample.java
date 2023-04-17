package ch03.sec11;

import java.util.Scanner;

public class ConditionalOperationExample {

	public static void main(String[] args) {
		
		// char grade = (score > 90)? 'A': ((score > 80)? 'B':'C');
		// 1. 조건문을 if문으로 작성
		// multi-select를 사용하여 키보드로부터 점수를 입력받으면 학점을 출력햐되 q or Q를 입력하면 종료.
		Scanner stdIn = new Scanner(System.in);
		
		char grade;
		
		while(true) {
			System.out.print("점수를 입력해주세요.: ");
			String score = stdIn.nextLine();
			if (score.equals("q") || score.equals("Q")) {
				System.out.println("종료합니다.");
				break;
			}else {
				int score2 = Integer.parseInt(score);
				if(score2 >= 90) {
					grade = 'A';
				}else if(score2 >= 80) {
					grade = 'B';
				}else if(score2 >= 70){
					grade = 'C';
				}else if(score2 >= 60){
					grade = 'D';
				}else {
					grade = 'F';
				}
			}
			

		System.out.println(score + "점은 " + grade + "등급입니다.");
		
		}

	}
		

}
