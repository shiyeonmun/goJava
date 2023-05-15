package ch20.oracle.sec12;

import java.util.Scanner;

public class BoardExample1 {
    Scanner scanner = new Scanner(System.in);

    public void list() {
        while (true) {
            System.out.println();
            System.out.println("[게시물목록]");
            System.out.println("-----------------------------------------------------");
            System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
            System.out.println("-----------------------------------------------------");
            System.out.printf("%-6s%-12s%-16s%-40s \n", "1", "winter", "2022.01.27", "게시판에 오신 것을 환영합니다.");
            System.out.printf("%-6s%-12s%-16s%-40s \n", "2", "winter", "2022.01.27", "올 겨울은 많이 춥습니다.");
            mainMenu();
        }
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("메인메뉴: 1. create | 2. read | 3. clear | 4. exit");
        System.out.print("메뉴 선택: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                create();
                break;
            case 2:
                read();
                break;
            case 3:
                clear();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("유효하지 않은 메뉴 선택입니다.");
        }
    }

    public void create() {
        // Logic for creating a new board post
        System.out.println("Create 메소드 실행");
    }

    public void read() {
        // Logic for reading a specific board post
        System.out.println("Read 메소드 실행");
    }

    public void clear() {
        // Logic for clearing the board
        System.out.println("Clear 메소드 실행");
    }

    public void exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }

    public static void main(String[] args) {
        BoardExample1 boardExample = new BoardExample1();
        boardExample.list();
    }
}
