package main.factory;

import command.Command;
import command.SupportedCommands.SupCommands;

/**
 * The class 'Factory' has a country code and a factory number in that country.
 * The class can generate a vin number by these code and number, and interpret
 * commands.
 * 
 * @author Sophia
 *
 */
public class Factory {
	static VINGenerator vin;

	private static String countryCode = "BG";
	private static int factoryNumber = 1;

	/**
	 * The method generates a unique VIN with the information of the current
	 * factory.
	 * 
	 * @return : unique VIN number
	 */
	public static String getNextVINNumber() {
		vin = new VINGenerator();
		return vin.generateVIN(countryCode, factoryNumber);
	}
	
	public Factory(String countryCode, int factoryNumber){
		Factory.countryCode = countryCode;
		Factory.factoryNumber = factoryNumber;
	}

	/**
	 * The method 'goToFactory' splits the first argument (the command) from the
	 * rest of the text, interprets the command and executes it wit the rest of
	 * the arguments.
	 * 
	 * @param line
	 *            : a Sting that contains a command and parameters
	 * @return : outputs whether the execution has been successful
	 */
	public String goToFactory(String line) {
		if (factoryNumber >= 0 || factoryNumber < 10) {

			try {
				// get the first word - the command
				String command = line.substring(0, line.indexOf(" "));
				// get rest of the input
				String arguments = line.substring(line.indexOf(" ") + 1);

				Command cmd = SupCommands.COMMAND_MAP.get(command);
				if (cmd == null) {
					return "Unsupported operation";
				}
				return cmd.executeCommand(arguments);

			} catch (StringIndexOutOfBoundsException e) {
				return "No information inputed.";
			}
		} else {
			return "Factory number out of range!";
		}
	}
}
