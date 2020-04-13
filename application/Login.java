package application;
import user.User;
import java.util.ArrayList;
import java.util.Iterator;

public class Login {
	
	public static Object toDoLogin(ArrayList<User> userList, String email, String password) {
		Object response = null;
		for(Iterator<User> iterator = userList.iterator(); response == null && iterator.hasNext();) {
			User systemUser = (User) iterator.next();
			if(systemUser.getEmail().equals(email) && systemUser.getPassword().equals(password)) {
				response = systemUser;
			}
		}
		return response;
	}
	public void matchDates() {
		
	}
}
