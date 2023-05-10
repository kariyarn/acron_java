package test.main;

import test.auto.Car;
import test.auto.Engine;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * Car클래스는 default생성자가 없고
		 * Engine type의 참조값을 전달해야지만 호출되는 생성자를 가지고 있기때문에
		 * Car 객체를 생성하기 위해서는 반드시 Engine 객체의 참조값을 전달해 주어야 한다.
		 */
		Car c1 = new Car(null);
		c1.drive();
		Car c2 = new Car(new Engine());
		c2.drive();
		
	}
}
