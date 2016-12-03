package command.print;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import main.Constants.Const;

/**
 * The 'PrintVin' class is used to print out the parameters of e vehicle by its
 * vin number.
 * 
 * @author Sophia
 *
 */
public class PrintVin {

	BufferedReader reader;
	String currentLine;
	StringBuffer formatted = new StringBuffer();
	boolean notFound = true;

	/**
	 * 
	 * @param fileToSearchFrom
	 *            : the history file of created vehicles
	 * @param vin
	 *            : vin number of the searched vehicle
	 * @return : a String containing the information of the specific vehicle
	 * @throws IOException
	 */
	public String print(String fileToSearchFrom, String vin) throws IOException {

		FormatPrint formatPrint = new FormatPrint();
		File inputFile = new File(fileToSearchFrom);
		reader = new BufferedReader(new FileReader(inputFile));
		formatted.append(String.format(Const.COLUMN_OUTPUT_FORMATTING, Const.COLUMN_NAME_VIN, Const.COLUMN_NAME_MODEL,
				Const.COLUMN_NAME_TYPE, Const.COLUMN_NAME_ENGINE, Const.COLUMN_NAME_TRANSMISSION,
				Const.COLUMN_NAME_DISASSEMBLED));
		while ((currentLine = reader.readLine()) != null) {
			if (currentLine.contains(vin)) {
				notFound = false;
				formatted.append(formatPrint.formatInput(currentLine));
			}
		}
		if (notFound) {
			return Const.VIN_NOT_FOUND_MESSAGE;
		} else {
			return formatted.toString();
		}
	}

}
