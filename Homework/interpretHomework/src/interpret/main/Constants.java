package interpret.main;

/**
 * The Constants class holds all of the constants of the project.
 * 
 * @author Sophia
 *
 */
public class Constants {
	
	/**
	 * Messages holds all of the messages and errors.
	 * 
	 * @author Sophia
	 *
	 */
	public static class Messages {

		public static final String OK_MESSAGE = "Ok";
		public static final String KEY_NOT_EXISTS = "Err: Key value not found!";
		public static final String WRONG_INPUT = "Err: Wrong Input!";
		public static final String NO_OPER = "Err: Unsupported operation!";
		public static final String VAL_NOT_PARSED = "Err: Value could not be formatted!";

		public static final String CONATAINS_YES = "The given string is part of the text.";
		public static final String CONATAINS_NO = "The given string is not part of the text.";

	}

	/**
	 * Types class holds all of the supported types of values in the Map.
	 * 
	 * @author Sophia
	 *
	 */
	public static class Types {

		public static final String TYPE_STRING = "string";
		public static final String TYPE_NUMBER = "number";
		public static final String TYPE_DATE = "date";
	}

	/**
	 * Formattings class stores the ways to format String.
	 * 
	 * @author Sophia
	 *
	 */
	public static class Formattings {

		public static final String COMPOUND_VALUE_OUTPUT = "[%1$s] %2$s";

		public static final String STANDARD_SPLIT = "\\s+";
		// splits in white space, keeping punctuation
		public static final String FULL_SPLIT = "\\s+|(?=\\p{Punct})|(?<=\\p{Punct})";
		// splits in white space and removes punctuation
		public static final String WHITE_SPACE_SPLIT = "[\\p{Punct}\\s]+";
		public static final String PUNCTUATION = "\\p{Punct}";
	}
}
