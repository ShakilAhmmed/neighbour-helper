package project;

public class User {

	private int id;
	private String name;
	private String emailAddress;
	private String streetAddress;

	public User(int id, String name, String emailAddress, String streetAddress) {
		this.id = id;
		this.name = name;
		this.emailAddress = emailAddress;
		this.streetAddress = streetAddress;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User Id : " + this.id + " User Name : " + this.name + " User Email : " + this.emailAddress
				+ " User Street : " + this.streetAddress;
	}

}
