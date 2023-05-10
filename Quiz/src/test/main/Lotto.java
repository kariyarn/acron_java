package test.main;
//처음에 만든 버전이 오류가 좀 많이나서 다른 분들거 조금 참고해서 다시 만들었습니다.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
	public static void main(String[] args) {
		System.out.println("로또를 몇장 사십니까 : ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();		
		Random ran = new Random();
		List<Integer> lotto = new ArrayList<>();
		//중복값 허용 X
		
		for(int i = 0; i<num; i++) {
			Set<Integer> lottoNum = new HashSet<>(lotto);
			//로또 번호 추출
			for(int j = 0; j < 6; j++) {
				//if일때는 잘 안됐는데 while을 쓰니까 잘 되는 이유가 궁금합니다.
				
				 //방 사이즈가 만약 7보다 작다면
				 if(lottoNum.size() < 7) {
				 int ranNum = ran.nextInt(1, 46);
				 lottoNum.add(ranNum);
				 j--;
				 //만약 방 사이즈가 6이 되었다면
				 }else if(lottoNum.size() == 6) {
				 //반복문 탈출
				   break;
				 }
				 
				/*
				 * while(lottoNum.size() != 6) { int ranNum = ran.nextInt(1, 46);
				 * lottoNum.add(ranNum); }
				 */
				}
			List<Integer> lotto2 = new ArrayList<>(lottoNum);
			lotto2.sort(null);
			System.out.println(lotto2);
			}
	}
}