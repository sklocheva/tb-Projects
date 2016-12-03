package interpret.command.simple;

import interpret.main.Command;

/**
 * ReverseStringCommand class takes a text and prints it out backwards.
 * 
 * @author Sophia
 *
 */
public class ReverseStringCommand implements Command {

	private static final String COMMAND_NAME = "reverse";

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * The method takes a text and returns it in reverse.
	 * 
	 * @return String: reversed text
	 */
	@Override
	public String execute(String text) {
		return new StringBuilder(text).reverse().toString();
	}

}
