package activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> myList = new ArrayList<String>();
		
		myList.add("Nmae1");
		myList.add("Name2");
		myList.add("Name3");
		myList.add("Name4");
		myList.add("Name5");
		
		System.out.println("LIst of all Names: ");
		for (String s:myList) {
			System.out.println(s);
		}
		
		System.out.println("3rd Name is: "+myList.get(2));
		System.out.println("Is Name4 exists in the list: "+myList.contains("Name4"));
		System.out.println("Size of the name list: "+myList.size());
		
		myList.remove(4);
		
		System.out.println("Size of the name list: "+myList.size());
	}

}
