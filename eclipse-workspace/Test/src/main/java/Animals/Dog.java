package Animals;

import Classes.Animal;

public class Dog extends Animal{

	public void talk() {
		System.out.println("Woof");
	}
	
	public void eat(int amount) {
		System.out.println("Consumed "+ amount + " cans of dog  food");
	}
}
