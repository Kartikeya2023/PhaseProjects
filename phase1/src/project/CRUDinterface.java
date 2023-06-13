package project;
import java.util.Scanner;

public interface CRUDinterface {
	void retrieveFileNames();
	void addFile(Scanner scanner);
	void deleteFile(Scanner scanner);
	void searchFile(Scanner scanner);
}
