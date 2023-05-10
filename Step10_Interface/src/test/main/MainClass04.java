package test.main;

import test.mypac.Drill;

public class MainClass04 {
	public static void main(String[] args) {
		useDrill(new Drill() {
			@Override
			public void hole() {
				System.out.println("Fucking asshole을 뚫어요");
			}
		});
		
		useDrill(()->{
			System.out.println("구멍");
		});
		
	}
	
	
	public static void useDrill(Drill d) {
		d.hole();
		d.hole();
	}
}
