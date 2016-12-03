package interpret.calculate;

import java.util.Map;

import interpret.command.access.CompoundValue;
import interpret.command.access.GetCommand;
import interpret.command.access.SetCommand;
import interpret.main.Command;
import interpret.main.Constants.Formattings;
import interpret.main.Constants.Messages;
//import interpret.main.SupportedCommands;
import interpret.main.SupportedCommands.Calc;

/**
 * <br>
 * The CalcCommand class is used to make simple calculations with already saved
 * values from a map. It takes the key to which you want to save the result to
 * and the operation itself.</br>
 * <br>
 * <b>syntax:</b><i> key1 key1 operation key2</i></br>
 * 
 * <pre>
 * The supported operations are: <br>
 * <b>string</b>
 * + [string], [number]
 * * [number]<br>
 * <b>number</b>
 * + [number]
 * - [number]
 * * [number]<br>
 * <b> date </b>
 * + [number]
 * - [number]
 * </pre>
 * 
 * @author Sophia
 * 
 */

public class CalcCommand implements Command {

	private static final String COMMAND_NAME = "calc";

	private GetCommand get;
	private SetCommand set;
	private Calculate oper;

	private String[] input;
	private String[] valuesFirst;
	private String[] valuesSecond;
	
	private String resultFromCalculation;

	public CalcCommand(Map<String, CompoundValue> varmap) {
		get = new GetCommand(varmap);
		set = new SetCommand(varmap);
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * The method takes the key for a calculation as String and them splits them
	 * and takes the corresponding values from the map. Check if the operation
	 * plus the type of the values of the first key is from the supported
	 * operations (see CalcCommand class) and starts the calculation. The result
	 * is stored in the value of the specified key.
	 * 
	 * @return Message Ok/Err
	 * @see CalcCommand CalcCommand: for supported operations
	 */
	@Override
	public String execute(String cmdargs) {

		input = cmdargs.split(Formattings.STANDARD_SPLIT);
		// gets the type and value from the first key
		valuesFirst = (get.execute(input[1])).split(Formattings.STANDARD_SPLIT);
		// gets the type and value from the second key
		valuesSecond = (get.execute(input[3])).split(Formattings.STANDARD_SPLIT);

		// checks if the operation with the specific types matches the supported
		// operations
		// if(!(SupportedCommands.Calc.OPER.contains(valuesFirst[0] + input[2] +
		// valuesSecond[0]))){
		// return Messages.NO_OPER;
		// }

		// tries to find the operation for this type, if operation is
		// [string]+[number] reuses [string]+[string]
		if ((valuesFirst[0].equals("[string]") && valuesSecond[0].equals("[number]")) && input[2].equals("+")) {
			oper = Calc.CALCULATE_MAP.get(valuesFirst[0] + input[2] + "[string]");
		} else {
			oper = Calc.CALCULATE_MAP.get(valuesFirst[0] + input[2] + valuesSecond[0]);
		}

		// checks if the operation has been found
		if (oper == null) {
			return Messages.NO_OPER;
		}
		// calculate the two values
		resultFromCalculation = oper.calc(valuesFirst[1], valuesSecond[1]);
		// set the new value to the map
		set.execute(input[0] + " " + valuesFirst[0].replaceAll("\\[|\\]", "") + " " + resultFromCalculation);
		return Messages.OK_MESSAGE;
	}
}
