package command;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.Constants.Const;

/**
 * The 'DisassembleCommand' class is used to disassemble a car - to change its
 * status from assembled to disassembled.
 * 
 * @author Sophia
 *
 */
public class DisassembleCommand implements Command {

	private static final String COMMAND_NAME = "disassemble";

	private TempToFile swapFiles;
	
	private BufferedReader reader;
	private BufferedWriter writer;
	private File inputFile;
	private File tempFile;
	private String currentLine;
	private String lineToChange = null;

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * The method reads all records in the history file of the created cars and
	 * checks for the given VIN number. Each line in which the VIN is not found,
	 * it transfers to another temporary file. When this operation is finished
	 * the method changes the status of the car with that specific VIN to
	 * disassembled and also writes it to the temporary file. The temporary file
	 * becomes the new history file and the old one is deleted.
	 */

	@Override
	public String executeCommand(String argument) {
		
		swapFiles = new TempToFile();
		inputFile = new File(Const.VEHICLE_HISTORY_FILE_NAME);
		tempFile = new File(inputFile.getAbsolutePath() + ".tmp");

		try {
			reader = new BufferedReader(new FileReader(inputFile));
			writer = new BufferedWriter(new FileWriter(tempFile));

			while ((currentLine = reader.readLine()) != null) {
				if (currentLine.contains(argument.trim())) {
					if (currentLine.contains(Const.DEFAULT_ISDISASS_INPUT)) {
						lineToChange = currentLine.replaceAll(Const.DEFAULT_ISDISASS_INPUT, Const.DISASSEMBLE_TRUE);
					} else {
						writer.close();
						reader.close();
						return Const.DISASSEMBLED_ALREADY;
					}
				} else {
					writer.write(currentLine + System.getProperty("line.separator"));
					writer.flush();
				}
			}
			if (lineToChange != null) {
				writer.write(lineToChange + System.getProperty("line.separator"));
				writer.flush();
			} else {
				writer.close();
				reader.close();
				return Const.VIN_NOT_FOUND_MESSAGE;
			}
			writer.close();
			reader.close();
			swapFiles.swapFiles(inputFile, tempFile);

			return Const.SUCCESS_DISASSEMBLE_MESSAGE;
		} catch (IOException e) {
			e.printStackTrace();
			return Const.IO_ERROR_MESSAGE;
		}
	}

}
