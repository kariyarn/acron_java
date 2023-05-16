package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.DeptDto;
import test.util.DBConnect;

public class DeptDao {
	
	public DeptDto getData(int deptno) {
		DeptDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql문(select 문)
			String sql = " SELECT deptno, dname, loc "
					+ " FROM dept "
					+ " WHERE deptno = ? ";
			pstmt = conn.prepareStatement(sql);
			//select문이 미완성이라면 여기에서 완성한다.
			pstmt.setInt(1, deptno);
			//select 문을 수행하고 결과를 ResultSet으로 리턴받기
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet에 있는 row에 있는 정보를 추출한다.
			while (rs.next()) {
				//현재 커서가 존재하는 row에 있는 정보를 추출해서 사용한다.
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dto= new DeptDto();
				dto.setDeptno(deptno);
				dto.setDname(dname);
				dto.setLoc(loc);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return dto;
	}
	public List<DeptDto> getList() {
		List<DeptDto> list = new ArrayList<>();
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql문(select 문)
			String sql = " SELECT deptno, dname, loc"
					+ " FROM dept "
					+ " ORDER by deptno, dname, loc";
			pstmt = conn.prepareStatement(sql);
			//select문이 미완성이라면 여기에서 완성한다.

			//select 문을 수행하고 결과를 ResultSet으로 리턴받기
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet에 있는 row에 있는 정보를 추출한다.
			while (rs.next()) {
				//현재 커서가 존재하는 row에 있는 정보를 추출해서 사용한다.
				DeptDto dto = new DeptDto();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
	public boolean insert(DeptDto dto) {
		//인자로 전달된 num에 해당하는 회원정보를 삭제하는 기능을 완성해 보세요
		//DBConnect 클래스를 활용하세요
		Connection conn = null;
		//sql문을 대신 실행해줄 객체의 참조값을 담을 지역변수 미리 만들기
		PreparedStatement pstmt = null;
		int rowCount=0; //초기값을 0으로 부여한다. 
		try {
			conn = new DBConnect().getConn();
			//실행할 미완성의 sql문
			String sql = " INSERT INTO dept "
					+ " (deptno, dname, loc) "
					+ " VALUES ( ?, ?, ?) ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getDeptno());
			pstmt.setString(2, dto.getDname());
			pstmt.setString(3, dto.getLoc());
			pstmt.executeUpdate();
			System.out.println("입력했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		//변화된 row 의 갯수가 0 보다 크면 작업 성공
		if(rowCount > 0) {
			return true;
		}else {//그렇지 않으면 작업 실패
			return false;
		}
	}
	public boolean update(DeptDto dto) {
		//인자로 전달된 num에 해당하는 회원정보를 삭제하는 기능을 완성해 보세요
		//DBConnect 클래스를 활용하세요
		Connection conn = null;
		//sql문을 대신 실행해줄 객체의 참조값을 담을 지역변수 미리 만들기
		PreparedStatement pstmt = null;
		int rowCount=0; //초기값을 0으로 부여한다. 
		try {
			conn = new DBConnect().getConn();
			//실행할 미완성의 sql문
			String sql = " UPDATE dept"
					+ " SET dname = ? , loc = ? "
					+ " WHERE deptno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDname());
			pstmt.setString(2, dto.getLoc());
			pstmt.setInt(3, dto.getDeptno());
			pstmt.executeUpdate();
			System.out.println("부서 정보를 수정했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		//변화된 row 의 갯수가 0 보다 크면 작업 성공
		if(rowCount > 0) {
			return true;
		}else {//그렇지 않으면 작업 실패
			return false;
		}
	}
	public boolean delete(int num) {
		//인자로 전달된 num에 해당하는 회원정보를 삭제하는 기능을 완성해 보세요
		//DBConnect 클래스를 활용하세요
		Connection conn = null;
		//sql문을 대신 실행해줄 객체의 참조값을 담을 지역변수 미리 만들기
		PreparedStatement pstmt = null;
		int rowCount=0; //초기값을 0으로 부여한다. 
		try {
			conn = new DBConnect().getConn();
			//실행할 미완성의 sql문
			String sql = " DELETE FROM dept "
					+ " WHERE deptno = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			System.out.println("부서 정보를 삭제했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //예외가 발생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		//변화된 row 의 갯수가 0 보다 크면 작업 성공
		if(rowCount > 0) {
			return true;
		}else {//그렇지 않으면 작업 실패
			return false;
		}
	}
}
