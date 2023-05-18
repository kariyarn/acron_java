package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.dto.MyStuffDto;
import test.util.DBConnect;

public class MyStuffDao {
	public MyStuffDto getData(int num) {
		MyStuffDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql문(select 문)
			String sql = " SELECT num, name, stuffnum, price, usage, not "
					+ " FROM mystuff "
					+ " WHERE num = ? ";
			pstmt = conn.prepareStatement(sql);
			//select문이 미완성이라면 여기에서 완성한다.
			pstmt.setInt(1, num);
			//select 문을 수행하고 결과를 ResultSet으로 리턴받기
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet에 있는 row에 있는 정보를 추출한다.
			while (rs.next()) {
				String name = rs.getString("name");
				int stuffNum = rs.getInt("stuffnum");
				int price = rs.getInt("price");
				String usage = rs.getString("usage");
				String note = rs.getString("note");
				dto = new MyStuffDto();
				dto.setNum(num);
				dto.setName(name);
				dto.setStuffNum(stuffNum);
				dto.setPrice(price);
				dto.setUsage(usage);
				dto.setNote(note);
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
	
	//전체 목록을 리턴하는 메소드
	public List<MyStuffDto> getList(){
		List<MyStuffDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql문(select 문)
			String sql = " SELECT num, name, stuffnum, price, usage, note "
					+ " FROM mystuff "
					+ " ORDER BY num DESC ";
			pstmt = conn.prepareStatement(sql);
			//select문이 미완성이라면 여기에서 완성한다.

			//select 문을 수행하고 결과를 ResultSet으로 리턴받기
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet에 있는 row에 있는 정보를 추출한다.
			while (rs.next()) {
				MyStuffDto dto = new MyStuffDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setStuffNum(rs.getInt("stuffnum"));
				dto.setPrice(rs.getInt("price"));
				dto.setUsage(rs.getString("usage"));
				dto.setNote(rs.getString("note"));
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
	
	public boolean insert(MyStuffDto dto) {
		//DBConnect 클래스를 활용하세요
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount=0; //초기값을 0으로 부여한다. 
		try {
			conn = new DBConnect().getConn();
			//실행할 미완성의 sql문
			String sql = " INSERT INTO mystuff "
					+ " (num, name, stuffNum, price, usage, note) "
					+ " VALUES(mystuff_seq.NEXTVAL, ?, ?, ?, ?, ? )";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getStuffNum());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getUsage());
			pstmt.setString(5, dto.getNote());
			
			rowCount= pstmt.executeUpdate();
			
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
	
	public boolean update(MyStuffDto dto) {
		//수정하는 메소드
		//DBConnect 클래스를 활용하세요
		Connection conn = null;
		//sql문을 대신 실행해줄 객체의 참조값을 담을 지역변수 미리 만들기
		PreparedStatement pstmt = null;
		int rowCount=0; //초기값을 0으로 부여한다. 
		try {
			conn = new DBConnect().getConn();
			//실행할 미완성의 sql문
			String sql = " UPDATE mystuff "
					+ " SET name = ?, "
					+ " stuffnum = ?, "
					+ " price = ? ,"
					+ " usage = ? ,"
					+ " note = ? "
					+ " WHERE num = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getStuffNum());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getUsage());
			pstmt.setString(5, dto.getNote());
			pstmt.setInt(6, dto.getNum());
			rowCount = pstmt.executeUpdate();
			
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
		//삭제하는 메소드
		//DBConnect 클래스를 활용하세요
		Connection conn = null;
		//sql문을 대신 실행해줄 객체의 참조값을 담을 지역변수 미리 만들기
		PreparedStatement pstmt = null;
		int rowCount=0; //초기값을 0으로 부여한다. 
		try {
			conn = new DBConnect().getConn();
			//실행할 미완성의 sql문
			String sql = " DELETE FROM mystuff "
					+ " WHERE num = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();			
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
