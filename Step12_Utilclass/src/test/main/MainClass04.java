package test.main;

import java.util.ArrayList;
import java.util.List;
import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		//1. Car type을 저장할 수 있는 ArrayList 객체를 생성해서
		//참조값을 List 인터페이스 type 지역변수 cars에 담아 보세요
		
		List<Car> cars = new ArrayList<>();		
		//2. Car 객체(3개)를 생성해서 List 객체에 저장해 보세요.
		cars.add(new Car("소나타"));
		cars.add(new Car("싼타페"));
		cars.add(new Car("제네시스"));		
		//3. 일반 for문을 이용해서 List객체에 저장된 모든 Car 객체의 drive() 메소드를
		// 순서대로 호출해 보세요
		System.out.println("3. 일반 for문");
		for(int i = 0; i<cars.size(); i++) {
			cars.get(i).drive();
		}
		//4. 확장 for문을 이용해서 List객체에 저장된 모든 Car 객체의 drive() 메소드를
		//순서대로 호출해 보세요
		System.out.println("4.확장 for문");
		for(Car tem : cars) {
			tem.drive();
		}
		//5. Consumer 인터페이스를 활용해서 List 객체에 저장된 모든 Car객체의 drive()메소드를
		//순서대로 호출해 보세요
		//이건 이해안되면 안써도 상관없당
		System.out.println("5. forEach 활용");
		cars.forEach((c)->{
			c.drive();
		});
	}
}
