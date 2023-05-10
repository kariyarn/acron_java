package test.mypac;

public class YuGiOh {

	public	String deckname;
	public int tier;
	public String mainTheme;
	public boolean noMom;

	public void info() {

		//if문을 쓰려면 대입연산자가 아니라 비교연산자 ==를 써야한다.
		if(noMom == true) {
			System.out.println("이 덱의 이름은 " + this.deckname + "이고, 티어는 " + this.tier + "입니다. 주된 테마는 " + this.mainTheme + "이고, 무척 강합니다." );
		}else{
			System.out.println("이 덱의 이름은 " + this.deckname + "이고, 티어는 " + this.tier + "입니다. 주된 테마는 " + this.mainTheme + "이며, 약합니다.");						
		}
	}
	public void versus(int car1, int car2, String name1, String name2) {

		if(car1<car2) {

			System.out.println(name1 + "의 승리입니다.");
		}else {
			System.out.println(name2 + "의 승리입니다.");
		}

	}

}
