package activities;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car skoda = new Car();
		skoda.make = 2014;
		skoda.color = "Black";
		skoda.transmission = "Manual";
		
		skoda.displayCharacteristics();
		skoda.accelerate();
		skoda.brake();

	}

}
