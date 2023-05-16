package ch20.oracle.sec12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ch20.oracle.sec09.exam02.Board;

public class BoardExample4 {
    private Scanner scanner = new Scanner(System.in);
    private Connection conn;

    public BoardExample4(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "java_cli",
                "java_cli"
            );

        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }
    }

    public void list(){
        System.out.println("[게시물목록]");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
        System.out.println("-----------------------------------------------------");
        
        try{
            String sql = "" + 
                "SELECT bno, btitle, bcontent, bwriter, bdate " + 
                "FROM boards " +
                "ORDER BY bno DESC";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                System.out.printf("%-6s%-12s%-16s%-40s \n",
                    board.getBno(),
                    board.getBwriter(),
                    board.getBdate(),
                    board.getBtitle()
                );
            }
            rs.close();
            pstmt.close();
        } catch(SQLException e){
            e.printStackTrace();
            exit();
        }

        mainMenu();
    }

    public void mainMenu(){
        System.out.println("-----------------------------------------------------");
        System.out.println("메인메뉴: 1. create | 2. read | 3. clear | 4. exit");
        System.out.print("메뉴 선택: ");
        System.out.println();
        String menuNo = scanner.nextLine();

        switch(menuNo){
            case "1" -> create();
            case "2" -> read(); 
            case "3" -> clear(); 
            case "4" -> exit(); 
        }
    }

    
    public void create(){
        Board board = new Board();
        System.out.println("[새 게시물 입력]");
        System.out.print("제목:");
        board.setBtitle(scanner.nextLine());
        System.out.print("내용:");
        board.setBcontent(scanner.nextLine());
        System.out.print("작성자:");
        board.setBwriter(scanner.nextLine());

        System.out.println("-----------------------------------------------------");
        System.out.println("보조메뉴: 1. ok | 2. cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        if(menuNo.equals("1")){
            try{
                String sql = "" +
                    "INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate) " +
                    "VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, SYSDATE)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, board.getBtitle());
                pstmt.setString(2, board.getBcontent());
                pstmt.setString(3, board.getBwriter());
                pstmt.executeUpdate();
                pstmt.close();        
            } catch(Exception e){
                e.printStackTrace();
                exit();
            }
        }
        list();
    }

    public void read() {
        System.out.println("*** read() 메소드 실행됨");
        list();
    }

    public void clear() {
        System.out.println("*** clear() 메소드 실행됨");
        list();
    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        BoardExample4 boardExample = new BoardExample4();
        boardExample.list();
    }

}

