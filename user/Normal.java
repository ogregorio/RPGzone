package user;

import room.Room;

public class Normal extends User{
	public Normal(String email, String password, String nickname, String type, boolean pro, int userID) {
		this.setEmail(email);
		this.setPassword(password);
		this.setNickname(nickname);
		this.setType(type);
		this.setPro(pro);
		this.setID(userID);
	}
	public void leaveRoom(long roomID) {
		System.out.println("User left this room...");
	}
	public void addUser(Room room, User user) {
	/*alerta ao usuário a incapacidade de se adicionar um usuário 
	se o mesmo nao for um administrador*/
		System.out.println("You don't have ADMIN POWER!");
	}
}
