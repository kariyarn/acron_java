package test.mypac;

public class Calcul {
	public int width;
	public int height;
	
	public void cal() {		
		int result = width * height;
		System.out.println(result);
	}
	
	public int cal2() {
		int result = width * height;
		return result;
	}
}
