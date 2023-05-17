package test.main;
import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass01 {
	public static void main(String[] args) {
		
		/*
		 * Phone이라는 클래스를 상속받은 HandPhone클래스로 객체를 생성해서
		 * 그 참조값을 p1이라는 이름의 지역변수에 담기
		 */		
		HandPhone p1 = new HandPhone();
		Phone p2 = new HandPhone();
		/*
		 * HandPhone클래스의 생성자를 호출해서 객체를 생성했더니
		 * Phone 클래스의 생성자도 호출되는 걸 알 수 있다.
		 * 
		 * 따라서 HandPhone 객체도 생성되고 Phone객체도 같이 생성되었다는 걸 유추할 수 있다.
		 * 
		 * Phone객체와 HandPhone객체가 생성되어서 같은 사물함에 들어간다.
		 * 
		 * 즉, 하나의 참조값으로 Phone의 기능, HandPhone의 의 기능을 모두 사용할 수 있다.
		 */
		p1.call();
		p1.mobileCall();
		p1.takePicture();
		
		//phone에는 메소드가 call밖에 없어서 call메소드밖에 호출 불가능
		
		p2.call();
	}
}
