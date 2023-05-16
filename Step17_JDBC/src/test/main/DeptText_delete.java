package test.main;

import test.dao.DeptDao;

public class DeptText_delete {
	public static void main(String[] args) {
		int deptno = 50;
		
		boolean isSuccess = new DeptDao().delete(deptno);
		if(isSuccess) {
			System.out.println("삭제했습니다.");
		}
	}
}
