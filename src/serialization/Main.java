package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Person person = new Person();
		person.setAge(25);
		person.setName("Wassif");
		person.setHeight(120);
		Person.country = "Morocco";

		serialize(person);
		Person dPerson = desirialize();
		System.out.println(dPerson.getAge());
		System.out.println(dPerson.getHeight());
		System.out.println(Person.country);
	}

	private static void serialize(Person person) throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream("resources/serialization.txt");
		try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(person);
			oos.flush();
		}
	}

	private static Person desirialize() throws ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("resources/serialization.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Person p = (Person) ois.readObject();
		ois.close();
		return p;
	}
}
