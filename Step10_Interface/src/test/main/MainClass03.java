package test.main;

import test.mypac.Remocon;

public class MainClass03 {
	public static void main(String[] args) {
		//아래의 useRemocon() 메소드를 호출하기 위해서는 Remocon 인터페이스 type의 참조값이 필요하다.
		//익명의 Local Inner Class를 이용해서 Remocon type의 참조값을 만들내서 호출해 보자
		Remocon r1 = new Remocon() {
			@Override
			public void up() {
				System.out.println("기분 업업");
			}
			@Override
			public void down() {
				System.out.println("기분 다운다운");
			}		
		};
		useRemocon(r1);
		useRemocon(new Remocon() {		
			@Override
			public void up() {
				System.out.println("얍");
			}
			@Override
			public void down() {
				System.out.println("얍얍");
			}
		});
		useRemocon(new Remocon() {
			
			@Override
			public void up() {
				System.out.println("그아앗");
			}
			
			@Override
			public void down() {
				System.out.println("그아아앗");
			}
		});
	}
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
