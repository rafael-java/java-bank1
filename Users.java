package bank;

/*
 * Class responsible for the list of users, this time it uses an arrayList instead of an array
 */

import java.util.ArrayList;

public class Users {

	// declaration
	private ArrayList<User> users = new ArrayList<User>();

	// getters and setters
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	// function to add user and return the user created
	public User addUser (String nome) {
		User user = new User (nome);
		users.add(user);
		return users.get(users.indexOf(user));
	}
	
	// extra function, to list users using a 'for each'
	public void listUsers () {
		for (User u:users) {
			System.out.println(u.getName());}
		}
	
	// extra function, to find a user from its name and return that user
	public User findUser (String name) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getName().equals(name) ) {
				return users.get(i);
			}
	}
		return null;
	}
}
