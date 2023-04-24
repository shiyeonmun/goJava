package ch06.sec07.exam05;

public class Car {
	//필드선언(변수선언)
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	
	// 생성자 선언
	public Car(String model) {
		this(model,"은색", 250);
	}

	public Car(String model, String color) {
		this(model, color, 250);
	}

	public Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	
}
