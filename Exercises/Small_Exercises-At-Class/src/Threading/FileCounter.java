package Threading;

import java.io.File;

/**
 * output: Thread counting in Git: 6303 files Thread counting in Workspace: 1220
 * files It takes 4.448237978 using one thread. Thread counting in Workspace:
 * 1220 files Thread counting in Git: 6303 files It takes 2.654630214 using two
 * threads.
 */
public class FileCounter {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {
			public void run() {

				System.out.println("Thread counting in Git: " + readDirectory(new File("C:/Git")) + " files");
				System.out.println(
						"Thread counting in Workspace: " + readDirectory(new File("C:/Workspaces")) + " files");
			}
		});

		long startTime = System.nanoTime();
		t1.start();
		t1.join();

		System.out.println("It takes " + (System.nanoTime() - startTime) / 1e9 + " using one thread.");

		Thread tApps = new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread counting in Git: " + readDirectory(new File("C:/Git")) + " files");
			}
		});

		Thread tWorkspace = new Thread(new Runnable() {
			public void run() {
				System.out.println(
						"Thread counting in Workspace: " + readDirectory(new File("C:/Workspaces")) + " files");
			}
		});

		startTime = System.nanoTime();
		tWorkspace.start();
		tApps.start();
		tApps.join();
		tWorkspace.join();

		System.out.println("It takes " + (System.nanoTime() - startTime) / 1e9 + " using two threads.");

	}

	private static long readDirectory(File directory) {

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