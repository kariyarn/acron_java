package test.mypac;
/*
 * Member 객체 하나에 회원의 번호, 이름, 주소를 담기 위해 Member 클래스를 설계하려고 한다.
 */
public class Member {
	//필드
	public int memNum;
	public String memName;
	public String memAddr;

	//메소드
	public void showInfo() {
		System.out.println("번호 : " + memNum);
		System.out.println("이름 : " + memName);
		System.out.println("주소 : " + memAddr);
	}
}
