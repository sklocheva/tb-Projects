package Multithreading.fileCounterFixedThread;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;

public class TaskGenerator implements Runnable {

	// private static final int NUM_TASKS = 2;
	private File directory;
	private int delay;
	private CompletionService<String> completionService;
	private CountFiles countFiles;

	public TaskGenerator(File directory, int delay, CompletionService<String> completionService) {
		this.directory = directory;
		this.delay = delay;
		this.completionService = completionService;
		countFiles = new CountFiles();
	}

	@Override
	public void run() {
		System.out.println("Thread counting in " + this.directory.toString());
		File currentDirectory = this.directory;
		long count = countFiles.readDirectory(this.directory);
		long time = System.nanoTime();

		completionService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(delay * 1000);
				return "Thread finished counting in " + currentDirectory + ": " + count + " files " + "for "
						+ (System.nanoTime() - time) / 1e9 + " seconds.";
			}

		});
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}
	}

}
