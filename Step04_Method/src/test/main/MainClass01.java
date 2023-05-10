package test.main;
import java.io.File;
import java.util.Scanner;

import test.mypac.Airplane;
import test.mypac.Test;

public class MainClass01 {
	public static void main(String[] args) {
		Test t = new Test();
		//return type이 void인 메소드 호출
		t.walk();
		//return type이 int인 메소드 호출하고 리턴되는 값을 a라는 int type 지역변수에 담기
		int a = t.getNumber();
		//return type이 String인 메소드 호출하고 리턴되는 값을 b라는 String type 지역변수에 담기
		String b = t.getGreeting();
		
		boolean c = t.getCalcu();
		
		t.maDu();
		
		System.out.println("main 메소드가 종료 됩니다.");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		a = 99;
		
		System.out.println(a);
		System.out.println(t.getNumber());
		
		//return type이 Airplane인 메소드 호출하고 리턴되는 값을 c라는 Airplane type 지역변수에 담기,
		t.getPlane();
		Airplane e = t.getPlane();
		e.fly();
		
		//위에서 생성한 객체의 setName()의 메소드를 호출해 보세요
		t.setName("김구라");
		//위에서 생성한 객체의 setNum()의 메소드를 호출해 보세요
		t.setNum(11);
		//위에서 생성한 객체의 setAirplane()의 메소드를 호출해 보세요
		t.setPlane(new Airplane());
		t.doSomthing(10, "아브라카다브라", new Airplane());
		t.doSomthing(0, null, null);
		
		t.send();
		t.send(10);
		t.send("kariyarn");
		t.send(new Airplane());
		}
	}

