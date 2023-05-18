package test;

import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("출력할 구구단 단수 입력 : ");
		int num1 = scan.nextInt();
		for (int i = 1; i < 10; i++) {
			int num2 = i;
			int result = num1 * num2;
			System.out.println(num1 + " X " + num2 + " : " + result);
		}			
	}
}
