package test.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	//필드
	private Connection conn;
	//생성자
	public DBConnect() {
		try {
			//오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB의 정보@아이피주소 : port번호 :db이름
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//New DBConnect한 순간 conn-> 필드에 저장
			conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle DB접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//필드의 저장된 값을 리턴하는 메소드
	public Connection getConn() {
		return conn;
	}
}
