package Multithreading.fileCounterFixedThread;

import java.io.File;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

public class FileCounterRewritten {

	public static void main(String[] args) {
		CompletionService<String> completionService = new ExecutorCompletionService<String>(
				Executors.newFixedThreadPool(6));

		File fileGit = new File("C:/Git");
		File fileWrokspace = new File("C:/Workspaces");

		TaskGenerator taskCountWorkspace = new TaskGenerator(fileWrokspace, 1, completionService);
		TaskGenerator taskCountGit = new TaskGenerator(fileGit, 1, completionService);
		TaskCollector collector = new TaskCollector(completionService);
		
		Thread threadCountWorkspace = new Thread(taskCountWorkspace);
		Thread threadCountGit = new Thread(taskCountGit);
		Thread threadCol = new Thread(collector);
		
		threadCountWorkspace.start();
		threadCountGit.start();
		threadCol.start();

	}

}
