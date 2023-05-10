package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		//1. 키보드로부터 문자열을 입력 받을 수 있는 scanner 객체를 생성해서 scan이라는 지역 변수에 담는다.
		Scanner scan = new Scanner(System.in);
		//2. 문자열을 저장할 수 있는 ArrayList 객체를 생성해서 msgs라는 지역변수에 담는다.
		List<String> msgs = new ArrayList<>();
		//3. 반복문을 5번 돌면서 문자열을 5번 입력 받는데 입력받은 문자열을 ArrayList 객체에 순서대로 저장한다.
		for(int i = 0; i<5; i++) {
			System.out.print("문자열 입력 : ");
			String str = scan.nextLine();
			msgs.add(str);
			//입력 받은 문자열을 ArrayList 객체에 누적시키기
		}
		//4. 반복문을 활용해서 ArrayList에 담긴 모든 문자열을 순서대로 콘솔창에 출력하기.
		msgs.forEach((e)->{
			System.out.print(e + " | ");
		});
	}
}
