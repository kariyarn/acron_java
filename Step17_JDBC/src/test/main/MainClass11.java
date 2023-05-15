package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass11 {
	public static void main(String[] args) {
		int num = 3; //삭제할 회원의 번호라고 가정
		
		//아래의 delete()메소드를 이용해서 회원 정보를 삭제해보세요
		
		delete(num);
		
	}
	public static void delete(int num) {
		//인자로 전달된 num에 해당하는 회원정보를 삭제하는 기능을 완성해 보세요
		//DBConnect 클래스를 활용하세요
		Connection conn = null;
		//sql문을 대신 실행해줄 객체의 참조값을 담을 지역변수 미리 만들기
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnect().getConn();
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
