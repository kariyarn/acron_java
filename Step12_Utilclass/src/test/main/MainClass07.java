package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * 세명의 회원정보(번호, 이름, 주소)를 HashMap 객체에 각각 담아서
		 * 
		 * ArrayList에 누적시켜 보세요
		 * 
		 * 반복문 돌면서 ArrayList에 누적된 회원정보를 콘솔창에 순서대로 출력해 보세요/
		 * 
		 * HashMap 객체 3개, ArrayList 객체 1개가 생성이 되어야 합니다.
		 * 
		 * ArrayList 객체 안에 hashMap을 담을 예정이니
		 * 
		 * List<HashMap<String, Object)>> 타입이 필요합니다.
		 */
		
		HashMap<String, Object> mem1 = new HashMap<>();
		mem1.put("num", 100);
		mem1.put("name", "김구라");
		mem1.put("주소", "노량진");
		
		HashMap<String, Object> mem2 = new HashMap<>();
		mem2.put("num", 101);
		mem2.put("name", "원숭이");
		mem2.put("주소", "동물원");
		
		HashMap<String, Object> mem3 = new HashMap<>();
		mem3.put("num", 102);
		mem3.put("name", "해골");
		mem3.put("주소", "지옥");
		
		List<HashMap<String, Object>> members = new ArrayList<>();
		members.add(mem1);
		members.add(mem2);
		members.add(mem3);
		
		/*
		 * for(int i = 0; i<members.size(); i++) { System.out.println(members.get(i)); }
		 */
		//확장 for문
		for(HashMap<String, Object> tmp : members) {
			//번호
			int num = (int)tmp.get("num");
			//이름
			String name = (String)tmp.get("name");
			//주소
			String addr = (String)tmp.get("주소");
			System.out.println("num"+num+ ", name"+name+", addr"+addr);

		}
	}

}
