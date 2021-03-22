package jdbc_basics.domain;

public class Species {
	private Long id;
	private String name;
	private int numAcres;

	public Species() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumAcres() {
		return numAcres;
	}

	public void setNumAcres(int numAcres) {
		this.numAcres = numAcres;
	}

}
