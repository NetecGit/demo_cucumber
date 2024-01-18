package courses.apx.crudclients.dto;

public class ClientDTO {

	private long idClient;
	private String name;
	private String surname;

	public ClientDTO() {
	}

	public ClientDTO(long id, String name, String surname) {
		super();
		this.idClient = id;
		this.name = name;
		this.surname = surname;
	}



	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}