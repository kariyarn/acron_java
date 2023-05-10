package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		System.out.println("main메소드가 시작되었습니다.");
		
		try {
			/*
			 * 실행의 흐름을 스레드라고 하는데 스레드를 임의로 5초간 잡아두기
			 * 컴파일시에 발생하는 Exeption(RuntimeException을 상속받지 않은 Exception)
			 * 이 발생하기 때문에 반드시 try-catch블럭으로 예외 처리를 해줘야 한다.
			 */
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main메소드가 종료되었습니다.");
	}
}
