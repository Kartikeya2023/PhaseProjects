package project;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileManager implements CRUDinterface {
	private String directoryName;
	
	public FileManager() {
		this.directoryName = "./Files";
	}

	@Override
	public void retrieveFileNames() {
		List<String> fileNames = getFiles();
		if(fileNames.isEmpty()) {
			System.out.println("No files in the locker.");
		}
		else {
			System.out.println("File names in ascending order: ");
			for(String s : fileNames)
				System.out.println(s);
		}
	}

	@Override
	public void addFile(Scanner scanner) {
		System.out.println("Enter the file name: ");
		String name = scanner.nextLine();
		File file = new File(directoryName +File.separator +name);
		try {
			boolean flag = file.createNewFile();
			if(flag) {
				System.out.println("File created successfully.");
			}
			else {
				System.out.println("File already exists.");
			}
		} catch (Exception e) {
			System.out.println("Error Occurred during file creation.");
		}
		System.out.println("File " +name+ " added !");
	}

	@Override
	public void deleteFile(Scanner scanner) {
		System.out.println("Enter the file to be deleted: ");
		String name = scanner.nextLine();
		File file = new File(directoryName +File.separator +name);
		try {
			boolean flag = file.delete();
			if(flag) {
				System.out.println("File deleted successfully.");
			}
			else {
				System.out.println("File does not exists.");
			}
		} catch (Exception e) {
			System.out.println("Error Occurred during file deletion.");
		}
		System.out.println("File " +name+ " deleted !");
	}

	@Override
	public void searchFile(Scanner scanner) {
		System.out.println("Enter the file name to be searched: ");
		String name = scanner.nextLine();
		
		List<String> files = getFiles();
		if(files.contains(name)) {
			System.out.println("File " +name+ "found in the locker.");
		}
		else {
			System.out.println("File " +name+ "not found in the locker");
		}
	}
	
	private List<String> getFiles() {
		List<String> file = new ArrayList<>();
		Collections.sort(file);
		return file;
	}

}
