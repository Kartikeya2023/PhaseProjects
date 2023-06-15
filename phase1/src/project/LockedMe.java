package project;
//Main Class
public class LockedMe {
	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
		DisplayMenus displayMenus = new DisplayMenus();
		displayMenus.welcome();
		mainMenu.begin();
		displayMenus.exiting();
	}
}
