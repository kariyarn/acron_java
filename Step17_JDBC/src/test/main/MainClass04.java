package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass04 {
	public static void main(String[] args) {

		//3번 회원의 주소를 동물원으로 수정하고자 한다.
		int num = 1;
		String name ="정우성";
		String addr ="압구정동";
		
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
			String sql = " UPDATE member "
					+" SET addr = ? , name = ? "
					+" WHERE num = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setString(2, name);
			pstmt.setInt(3, num);
			pstmt.executeUpdate();
			System.out.println("회원 정보를 수정했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
