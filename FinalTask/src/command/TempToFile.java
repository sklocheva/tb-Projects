package command;

import java.io.File;

/**
 * The 'TempToFile' class is used to delete an old file and to assign that name
 * to the new file.
 * 
 * @author Sophia
 *
 */
public class TempToFile {
	/**
	 * The method 'swapFiles' is used after tranferring information from a file
	 * to a new file, and it simply deletes the old file and its name is
	 * assigned to the new file.
	 * 
	 * @param oldFile
	 * @param newFile
	 */
	public void swapFiles(File oldFile, File newFile) {

		boolean isDeleted = false;

		while (!isDeleted) {
			isDeleted = oldFile.delete();
			if (isDeleted) {
				newFile.renameTo(oldFile);
			}
		}
	}
}
