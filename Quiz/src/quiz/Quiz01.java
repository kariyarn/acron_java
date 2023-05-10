package quiz;

import java.util.Random;
import java.util.Scanner;

/*
//콘솔창으로 부터 문자열이나 숫자를 입력 받을수 있는 객체
Scanner   scan=new Scanner(System.in);

//랜덤한 숫자나 boolean 값을 얻어낼수 있는 객체
Random  ran=new Random();

/*
  위의 두가지 객체를 활용해서  가위,바위,보 게임을 만들어 보세요.
*/
public class Quiz01 {
	public static void main(String[] args) {

		System.out.println("숫자를 입력하세요(ㅁ0~3), 0은 가위, 1은 바위, 2는 보");	
		Scanner scan = new Scanner(System.in);
		
		int my = scan.nextInt();		
		Random ran = new Random();
		int com = ran.nextInt(0, 3);

		if(my == 0) {
			System.out.println("당신 : 가위");
		}else if(my == 1) {
			System.out.println("당신 : 바위");
		}else if(my == 2) {
			System.out.println("당신 :보");
		}
		
		if(com == 0) {
			System.out.println("COM : 가위");
		}else if(com == 1) {
			System.out.println("COM : 바위");
		}else if(com == 2) {
			System.out.println("COM :보");
		}
		
		
		if(my == com) {
			System.out.println("비겼습니다.");
		}else if(my > com){
			if(my == 2 && com == 0) {
				System.out.println("COM의 승리입니다.");
			}else {
				System.out.println("당신의 승리입니다.");
			}		
		}else if(my < com){
			if(my == 0 && com == 2) {
				System.out.println("당신의 승리입니다.");
			}else {
				System.out.println("COM의 승리입니다.");
			}	
		}
	}

}