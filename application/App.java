package application;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import user.User;
import utils.Reader;
import room.Room;

public class App {
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<Room> rooms = new ArrayList<Room>();
	private static User userLogged;
	
	public static void showOutput(String output) {//method to show the output
		JTextArea textArea = new JTextArea(40, 70);
	    textArea.setText(output + "\n");
	    textArea.setEditable(false);
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    JOptionPane.showMessageDialog(null, scrollPane, "Output", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void main(String [] args) {
		int op = 0;
		String output = "";
		do {
			String response = JOptionPane.showInputDialog("============= Menu =============\n" + 
										"1 => User sign up\n"+
										"2 => User sign in\n"+
										"3 => User create new room\n"+
										"4 => Add user in room\n"+
										"5 => Show list of rooms\n"+
										"6 => Show list of users\n"+
										"7 => Show user logged\n"+
										"8 => Exit menu\n"+
										"Enter with a option => ");
			try {
				op = Integer.parseInt(response);
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			switch(op) {
				case 1:
					users.add(Register.newUser());//add new user in db of app
					break;
				case 2:
					Object userReturn = Login.toDoLogin(users, Reader.readString("email"), Reader.readString("password"));//verifying credentials
					if(userReturn != null) {
						JOptionPane.showMessageDialog(null, "Logged on success", "Success", JOptionPane.INFORMATION_MESSAGE);
						userLogged = (User) userReturn;//setting this user on user logged
					}
					else
						JOptionPane.showMessageDialog(null, "user does not registered", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case 3:
					if(userLogged != null) {
						rooms.add(userLogged.createRoom());//add new room in db of app
					}
					else 
						JOptionPane.showMessageDialog(null, "You have to log in first", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case 4:
					if(userLogged != null) {
						if(rooms.size() > 0) {
							Room room = rooms.get(Reader.readIndex(rooms.size()));//get of user which room he  want add user
							Object stateResponse = room.returnUserStateInRoom(userLogged);//verify which user it is logged right now and return his state in room
							if(stateResponse != null)//to know if user is present this room
								( (User) stateResponse ).addUser(room, users.get(Reader.readIndex(users.size() ) ) );
						}
					}
					else
						JOptionPane.showMessageDialog(null, "You have to log in first", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case 5:
					output = "";
					for(Iterator<Room> iterator = rooms.iterator(); iterator.hasNext();) {
						output += iterator.next() + "\n\n";//showing all rooms
					}
					showOutput(output);
					break;
				case 6:
					output = "";
					for(Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
						output += iterator.next() + "\n\n";//showing all users
					}
					showOutput(output);
					break;
				case 7:
					if(userLogged != null) {
						output = userLogged + "\nEnd\n";
						showOutput(output);//showing user logged
					}
					break;
				case 8:
					JOptionPane.showMessageDialog(null, "Exiting...", "Bye", JOptionPane.WARNING_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid option...", "Warning", JOptionPane.WARNING_MESSAGE);
					break;
			}
			
			
		}while(op != 8);
	}
}
