package enums;

public enum Planet {
	MERCURY("") {
		@Override
		String tellSomething() {
			return "nothing to say";
		}
	},
	VENUS("") {
		@Override
		String tellSomething() {
			return "rien à dire";
		}
	},
	EARTH("blue") {
		@Override
		String tellSomething() {
			return "nada que decir";
		}
	},
	MARS("red") {
		@Override
		String tellSomething() {
			return "يقال شيء لا";
		}
	};

	private String color;

	private Planet(String color) {
		this.color = color; //only constructed once
	}

	public String printColor() {
		return this.color;
	}

	abstract String tellSomething();
}
