package command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import command.print.FormatPrint;
import main.Constants.Const;

/**
 * The 'FindCommand' tries to find a the cars which have a specific euro
 * standard and print them out.
 * 
 * @author Sophia
 *
 */
public class FindCommand implements Command {

	private static final String COMMAND_NAME = "find";

	BufferedReader reader;
	StringBuffer formatted = new StringBuffer();

	String currentLine;
	int countFound = 0;
	String result;

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * The method reads the whole history file and tries to find the given
	 * argument in them. Once it has found these records it returns their
	 * information
	 */
	@Override
	public String executeCommand(String argument) {
		FormatPrint formatPrint = new FormatPrint();
		File inputFile = new File(Const.VEHICLE_HISTORY_FILE_NAME);
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			formatted.append(String.format(Const.COLUMN_OUTPUT_FORMATTING, Const.COLUMN_NAME_VIN,
					Const.COLUMN_NAME_MODEL, Const.COLUMN_NAME_TYPE, Const.COLUMN_NAME_ENGINE,
					Const.COLUMN_NAME_TRANSMISSION, Const.COLUMN_NAME_DISASSEMBLED));

			while ((currentLine = reader.readLine()) != null) {
				if (currentLine.contains(argument)) {
					countFound++;
					formatted.append(formatPrint.formatInput(currentLine));
				}
			}
			result = formatted.toString();
			formatted.setLength(0);

			if (countFound == 0) {
				result = "";
				return Const.WORD_NOT_FOUND_MESSAGE;
			}

		} catch (IOException e) {
			e.printStackTrace();
			return Const.IO_ERROR_MESSAGE;
		}
		return result;
	}

}
