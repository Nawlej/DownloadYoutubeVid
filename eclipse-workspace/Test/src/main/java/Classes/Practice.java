package Classes;

public class Practice {

	public void switchMethod(int number) {
		switch (number) {
		case 1:
			System.out.println("Input is " + number);
			break;
		
		case 2:
			System.out.println("Input is " + number);
			break;
			
		case 3:
			System.out.println("Input is " + number);
			break;
			
		default:
			System.out.println("Input is outside of scope.");
			break;
		}
	}
	
	public void forLoopMethod() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Takes one step");
		}
	}
	
	public void whileMethod(int loops) {
		while(loops > 0) {
			System.out.println(loops + " steps left. Takes one step.");
			loops--;
		}
	}
}