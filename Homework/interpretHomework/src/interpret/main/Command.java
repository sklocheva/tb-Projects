package interpret.main;

/**
 * Command interface is used in all command classes.
 * 
 * @author Sophia
 *
 */
public interface Command {
	/**
	 * The getCommandName method returns its command with which it can be
	 * recognized.
	 * 
	 * @return COMMAND_NAME
	 */
	String getCommandName();

	/**
	 * The execute method executes the command using the given arguments and
	 * returns the result.
	 * 
	 * @param cmdargs
	 * @return String : the result from the execution
	 */
	String execute(String cmdargs);
}
