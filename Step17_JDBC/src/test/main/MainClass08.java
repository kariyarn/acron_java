package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.mypac.Member;

public class MainClass08 {
	public static void main(String[] args) {
		//수정할 회원의 정보라고 가정하자
		int num  = 1;
		String name = "이정호";
		String addr = "아현동";
		
		Member mem = new Member();
		mem.num = num;
		mem.name = name;
		mem.addr = addr;
		
		MainClass08.update(mem);
		
		//아래의 update()메소드를 이용해서 회원정보가 수정되도록 해 보세요
		
	}
	
	public static void update(Member m) {
		//Member 객체에 담긴 정보를 이용해서 회원 정보를 수정하도록 해보세요
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
			pstmt.setString(1, m.addr);
			pstmt.setString(2, m.name);
			pstmt.setInt(3, m.num);
			pstmt.executeUpdate();
			System.out.println("회원 정보를 수정했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
