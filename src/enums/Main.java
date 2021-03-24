package enums;

public class Main {
	public static void main(String[] args) {
		Planet earth = Planet.valueOf("EARTH");
		Planet mars = Planet.MARS;
		
		printPlanets(earth, mars);
	}

	private static void printPlanets(Planet... planets) {
		printHeader();
		for(Planet planet : planets) {
			System.out.printf("%-20s | %-10s | %-40s %n",planet.name(),planet.printColor(), planet.tellSomething());
		}
		printLine();
	}

	private static void printLine() {
		System.out.println("-----------------------------------------------------------");
	}

	private static void printHeader() {
		System.out.printf("%-20s | %-10s | %-40s %n","Name","Color", "description");
		printLine();
	}
	
	
}
