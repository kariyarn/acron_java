package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass05 {
	public static void main(String[] args) {

		//4번 회원을 삭제해보세요
		int num = 4;
		
		Connection conn=null;
		
		try {
			//오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB의 정보@아이피주소 : port번호 :db이름
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle DB접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//sql문을 대신 실행해줄 객체의 참조값을 담을 지역변수 미리 만들기
		PreparedStatement pstmt = null;
		try {
			//실행할 미완성의 sql문
			String sql = " DELETE FROM member "
					+ " WHERE num = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			System.out.println("회원 정보를 삭제했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
