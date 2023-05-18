package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

/*
 * JDBC(Java DataBase Connectivity)
 * 
 * DataBase에 연결해서 SELECT, INSERT, UPDATE, DELETE작업하기
 * 
 * Oracle에 연결하기 위해서는 드라이버 클래스가 들어있는 ojdbc6.jar파일을
 * 사용할 수 있도록 설정해야 한다.
 * 
 * 프로젝트에 마우스 우클릭 => Build Path => Configure Build Path => Libraries 탭 선택
 * => classpath 선택 => 우측 Add External jar 버튼을 누른 후  => ojdbc6.jar파일을 찾은 다음=>apply;
 */
public class Test10 {
	public static void main(String[] args) {
		Connection conn=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle DB접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT empno, ename, deptno, job "
					+ " FROM emp "
					+ " ORDER BY empno ASC ";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int deptno = rs.getInt("deptno");
				String job = rs.getString("job");
				System.out.println(empno+" | "+ename+" | "+deptno + " | " + job);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
