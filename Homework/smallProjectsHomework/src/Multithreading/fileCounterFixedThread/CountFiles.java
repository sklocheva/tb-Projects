package Multithreading.fileCounterFixedThread;

import java.io.File;

public class CountFiles {

	long readDirectory(File directory) {

		long totalFiles = 0;
		for (File file : directory.listFiles()) {
			if (file.isFile()) {
				totalFiles++;
			}
			if (file.isDirectory()) {
				if (file != null) {
					totalFiles += readDirectory(file);
				}
			}
		}
		return totalFiles;
	}

}
