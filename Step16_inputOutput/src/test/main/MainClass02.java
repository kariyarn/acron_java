package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass02 {
	public static void main(String[] args) {
		//1byte처리 스트림
		InputStream is = System.in;
		//2byte처리 스트림
		InputStreamReader isr =  new InputStreamReader(is);
		System.out.println("입력");
		try {
			int code = isr.read();
			System.out.println("code : " + code);
			char ch = (char)code;
			System.out.println("char:"+ch);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
