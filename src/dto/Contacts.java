package dto;

public class Contacts {
	private String name;
	private String lastname;
	private String phone;
	private String email;
	private String city;
	private int id;
	private int userId;

	public Contacts() {
	}

	public Contacts(String name) {
	}
	

	public Contacts(String name, String lastname, String phone, String email, String city) {
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.userId = userId;
	}

	public Contacts(int id,int userid, String name, String lastname, String email, String phone, String city) {
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.id = id;
		this.userId = userid;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String password) {
		this.phone = password;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Contacts [name=" + name + ", lastname=" + lastname + ", phone=" + phone + ", email=" + email + ", city="
				+ city + "]";
	}

}
