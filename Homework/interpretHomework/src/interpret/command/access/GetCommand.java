package interpret.command.access;

import java.util.Map;

import interpret.main.Command;
import interpret.main.Constants.Messages;

/**
 * The GetCommand class takes a key from a map and returns the type and the
 * value of that key.
 * 
 * @author Sophia
 *
 */
public class GetCommand implements Command {

	private static final String COMMAND_NAME = "get";
	private Map<String, CompoundValue> varmap;
	
	String keyToLower;

	public GetCommand(Map<String, CompoundValue> varmap) {
		this.varmap = varmap;
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * This method takes a key, tries to find its corresponding value and
	 * value's type and returns them in a specific format. In case values is not
	 * found - returns a Wrong input message.
	 * 
	 * @return String '[type] value'
	 */
	@Override
	public String execute(String key) {

		keyToLower = key.toLowerCase();

		if (varmap.get(keyToLower) != null) {
			return varmap.get(keyToLower).toString();
		} else {
			return Messages.WRONG_INPUT;
		}
	}
}
