package main;

/**
 * The Constants class holds all of the constants of the project.
 * 
 * @author Sophia
 *
 */
public class Constants {
	public static class Const {

		public static final String PRINT_COMMAND_ALL = "all";
		public static final String CHECK_NULL_RECORDED = "null";

		public static final String AUTO_TRANSMISSION = "Auto";
		public static final String MANUAL_TRANSMISSION = "Manual";

		public static final String DIESEL_ENGINE = "D";
		public static final String PETROL_ENGINE = "P";
		public static final String ELECTRIC_ENGINE = "E";

		public static final String CAR_LABEL = "car";
		public static final String SUV_LABEL = "suv";
		public static final String EURO_LABEL = "euro";
		public static final String HP_LABEL = "hp";
		public static final String LITERS_LABEL = "L";
		public static final String TURBO_LABEL = "T";

		public static final String HAS_TURBO_MULTIPLIER = "1.3";
		public static final String NO_TURBO_MULTIPLIER = "1";

		public static final String DEFAULT_EURO_STANDARD = "euro3";
		public static final String DEFAULT_TRANSMISSION_TYPE = "Manual";
		public static final String DEFAULT_TRANSMISSION_GEARS = "4";
		public static final String DEFAULT_EL_ENGINE_POWER = "535";
		public static final String DEFAULT_ISDISASS_INPUT = "false";
		public static final String DISASSEMBLE_TRUE = "true";

		public static final String DASH_SEPARATOR = "-";
		public static final String EQUALS_SEPARATOR = "=";
		public static final String SPACE_SEPARATOR = "\\s+";

		public static final String SUCCESS_ASSEMBLE_MESSAGE = "Car assembled.";
		public static final String SUCCESS_DISASSEMBLE_MESSAGE = "Car disassembled.";
		public static final String SUCCESS_UPDATE_MESSAGE = "Car updated.";
		public static final String ERROR_OUTPUT_MESSAGE = "Invalid parameters!";
		public static final String IO_ERROR_MESSAGE = "Error occured - file might not exist.";
		public static final String WORD_NOT_FOUND_MESSAGE = "Nothing found!";
		public static final String VIN_NOT_FOUND_MESSAGE = "Vin is not found!";
		public static final String DISASSEMBLED_ALREADY = "Already disassembled!";

		public static final String VEHICLE_HISTORY_FILE_NAME = "ProductHistory.txt";

		public static final String INPUT_FORMATTING = "%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s%n";
		public static final String COLUMN_OUTPUT_FORMATTING = "%-17s | %-5s | %-10s | %-16s | %-7s | %-10s%n";
		public static final String OUTPUT_FORMATTING = "%-15s | %-5s | %-10s | %s-%shp%s-%s  | %s-%-7s | %-10s%n";
		public static final String FILE_STATUS_FORMATTING = "%s - %d.line factory %s {%d} file %s.%n";
		public static final String FINISHED_READING_FILE_FORMATTING = "File %s finished reading.%n";

		public static final String COLUMN_NAME_VIN = "vin";
		public static final String COLUMN_NAME_MODEL = "model";
		public static final String COLUMN_NAME_TYPE = "type";
		public static final String COLUMN_NAME_ENGINE = "engine";
		public static final String COLUMN_NAME_TRANSMISSION = "transmission";
		public static final String COLUMN_NAME_DISASSEMBLED = "isDisas";

	}

}
