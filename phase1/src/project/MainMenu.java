package project;
//Show Menu Interface
import java.util.Scanner;

public class MainMenu {
	private FileManager fileManager = new FileManager();
	private DisplayMenus displayMenus = new DisplayMenus();
	
	public void begin() {
		Scanner scanner  = new Scanner(System.in);
		int choice=0;
		do {
			displayMenus.mainMenuView();
			//choice = scanner.nextInt();
			try {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
			switch (choice) {
			case 1:
            	fileManager.retrieveFileNames();
            	break;
			case 2:
                handleFileManagement(scanner);
                break;
			case 3:
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice!=3);
	}
	
	private void handleFileManagement(Scanner scanner) {
		int choice=0;
		do {
			displayMenus.fileManagementMenu();
			try {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
			switch (choice) {
				case 1:
					fileManager.addFile(scanner);
					break;
				case 2:
					fileManager.deleteFile(scanner);
					break;
				case 3:
					fileManager.searchFile(scanner);
					break;
				case 4:
					System.out.println("Returning to the main menu...");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 4);
	}
}
