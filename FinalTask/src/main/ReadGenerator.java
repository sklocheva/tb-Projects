package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

import main.Constants.Const;
import main.factory.Factory;

/**
 * The 'ReadGenerator' class is used to read line commands from a specific file.
 * 
 * @author Sophia
 *
 */
public class ReadGenerator implements Callable<String> {

	private String fileName;

	Scanner reader = null;
	Factory factory;
	private File inputFile;

	private String fileLine;
	private int lineCount = 0;

	StringBuffer results;
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
	public synchronized String call() throws IOException{

		factory = new Factory(this.countryCode, this.factoryNumber);

			inputFile = new File(this.fileName);
			reader = new Scanner(inputFile);
			results = new StringBuffer();
			while (reader.hasNextLine()) {
				lineCount++;
				fileLine = reader.nextLine().trim();
				// prints out the result from the command
//				System.out.printf(Const.FILE_STATUS_FORMATTING, factory.goToFactory(fileLine), lineCount, countryCode,
//						factoryNumber, this.fileName);
				
				results.append(String.format(Const.FILE_STATUS_FORMATTING, factory.goToFactory(fileLine), lineCount, countryCode,
						factoryNumber, this.fileName));
				
			}
			reader.close();
			return results.toString();
//			System.out.printf(Const.FINISHED_READING_FILE_FORMATTING, this.fileName);
//			return String.format(Const.FINISHED_READING_FILE_FORMATTING, this.fileName);

	}

}
