package test.main;
/*
 * 주석에 표기된 것 대로 코딩을 완성해 보세요
 */
public class MainClass02 {
	public static void main(String[] args) {
		//1. 콘솔 창에 "main 메소드가 시작되었습니다."를 출력하기.		
		//2. 국어점수 95를 kor이라는 변수에 담아보세요		
		//3. 영어접수 100을 eng라는 변수에 담아보세요.		
		//4. 국어 점수와 영어 점수의 평균을 구해서(연산자 활용) avg 라는 변수에 담아 보세요
		//5. 콘솔창에 avg 변수 안에 담긴 내용을 출력해 보세요
		
		System.out.println("Main 메소드가 시작되었습니다.");		
		int kor = 95;
		int eng = 100;
		double avg = (kor + eng)/2f;		
		System.out.println(avg);		
		
		System.out.println();
	}
}
