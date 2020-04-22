package pro;

public class proUsers {
	private static int totalProUsers;

	public static void newProUser() {
		totalProUsers++;
	}
	public int getProUsers() {
		return totalProUsers;
	}
	
}
