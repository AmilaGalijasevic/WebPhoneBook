package dto;

public class User {
	private String name;
	private String lastname;
	private String password;
	private String email;
	private String city;
	private int id;
	public User() {
	}

	public User(String email, String password) {
		this.password = password;
		this.email = email;
	}

	public User(String name, String lastname, String password, String email, String city) {
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", lastname=" + lastname + ", password=" + password + ", email=" + email
				+ ", city=" + city + "]";
	}

}
