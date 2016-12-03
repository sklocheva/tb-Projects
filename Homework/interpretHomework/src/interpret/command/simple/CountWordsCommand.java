package interpret.command.simple;

import interpret.main.Command;
import interpret.main.Constants;

/**
 * CountWordsCommand class takes a text and counts the words in it.
 * 
 * @author Sophia
 *
 */
public class CountWordsCommand implements Command {

	private static final String COMMAND_NAME = "count-words";

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * The method takes a String text, splits it while ignoring punctuation and
	 * returns the number of the words in the array.
	 * 
	 * @return String: number of words
	 */
	@Override
	public String execute(String text) {
		return String.valueOf(text.split(Constants.Formattings.WHITE_SPACE_SPLIT).length);
	}

}
