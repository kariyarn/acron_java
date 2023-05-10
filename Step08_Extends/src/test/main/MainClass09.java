package test.main;

import test.util.Myutil;

public class MainClass09 {
	public static void main(String[] args) {
		Myutil u1 = new Myutil();
		//상속 받은 BaseUtil 클래스에 정의된 static 메소드도 모두 사용가능
		u1.send();
		u1.clear();
		u1.light();
	}
}
