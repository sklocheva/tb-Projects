package interpret.main;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

import interpret.calculate.CalcCommand;
import interpret.calculate.Calculate;
import interpret.calculate.addition.AddDaysToDate;
import interpret.calculate.addition.AddToNumber;
import interpret.calculate.addition.AddToString;
import interpret.calculate.multiplication.MultiplyNumber;
import interpret.calculate.multiplication.MultiplyString;
import interpret.calculate.subtraction.SubtractDaysFromDate;
import interpret.calculate.subtraction.SubtractFromNumber;
import interpret.command.access.CompoundValue;
import interpret.command.access.GetCommand;
import interpret.command.access.SetCommand;
import interpret.command.simple.CountWordsCommand;
import interpret.command.simple.ReverseStringCommand;
import interpret.command.simple.ReverseWordsCommand;
/**
 * SupportedCommands class holds all of the supported commands and operations that 
 * can be used in the program.
 * 
 * @author Sophia
 *
 */
public class SupportedCommands {

	public static class Calc {
		
//		public static final List<String> OPER = Arrays.asList("[date]+[number]", "[date]-[number]!", 
//				"[number]+[number]", "[number]-[number]", "[number]*[number]", 
//				"[string]+[string]","[string]+[number]","[string]*[number]");

		private static final Collection<Calculate> CALCULATE = Arrays.asList(new Calculate[] {

				new AddToString(), 
				new MultiplyString(), 
				new AddToNumber(), 
				new SubtractFromNumber(),
				new MultiplyNumber(), 
				new AddDaysToDate(), 
				new SubtractDaysFromDate()
		});

		@SuppressWarnings("serial")
		public static final Map<String, Calculate> CALCULATE_MAP = new HashMap<String, Calculate>() {
			{
				for (Calculate calc : CALCULATE) {
					put(calc.getOperatorType(), calc);

				}
			}
		};
	}

	public static class Com {
		private static final Map<String, CompoundValue> varmap = new HashMap<>();

		private static final Collection<Command> COMMANDS = Arrays.asList(new Command[] {

				new ReverseStringCommand(), 
				new CountWordsCommand(), 
				new ReverseWordsCommand(), 
				new SetCommand(varmap),
				new GetCommand(varmap), 
				new CalcCommand(varmap) 
		});

		@SuppressWarnings("serial")
		public static final Map<String, Command> COMMAND_MAP = new HashMap<String, Command>() {
			{
				for (Command command : COMMANDS) {
					put(command.getCommandName(), command);
				}
			}
		};
	}

}
