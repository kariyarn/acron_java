package test.main;

import java.io.File;
import java.io.IOException;

public class MainClass05 {
	public static void main(String[] args) throws IOException {
		/*
		 * 현재 존재하거나 혹은 존재하지 않는 파일이나 폴더를 제어할 수 있는 file객체를 생성해서
		 * 참조값을 f라는 지역변수에 담기
		 */
		File f = new File("c:/acorn202304/myFolder/memo.txt");
		//File객체의 메소드를 활용해서
		//실제 memo.txt 파일이 존재하지 않으면 파일을 만들고
		//존재하면 memo.txt파일을 삭제하도록 프로그래밍 해보세요
		if(f.exists() == false) {
			f.createNewFile();
			System.out.println("파일이 생성되었습니다.");
		}else if(f.exists() == true) {
			f.delete();
			System.out.println("파일이 삭제되었습니다.");
		}
	}
}
