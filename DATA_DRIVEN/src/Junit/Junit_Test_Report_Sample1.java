package Junit;

	import static org.junit.Assert.assertTrue;

	import org.junit.Test;

	public class Junit_Test_Report_Sample1 extends Junit_Test_Report_Sample2 {

		@Test
		public void sampleTest0() {
			assertTrue(1 < 2);
		}

		@Test
		public void sampleTest1() {
			assertTrue(1 > 2);
		}

		@Test
		public void sampleTest2() {
			assertTrue(1 < 2);
		}

		@Test
		public void sampleTest4() {
			assertTrue(1 > 2);
		}
	}

