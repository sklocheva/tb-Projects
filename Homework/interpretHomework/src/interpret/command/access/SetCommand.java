package interpret.command.access;

import java.util.Map;

import interpret.main.Command;
import interpret.main.Constants;
import interpret.validation.CheckFormatInput;

/**
 * The SetCommand class stores a value and its type to a given key.
 * 
 * @author Sophia
 *
 */
public class SetCommand implements Command {

	private static final String COMMAND_NAME = "set";
	
	private Map<String, CompoundValue> varmap;
	private CheckFormatInput checkFormat;
	private CompoundValue compVal;
	
	private String[] inputArr;

	public SetCommand(Map<String, CompoundValue> varmap) {
		this.varmap = varmap;
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * <br>
	 * The method takes an input of the type: key type value.</br>
	 * <br>
	 * Two Type and Value are stored into CompoundValue and them put into a Map
	 * to the given Key.</br>
	 * 
	 * @param input
	 *            expected input type 'key type value'
	 * @return Ok - if the input is correct
	 * @return Wrong Input message - if it failed to store the values
	 */
	@Override
	public String execute(String input) {

		checkFormat = new CheckFormatInput();
		inputArr = input.split(Constants.Formattings.STANDARD_SPLIT);

		// validates the input
		if (checkFormat.validateInput(inputArr)) {
			//put type and value together into CompoundValue
			compVal = new CompoundValue(inputArr[1].toLowerCase(), inputArr[2]);
			//put the key and the compVal into the map
			varmap.put(inputArr[0].toLowerCase(), compVal);
			return Constants.Messages.OK_MESSAGE;
		} else {
			return Constants.Messages.WRONG_INPUT;
		}
	}
}
