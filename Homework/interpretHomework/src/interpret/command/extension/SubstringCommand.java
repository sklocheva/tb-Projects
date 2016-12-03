package interpret.command.extension;

import interpret.main.Command;
import interpret.main.Constants;
import interpret.main.Constants.Messages;

/**
 * SubstringCommand class takes two string vlues and checks if the second one is
 * part of the first.
 * 
 * @author Sophia
 *
 */
public class SubstringCommand implements Command {

	private static final String COMMAND_NAME = "substring";
	private String[] arg;

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * The method checks if the second string is part of the first and returns
	 * the result.
	 * 
	 * @return Message String
	 */
	@Override
	public String execute(String cmdargs) {

		arg = cmdargs.split(Constants.Formattings.FULL_SPLIT);

		if (arg[0].contains(arg[1])) {
			return Messages.CONATAINS_YES;
		} else {
			return Messages.CONATAINS_NO;
		}
	}

}
