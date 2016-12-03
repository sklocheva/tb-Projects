package interpret.command.extension;

import interpret.main.Command;

/**
 * CapitalizeCommand class takes a string and returns it in capitals.
 * 
 * @author Sophia
 *
 */
public class CapitalizeCommand implements Command {

	private static final String COMMAND_NAME = "capitalize";

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * The following method takes the string input and returns in capitalized.
	 */
	@Override
	public String execute(String cmdargs) {
		return cmdargs.toUpperCase();
	}

}
