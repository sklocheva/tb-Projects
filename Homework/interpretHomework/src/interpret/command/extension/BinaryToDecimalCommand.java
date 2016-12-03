package interpret.command.extension;

import interpret.main.Command;
import interpret.main.Constants.Messages;

/**
 * BinaryToDecimalCommand class takes a binary value in String and returns its
 * decimal result.
 * 
 * @author Sophia
 *
 */
public class BinaryToDecimalCommand implements Command {

	private static final String COMMAND_NAME = "bin2dec";
	private int result;

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * The method takes a binary value in String format, parses it to decimal and
	 * returns the result of that calculation.
	 */
	@Override
	public String execute(String cmdargs) {
		
		try {
			result = Integer.parseInt(cmdargs, 2);
			
		} catch (NumberFormatException e) {
			return Messages.VAL_NOT_PARSED;
		}
		return String.valueOf(result);
	}

}
