package main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import main.Constants.Const;
import main.factory.Factory;

/**
 * The 'ReadGenerator' class is used to read line commands from a specific file.
 * 
 * @author Sophia
 *
 */
public class ReadGenerator implements Runnable {

	private String fileName;

	Scanner reader = null;
	Factory factory;
	private File inputFile;

	private String fileLine;
	private int lineCount = 0;

	String countryCode;
	int factoryNumber;

	public ReadGenerator(String fileName, String countryCode, int factoryNumber) {
		this.fileName = fileName;
		this.countryCode = countryCode;
		this.factoryNumber = factoryNumber;

	}

	/**
	 * The method takes the name of the file and starts reading from in line by
	 * line. It sends each one to the Factory to be executed and returns the
	 * execution output of the command.
	 */
	@Override
	public void run() {

		factory = new Factory(this.countryCode, this.factoryNumber);

		try {
			inputFile = new File(this.fileName);
			reader = new Scanner(inputFile);
			while (reader.hasNextLine()) {
				lineCount++;
				fileLine = reader.nextLine().trim();
				// prints out the result from the command
				System.out.printf(Const.FILE_STATUS_FORMATTING, factory.goToFactory(fileLine), lineCount, countryCode,
						factoryNumber, this.fileName);
			}
			reader.close();
			System.out.printf(Const.FINISHED_READING_FILE_FORMATTING, this.fileName);

		} catch (IOException e) {
			System.out.println(Const.IO_ERROR_MESSAGE);
		}
	}

}
