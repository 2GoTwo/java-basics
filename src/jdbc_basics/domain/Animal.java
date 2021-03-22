package jdbc_basics.domain;

import java.time.LocalDate;

import jdbc_basics.core.Entity;

@Entity
public class Animal {
	private Long id;
	private Species species;
	private String name;
	private LocalDate dateBorn;

	public Animal() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("invoking setter");
		this.name = name;
	}

	public LocalDate getDateBorn() {
		return dateBorn;
	}

	public void setDateBorn(LocalDate dateBorn) {
		this.dateBorn = dateBorn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Animal [ id = ");
		builder.append(id);
		builder.append(", species = ");
		builder.append(species);
		builder.append(", name = ");
		builder.append(name);
		builder.append(", dateBorn = ");
		builder.append(dateBorn);
		builder.append(" ]");
		return builder.toString();
	}

}
