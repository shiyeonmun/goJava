package ch20.oracle.sec12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ch20.oracle.sec09.exam02.Board;

public class BoardExample3 {
    private Scanner scanner = new Scanner(System.in);
    private Connection conn;

    public BoardExample3(){
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
        System.out.println();
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

    private void exit() {
        System.exit(0);
    }

    public void mainMenu(){
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("메인메뉴: 1. create | 2. read | 3. clear | 4. exit");
        System.out.println("메뉴 선택: ");
        System.out.println();
    }

    public static void main(String[] args) {
        BoardExample3 boardExample = new BoardExample3();
        boardExample.list();
    }
}
