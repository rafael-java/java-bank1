package bank;

/*
 * this class is responsible for declaring the User used in the Users class
 */

public class User {

	private String name;

	// constructors (to create a user)
	public User () {
	}
	
	public User(String name) {
		this.name = name;
	}

	// getters and setters 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
