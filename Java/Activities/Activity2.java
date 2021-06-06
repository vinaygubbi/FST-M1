package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arrNumber = {10,20,10,30,10,-10};

		System.out.println("Output: "+value(arrNumber));
	}
		
		public static boolean value(int[] numbers) {
			int sum = 0;
			for (int number : numbers) {
				if (number == 10) {
					sum += 10;
				}
				
				if (sum > 30) {
					break;
				}
			}
			return sum == 30;
		}

}
