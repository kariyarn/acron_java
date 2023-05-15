package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass02 {
	public static void main(String[] args) {
		//member 테이블에 추가할 회원의 정보라고 가정
		int num = 4;
		String name = "주뎅이";
		String addr = "봉천동";
		
		//DB연결객체를 담을 지역 변수 만들기
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
			String sql = " INSERT INTO member "
					+" (num, name, addr) "//띄어쓰기를 하지 않으면 오류가 날 수도 있다.
					+" VALUES(?, ?, ?) ";
			//미완성의 sql문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt=conn.prepareStatement(sql);
			//prepareStatement 객체의 메소드를 이용해서 미완성인 sql문을 완성시키기(?에 값 바인딩하기)
			pstmt.setInt(1, num);//1번째 ?에 숫자 바인딩
			pstmt.setString(2, name);//2번째 ?에 문자열 바인딩
			pstmt.setString(3, addr);//3번째 ?에 문자열 바인딩
			//sql문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원 정보를 저장했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
