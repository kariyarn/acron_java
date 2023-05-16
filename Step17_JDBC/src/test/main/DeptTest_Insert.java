package test.main;

import test.dao.DeptDao;
import test.dto.DeptDto;

public class DeptTest_Insert {
	public static void main(String[] args) {
		int deptno = 50;
		String dname = "ASSISTANT";
		String loc = "SEOUL";
		DeptDto dto = new DeptDto();
		dto.setDeptno(deptno);
		dto.setDname(dname);
		dto.setLoc(loc);
		
		DeptDao dao = new DeptDao();
		boolean isSuccess = dao.insert(dto);
		if(isSuccess) {
			System.out.println("저장했습니다.");
		}
	}
}
