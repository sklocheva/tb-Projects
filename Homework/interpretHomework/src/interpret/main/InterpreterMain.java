package interpret.main;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InterpreterMain {

	public static void main(String[] args) {
		InputStream instr = System.in;

		CmdInterpreter cmdInterpreter = new CmdInterpreter();
		Scanner inscan = new Scanner(instr);
		try {
			while (true) {
				String line = inscan.nextLine().trim();
				System.out.println(cmdInterpreter.processLine(line));
			}
		} catch (NoSuchElementException e) {
			// end of file reached
		} finally {
			inscan.close();
		}
	}
}