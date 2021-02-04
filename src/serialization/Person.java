package serialization;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	static String country = "ITALY"; //Not serialized
	private int age;
	private String name;
	transient int height; //Not serialized

	public static String getCountry() {
		return country;
	}

	public static void setCountry(String country) {
		Person.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
