package ch04.sec06;

import java.util.Scanner;

public class id_pd_program {

	public static void main(String[] args) {
		// id는 ezen이고 password: 13245 3번 이내에 통과하면 OK, 초과하면 Get Out! 출력되는 프로그램 작성.
		Scanner scanner = new Scanner(System.in);
		String id = "ezen";
		String password = "12345";
		int count = 0;
		
		System.out.print("아이디를 입력하세요: ");
		String input_id = scanner.nextLine();
		
		
		if(!input_id.equals("ezen")) {
			System.out.println("아이디가 맞지 않습니다.");
			return;
		} else {
			
			while(true){
				
				
				if (input_id.equals("ezen")) {
					System.out.print("비밀번호를 입력하세요: ");
					String input_pd = scanner.nextLine();
					
					if(input_pd.equals("12345")) {
						System.out.println("Great!");
						return;
					} else if(!input_pd.equals("12345")){
						count++;
						System.out.println("비밀번호가 일치하지 않습니다.");
						
						if (count == 3) {
							System.out.println("Get Out!");
							return;
						
						}
					}
				} 
				
				
			}
			
		}
	
	}
	
}
