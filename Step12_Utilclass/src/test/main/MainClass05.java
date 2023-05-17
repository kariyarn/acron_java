package test.main;

import java.util.ArrayList;
import java.util.List;
import test.mypac.Member;

public class MainClass05 {
	public static void main(String[] args) {
		//1. Member 객체를 담을 수 있는 ArrayList 객체를 생성해서 참조값을 members라는 지역변수에 담아 주세요		
		List<Member> members = new ArrayList<>();
		//2. 3명의 회원정보를 Member 객체에 각각 담아 보세요
		Member mem1 = new Member(1, "김구라",	 "노량진");
		Member mem2 = new Member(2, "원숭이",	 "행신동");
		//디폴트 생성자를 호출해서 Member 객체를 생성하면
		Member mem3 = new Member();
		//필드를 직접 참조해서 값을 넣어 주어야 한다.
		mem3.num = 3;
		mem3.name = "고릴라";
		mem3.addr = "동물원";
		//3. 위에서 생성된 Member 객체의 참조값을 member List 객체에 모두 담아 보세요.
		members.add(mem1);
		members.add(mem2);
		members.add(mem3);
		/*
		 * 4. Member List에 담긴 내용을 이용해서 회원 목록을 아래와 같은 형식으로
		 * 반복문 돌면서 출력해 보세요
		 * 
		 * 번호 :1, 이름: 김구라, 주소: 노량진
		 * 번호 :2, 이름: 해골, 주소 : 행신동
		 */
		members.forEach((m)->{
			System.out.println("번호 : " + m.num + " | 이름 : " + m.name + " | 주소 : " + m.addr);
		});
		for(Member mem : members) {
			System.out.println(mem.num + " " + mem.name + " " + mem.addr);
		};
			
	}
}
