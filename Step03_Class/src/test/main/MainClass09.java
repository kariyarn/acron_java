package test.main;
import test.mypac.Member;

public class MainClass09 {
	public static void main(String[] args) {
	
		
		Member mem1 = new Member();
		mem1.memNum = 1;
		mem1.memName = "김구라";
		mem1.memAddr = "노량진";
		
		Member mem2 = new Member();
		mem2.memNum = 2;
		mem2.memName = "해골";
		mem2.memAddr = "행신동";
		
		mem1.showInfo();
		mem2.showInfo();
	}
	
}
