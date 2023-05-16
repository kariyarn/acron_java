package test.main;

import java.util.List;

import test.dao.DeptDao;
import test.dao.MemberDao;
import test.dto.DeptDto;
import test.dto.MemberDto;

public class DeptText_getdata {
	public static void main(String[] args) {
		
		//번호로 select
		int num = 50;
		
		DeptDto dto = new DeptDao().getData(num);
		System.out.println(num);
		System.out.println(dto.getDname());
		System.out.println(dto.getLoc());
	
	}
}
