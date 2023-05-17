package test.mypac;

public class Phone<T> {
	//필드
	private T item;
	
	public void boxing(T item) {
		this.item = item;
	}
	
	public T unboxing() {
		return item;
	}
		
	
}
