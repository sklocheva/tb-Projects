package interpret.command.simple;

import java.util.regex.Pattern;

import interpret.main.Command;
import interpret.main.Constants;

/**
 * ReverseWordsCommand class takes a text and returns the words in reverse
 * 
 * @author Sophia
 *
 */
public class ReverseWordsCommand implements Command {

	private static final String COMMAND_NAME = "reverse-words";

	private StringBuilder outputText;
	private String[] words;

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * The method takes a text and splits it into words and punctuation. Then
	 * flips the wording by iterating from the back of the array and adds spaces
	 * after every word.
	 * 
	 * @return String flipped words
	 */
	@Override
	public String execute(String text) {

		outputText = new StringBuilder();
		words = text.split(Constants.Formattings.FULL_SPLIT);

		for (int i = words.length - 1; i >= 0; i--) {
			if (Pattern.matches(Constants.Formattings.PUNCTUATION, words[i])) {
				outputText.append(words[i]);
			} else {
				outputText.append(words[i]);
				outputText.append(" ");
			}
		}
		return outputText.toString().trim();
	}

}
