package test.main;

import test.mypac.Car;

public class MainClass05 {
	public static void main(String[] args) {
		Car car1 = new Car();
		car1.name = "소나타";
		car1.price = 1000;
		/*
		 *  아래의 메소드를 호출했을 때
		 *  
		 *  차의 이름은 소나타이고 가격은 1000만원 입니다.
		 *  
		 *  가 출력되게 Car 클래스의 showInfo()메소드안의 내용을 작성해보세요
		 */
		car1.showInfo();
	}
}
