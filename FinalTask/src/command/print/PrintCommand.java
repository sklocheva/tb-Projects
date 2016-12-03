package command.print;

import java.io.IOException;

import command.Command;
import main.Constants.Const;

/**
 * The 'PrintCommand' prints information about vehicles.
 * 
 * @author Sophia
 *
 */
public class PrintCommand implements Command {

	private static final String COMMAND_NAME = "print";

	PrintAll printAll;
	PrintVin printVin;
	String formatted;

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * The method takes an argument - either the word 'all' or a specific vin
	 * number of a vehicle, and print out the information of the searched
	 * records.
	 * 
	 * @return : a String containing information about the vehicle(s).
	 */
	@Override
	public String executeCommand(String argument) {
		printAll = new PrintAll();
		printVin = new PrintVin();
		try {
			if (argument.equals(Const.PRINT_COMMAND_ALL)) {
				return printAll.printAll(Const.VEHICLE_HISTORY_FILE_NAME);
			} else {
				return printVin.print(Const.VEHICLE_HISTORY_FILE_NAME, argument);
			}

		} catch (IOException e) {
			e.printStackTrace();
			return Const.IO_ERROR_MESSAGE;
		}
	}

}
