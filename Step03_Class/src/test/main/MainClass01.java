package test.main;
import test.mypac.Car;

public class MainClass01 {
	//run했을 때 실행의 흐름이 시작되는 특별한 main 메소드
	public static void main(String[] args) {		
		/*
		 * 만일 달리고 싶다면 어떻게 해야할까?
		 */
		
		//Car 클래스로 객체를 생성하고 생성된 객체의 참조값을 car1이라는 지역변수에 담기
		Car car1 = new Car();
			//Car 객체의 참조값에 . 찍어서 메소드를 호출한다.
			//Car 객체의 참조값에 . 찍어서 필드 참조하기(참조해서 값 대입하기)
			car1.name = "소나타";
			car1.price = 1000;
			car1.drive();
			
			System.out.println(car1.name + "의 가격은 " + car1.price);
		
		//Car 클래스로 객체를 생성하고 생성된 객체의 참조값을 car2이라는 지역변수에 담기
		Car car2 = new Car();
			car2.name = "그랜저";
			car2.price = 2000;
			car2.drive();
			
			System.out.println(car2.price > car1.price);
			
			boolean result1 = car1 == car2; // false
			boolean result2 = car1.name == car2.name; //false
			System.out.println(result1);
			System.out.println(result2);
	}
}
