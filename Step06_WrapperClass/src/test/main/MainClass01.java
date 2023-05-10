package test.main;
/*
 * [기본 data type의 참조 데이터 data type]
 * 기본 데이터 | 참조 데이터
 * 
 * byte     : Byte
 * short    : Short
 * int      : Integer
 * long     : Long
 * 
 * float    : Float
 * double   : Double
 * 
 * char     : Character
 * boolean  : Boolean
 * 
 * - 때로는 기본 데이터 type의 참조데이터 type이 필요할 때가 있다.
 * - 기본 데이터 type을 객체에 포장(boxing)하는 형태이다.
 * - boxing과 unboxing은 자동으로 되기 때문에 프로그래머가 신경을 쓸 필요는 없다.
 */
public class MainClass01 {
	public static void main(String[] args) {
		int num1 = 10;
		//Integer num2 = new Interger(10); -> 굳이 이렇게 쓸 필요는 없다.
		// 참조 데이터 type num2;
		Integer num2 = 10;
		
		//참조 데이터 type이지만 기본 데이터 type처럼 사용할 수 있다.
		int result1 = num2+1;
		int result2 = num1+num2;
		
		//내용은 숫자이지만 type은 String인 것을 변환시켜주는 함수
		//Integer 클래스의 static 메소드를 이용해서 문자 "999"를 숫자 999로 변환할 수 있다.
		System.out.println(Integer.parseInt("999"));
	}
}
