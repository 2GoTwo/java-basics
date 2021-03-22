package inner_classes.local_inner;

import java.util.Random;

class A {
	
	static int ratio = 12;
	
	public  static void parla() {
		int width = 12; //effective final
		
		class B {
			public int calculate(int height) {
				return width * height * ratio;
			}
		}
		
		B b = new B();
		System.out.println(b.calculate(10));
	}
}

public class Main {

	public static void main(String[] args) {
		A.parla();
		
		Random animal = new Random();
		int othmane = animal.nextInt();
		
	}

}
