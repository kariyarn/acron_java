package test.main;

import test.dao.DeptDao;
import test.dto.DeptDto;

public class DeptText_update {
	public static void main(String[] args) {
		int deptno = 50;
		String dname = "NOTHING";
		String loc = "BUSAN";
	
		DeptDto dto = new DeptDto(deptno, dname, loc);
		boolean isSuccess = new DeptDao().update(dto);		
		if(isSuccess) {
			System.out.println("수정되었습니다.");
		}
		
	}
}
