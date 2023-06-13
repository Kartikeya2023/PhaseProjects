package project;
//Show Menu Interface

import java.util.Scanner;

public class MainMenu {
	
	public void begin() {
		Scanner scanner  = new Scanner(System.in);
		FileManager fileManager = new FileManager();
		DisplayMenus displayMenus = new DisplayMenus();
		
		int choice;
		do {
			displayMenus.mainMenuView();
			choice = scanner.nextInt();
			scanner.nextLine();
			
            switch (choice) {
            case 1:
                fileManager.retrieveFileNames();
                break;
            case 2:
                fileManager.addFile(scanner);
                break;
            case 3:
                fileManager.deleteFile(scanner);
                break;
            case 4:
                fileManager.searchFile(scanner);
                break;
            case 5:
                System.out.println("Closing the application...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
            }
		} while (choice!=5);
	}
}
