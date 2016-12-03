package Multithreading.fileCounterFromClassExtended;

import java.io.File;

public class TaskGen implements Runnable{
	private File directory;
	private File directory2 = null;
	private FilesCount fileCount;

	public TaskGen(File directory) {
		this.directory = directory;
		fileCount = new FilesCount();
	}

	public TaskGen(File directory, File directory2) {
		this.directory = directory;
		this.directory2 = directory2;
		fileCount = new FilesCount();
	}
	@Override
	public void run() {
		if (directory2 != null) {

			// long timeStart = System.nanoTime();

			System.out.println("Thread counting in " + directory.toString() + " using one thread "
					+ fileCount.readDirectory(this.directory) + " files");
			System.out.println("Thread counting in " + directory2.toString() + " using one thread "
					+ fileCount.readDirectory(this.directory2) + " files");

			// System.out.println("Finished counting both threads"
			// + " for "
			// + (System.nanoTime() - timeStart) / 1e9 + " seconds");
		} else {

			// long timeStart = System.nanoTime();
			System.out.println("Thread counting in " + directory.toString() + " using two threads "
					+ fileCount.readDirectory(this.directory) + " files");

			// System.out.println("Thread finished counting in " +
			// directory.toString() + " for "
			// + (System.nanoTime() - timeStart) / 1e9 + " seconds");
		}
	}
}
