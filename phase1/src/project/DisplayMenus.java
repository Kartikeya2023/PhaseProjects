package project;

public class DisplayMenus {
	
	public void welcome() {
		System.out.print("Loading:");
		for(int i=0;i<=15;i++) {
			System.out.print("#");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print("Error occured while loading.");
			}
		}
		System.out.println("\nData Loaded Successfully!");
		System.out.println("\n        Welcome !");
	}	
	
	public void mainMenuView() {
		System.out.println("\n----- LockedMe.com -----");
	    System.out.println("1. Retrieve file names");
	    System.out.println("2. File Management Menu");
	    System.out.println("3. Close the application");
	    System.out.println();
	    System.out.print("Enter your choice: ");
	}
	
	public void fileManagementMenu() {
		System.out.println();
		System.out.println("----- File Management -----");
        System.out.println("1. Add a file");
        System.out.println("2. Delete a file");
        System.out.println("3. Search for a file");
        System.out.println("4. Return to the main menu");
        System.out.println();
        System.out.print("Enter your choice: ");
	}
	
	public void exiting() {
		System.out.println("\n\n");
		System.out.println("Thank you for using the application!");
		System.out.println("            Goodbye!");
	}
}

