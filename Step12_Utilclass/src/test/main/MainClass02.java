package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass02 {
	public static void main(String[] args) {
		//정수를 저장할 수 있는 ArrayList<Interger> 객체를 생성해서 참조값을 지역변수 nums에 담기
		ArrayList<Integer> nums = new ArrayList<>();
		//ArrayList는 list를 implements하고 있어서 List로도 쓸 수 있다.
		List<String> names = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		System.out.print("입력할 문자열");
		
		for (int i = 0; i < 5; i++) {
			String txt = scan.nextLine();
			names.add(txt);
		}
		for(String tmp : names) {
			System.out.println(tmp);
		}
		
		//ArrayList 객체에 10, 20, 30 숫자 3개를 담아 보세요
		nums.add(10);
		nums.add(20);
		nums.add(30);		

		
		//확장 for 문을 이용해서 저장된 정수를 순서대로 콘솔창에 출력하기
		for(int tmp:nums) {
			System.out.println(tmp);
		}
		for(Integer tmp:nums) {
			System.out.println(tmp);
		}
		//일반 for문
		for(int i = 0; i<nums.size(); i++) {
			Integer tmp = nums.get(i);
			System.out.println(tmp);
		}
	}
}
