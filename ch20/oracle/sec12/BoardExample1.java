package ch20.oracle.sec12;

import java.util.Scanner;

public class BoardExample1 {
    Scanner scanner = new Scanner(System.in);

    public void list(){
        System.out.println();
        System.out.println("[게시물목록]");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s \n", "1", "winter", "2022.01.27", "게시판에 오신 것을 환영합니다.");
        System.out.printf("%-6s%-12s%-16s%-40s \n", "2", "winter", "2022.01.27", "올 겨울은 많이 춥습니다.");
        mainMenu();
    }

    public void mainMenu(){
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("메인메뉴: 1. create | 2. read | 3. clear | 4. exit");
        System.out.print("메뉴 선택: ");
        String strN = scanner.nextLine();
        int n = Integer.parseInt(strN);
        final int result = n;
        System.out.println(result);
        System.out.println();
    }

    public static void main(String[] args) {
        BoardExample1 boardExample = new BoardExample1();
        boardExample.list();
    }

}
