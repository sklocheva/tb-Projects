package command;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import command.create.CreateCommand;
import command.print.PrintCommand;

public class SupportedCommands {

	public static class SupCommands {

		private static final Collection<Command> COMMANDS = Arrays.asList(new Command[] { 
				new CreateCommand(),
				new DisassembleCommand(),
				new PrintCommand(),
				new FindCommand(),
				new UpdateCommand()
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
