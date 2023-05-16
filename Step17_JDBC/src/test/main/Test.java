package test.main;

import java.util.List;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class Test {
	public static void main(String[] args) {
		int num = 5;
		
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.getListup(num);
		System.out.println(dao.getData(num).getName());

	}
}
