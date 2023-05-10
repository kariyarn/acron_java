package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MainClass03 {
	public static void main(String[] args) {
		
		ArrayList<String> greets = new ArrayList<>();
		
		greets.add("hello");
		greets.add("hi");
		greets.add("good night");	
		
		//ArrayList 객체를 생성해서 참조값을 List 인터페이스 type 변수에 대입하기
		List<String> greets2 = new ArrayList<>();
		greets2.add(null);

		//Consumer 인터 페이스 type의 참조값 얻어내기
		Consumer<String> con = new Consumer<>() {
			@Override
			public void accept(String t) {
				System.out.println("오잉 : " + t);
			}
		};

		greets.forEach(con);
		
		System.out.println("------------");
		
		greets.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println("오잉2: " + t);
			}
		});
		
		greets.forEach((t)->{
			System.out.println("오잉 3: " + t);
		});
		
	}
}
