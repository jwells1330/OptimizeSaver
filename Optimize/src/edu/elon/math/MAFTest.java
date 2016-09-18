package edu.elon.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class MAFTest {

	@Test
	public void testEvaluate() {
		MinimumAbsoluteSum maf = new MinimumAbsoluteSum();
		assertEquals(maf.evaluate(), Double.valueOf(600));
	}

}
