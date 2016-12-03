package interpret.main;

import java.util.NoSuchElementException;

import interpret.main.SupportedCommands.Com;

/**
 * CmdInterpreter class is used to read the commands inputs from console.
 * 
 * @author Sophia
 *
 */
public class CmdInterpreter {

	public String processLine(String line) {
		try {
			// get the first word
			String command = line.substring(0, line.indexOf(" "));
			// get rest of the input
			String cmdargs = line.substring(line.indexOf(" ") + 1);

			Command cmd = Com.COMMAND_MAP.get(command);
			if (cmd == null) {
				// System.out.println();
				return Constants.Messages.NO_OPER;
			}
			String result = cmd.execute(cmdargs);
			return result;
		} catch (NoSuchElementException e) {
			return Constants.Messages.VAL_NOT_PARSED;
		} finally {
			// linescan.close();
		}
	}
}
