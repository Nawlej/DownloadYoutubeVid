package Classes;

import java.util.ArrayList;

public abstract class Animal {

	public void talk() {}
	public void eat(int amount) {
		System.out.println("Consumed "+ amount + " servings of food");
	}
	public void sleep(int amount) {
		System.out.println("Slept for " + amount + " hours");
		
		ArrayList<Integer> stuff = new ArrayList<Integer>();
	}
}