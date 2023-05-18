package test;

import java.util.Random;

public class Test08 {
	public static void main(String[] args) {
		Random ran = new Random();
		int ranNum = ran.nextInt(-10, 11);
		System.out.println(ranNum);
	}
}
