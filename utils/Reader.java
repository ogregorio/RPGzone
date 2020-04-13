package utils;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Reader {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static int readNumber(String titleField) {
		System.out.print("Enter a valid entry to " + titleField + " : ");
		int n = scanner.nextInt();
		scanner.nextLine();
		return n;
	}
	public static String readString(String titleField) {
		System.out.print("Enter a valid entry to " + titleField + " : ");
		return scanner.nextLine();
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
