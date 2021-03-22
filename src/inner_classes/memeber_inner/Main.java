package inner_classes.memeber_inner;

class A {
	private String dummy = "default";
	private static String staticdummy = "static";

	public class B {
		private String yummy;

		public B(String value) {
			this.yummy = value;
		}

		public void parla() {
			System.out.println(dummy + " | " + yummy + " | " + staticdummy);
		}
	}
}

public class Main {

	public static void main(String[] args) {
		A.B b = new A().new B("yummy");
		b.parla();
	}
	
}
