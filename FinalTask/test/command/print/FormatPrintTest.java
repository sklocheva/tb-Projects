package command.print;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FormatPrintTest {

	FormatPrint formatPrint;
	String output;

	@Before
	public void test() {
		formatPrint = new FormatPrint();
	}

	@Test
	public void testStandardInput() {
		output = formatPrint.formatInput("BG49rreMBvMMTd8Zu-suv-Q5-sedan-P-956-T-euro5-Auto-5-false");
		Assert.assertEquals("BG49rreMBvMMTd8Zu | Q5    | sedan      | P-1282hpT-euro5  | Auto-5       | false     \r\n", output);
	}

//	@Test
//	public void testStandardElectricEngineInput() {
//		output = formatPrint.formatInput("BG17gn5GUgc9zBuSE-car-A5-hatchback-E-535-null-euro null-null-null-false");
//		Assert.assertEquals("BG17gn5GUgc9zBuSE | A5    | hatchback  | E-717hp-euronull  | -        | false     \r\n",
//				output);
//	}

}
