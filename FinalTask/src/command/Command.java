package command;

public interface Command {

	/**
	 * The getCommandName method returns its command with which it can be
	 * recognized.
	 * 
	 * @return COMMAND_NAME
	 */
	String getCommandName();

	/**
	 * The execute method executes the command using the given parameters.
	 * 
	 * @param argument
	 * @return : whether the execution was successful or not
	 */
	String executeCommand(String argument);

}
