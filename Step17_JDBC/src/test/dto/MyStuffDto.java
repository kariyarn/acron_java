package test.dto;

public class MyStuffDto {
	private int num;
	private String name;
	private int stuffNum;
	private int price;
	private String usage;
	private String note;
	
	//디폴트 생성자
	public MyStuffDto() {}
	
	public MyStuffDto(int num, String name, int stuffNum, int price, String usage, String note) {
		super();
		this.num=num;
		this.name=name;
		this.stuffNum=stuffNum;
		this.price=price;
		this.usage=usage;
		this.note=note;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStuffNum() {
		return stuffNum;
	}

	public void setStuffNum(int stuffNum) {
		this.stuffNum = stuffNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
