package command.print;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import main.Constants.Const;

/**
 * The 'PrintAll' class is used to print the whole information in the file with
 * the history of the created vehicles.
 * 
 * @author Sophia
 *
 */
public class PrintAll {
	BufferedReader reader;
	String currentLine;
	StringBuffer formatted = new StringBuffer();

	/**
	 * The method 'printAll' takes the name of the file that has the history
	 * file of created vehicles and prints them out formatted.
	 * 
	 * @param fileToSearchFrom
	 *            : the history file of created vehicles
	 * @return : a String containing all vehicles in the file
	 * @throws IOException
	 */
	public String printAll(String fileToSearchFrom) throws IOException {

		FormatPrint formatPrint = new FormatPrint();
		File inputFile = new File(fileToSearchFrom);
		reader = new BufferedReader(new FileReader(inputFile));
		formatted.append(String.format(Const.COLUMN_OUTPUT_FORMATTING, Const.COLUMN_NAME_VIN, Const.COLUMN_NAME_MODEL,
				Const.COLUMN_NAME_TYPE, Const.COLUMN_NAME_ENGINE, Const.COLUMN_NAME_TRANSMISSION,
				Const.COLUMN_NAME_DISASSEMBLED));
		while ((currentLine = reader.readLine()) != null) {
			formatted.append(formatPrint.formatInput(currentLine));
		}
		return formatted.toString();
	}

}
