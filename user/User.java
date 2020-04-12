package user;

import room.Room;
import utils.Reader;

public abstract class User {//User is an abstract concept into app in which he have methods and attributes that are shared with his children and also have methods that are setted howspec comportament to your children
	private int userID;
	private String password;
	private String type;
	private String nickname;
	private String email;
	private boolean pro;
	private static final int MAX_ROOMS = 5;
	private Room [] rooms = new Room[MAX_ROOMS];
	private int countRooms = 0;
	private static int userCounting = 0;//this counter never be same, always to staying auto increment he never gonna be the same
	
	public static int generateUserID() {
		return userCounting++;//auto increment
	}
	
	public abstract void leaveRoom(long roomID);
	
	public abstract void addUser(Room room, User user);
	
	public void enterRoom(long roomID) {
		System.out.println("Enter to the room");
	}
	public Object fetchRoom(long roomID) {
		System.out.println("Finding room...");
		return null;
	}
	
	public Room createRoom() {
		User adm = new Admin(this.getEmail(), this.getPassword(), this.getNickname(), this.getType(), this.getPro(), this.getID());
		Room room = new Room(adm , Room.generateRoomID(), Reader.readString("room Nick"));
		room.addUser(adm);//adding one copy of user how admin in this room
		this.addRoom(room);//adding this new room in his list of room
		return room;//room that to going to be putted on db of app
		//System.out.println("Creating room...");
	}
	
	public int getID() {
		return userID;
	}
	public void setID(int iD) {
		userID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void getRoomId(Room room) {
		room.getID();
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getPro() {
		return pro;
	}
	public void setPro(Boolean pro) {
		this.pro = pro;
	}
	public Room [] getRooms() {
		return rooms;
	}
	public void addRoom(Room room) {
		if(this.countRooms < MAX_ROOMS)
			this.rooms[this.countRooms++] = room;
	}
	
	@Override
	public String toString() {//text form of this object
		String rooms = "";
		for(Room room : this.rooms) {
			if(room != null)
				rooms += room + "\n";
		}
			
		return "userID : " + this.userID + "\n" +
			   "password : " + this.password + "\n" +
			   "type : " + this.type + "\n"+
			   "nickname : " + this.nickname + "\n" +
			   "email : " + this.email + "\n"+
			   "pro ? " + this.pro + "\n" +
			   "Rooms of this user => \n"+
			   rooms;
			   
	}
}
