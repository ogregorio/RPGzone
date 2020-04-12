package utils;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Reader {
	private static final Scanner READER = new Scanner(System.in);
	
	public static int readNumber(String titleField) {
		System.out.print("Enter value to fill the field " + titleField + " : ");
		int n = READER.nextInt();
		READER.nextLine();
		return n;
	}
	public static String readString(String titleField) {
		System.out.print("Enter value to fill the field " + titleField + " : ");
		return READER.nextLine();
	}
	public static boolean readBoolean(String titleFiels){
		int response = JOptionPane.showConfirmDialog(null, "This user is " + titleFiels + " ? ");
		return (response == 0) ? true : false;
	}
	public static int readIndex(int max) {
		int n;
		do {
			n = readNumber("Index");
			if(n >= max)
				System.out.println("Error!!! invalid index");
		}while(n >= max);
		return n;
	}
}
