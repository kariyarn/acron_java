package test.main;

import test.mypac.YuGiOh;

public class YuGiOhTest {
	public static void main(String[] args) {
		YuGiOh card1 = new YuGiOh();
		card1.deckname = "티아라멘츠";
		card1.tier = 0;
		card1.mainTheme = "융합";
		card1.noMom = true;
		card1.info();
			
		YuGiOh card2 = new YuGiOh();
		card2.deckname = "후완다리즈";
		card2.tier = 2;
		card2.mainTheme = "락";
		card2.noMom = true;
		card2.info();
			
		YuGiOh card3 = new YuGiOh();
		card3.deckname = "잭나이츠";
		card3.tier = 5;
		card3.mainTheme = "Link";
		card3.noMom = false;
		card3.info();
			
		YuGiOh versus1 = new YuGiOh();
		versus1.versus(card3.tier, card2.tier, card3.deckname, card2.deckname);
		YuGiOh versus2 = new YuGiOh();
		versus2.versus(card1.tier, card2.tier, card1.deckname, card2.deckname);
			
	}
}
