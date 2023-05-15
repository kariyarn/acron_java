package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.mypac.Member;

public class MainClass07 {
	public static void main(String[] args) {
		Member mem = new Member();
		mem.name ="주뎅이";
		mem.addr ="봉천동";
		insert(mem);
		
		//아래의 메소드를 호출해서 위의 회원 정보가 DB에 저장되도록 프로그래밍 해 보세요
		//위의 정보를 Member 객체에 담아서 insert()메소드 매개 변수에 전달한다.
	}
	public static void insert(Member mem) {
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
					+" VALUES( member_seq.NEXTVAL, ?, ?) ";
			//미완성의 sql문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt=conn.prepareStatement(sql);
			//prepareStatement 객체의 메소드를 이용해서 미완성인 sql문을 완성시키기(?에 값 바인딩하기)
			pstmt.setString(1, mem.name);//1번째 ?에 문자열(name) 바인딩
			pstmt.setString(2, mem.addr);//2번째 ?에 문자열(addr) 바인딩
			//sql문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원 정보를 저장했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
