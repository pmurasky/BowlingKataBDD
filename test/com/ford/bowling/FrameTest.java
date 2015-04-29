package com.ford.bowling;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class FrameTest {

	@Test(expected = RuntimeException.class)
	public void testOutOfBoundsLargeFrameNumber() {
		new Frame(11, 0, 0);
	}

	@Test(expected = RuntimeException.class)
	public void testOutOfBoundsSmallFrameNumber() {
		new Frame(0, 0, 0);
	}

	@Test(expected = RuntimeException.class)
	public void testScoreTooLow() {
		 new Frame(1, -1, 0);
		

	}
	
	@Test(expected = RuntimeException.class)
	public void testRollOneTooHigh() {
		 new Frame(1, 11, 6);
		

	}
	
	@Test(expected = RuntimeException.class)
	public void testRollTwoTooHigh() {
		 new Frame(1, 1, 11);
		

	}

	@Test(expected = RuntimeException.class)
	public void testRollOneTooLow() {
		 new Frame(1, -1, 5);

	}

	@Test(expected = RuntimeException.class)
	public void testRollTwoTooLow() {
		new Frame(1, 5, -1);

	}

	@Test(expected = RuntimeException.class)
	public void testScoreCombinationTooHigh() {
		 new Frame(1, 5, 6);
		

	}

	@Test
	public void testNonStrikeFrameKnowsItsNotStrike() {
		Frame frame = new Frame(3, 5, 2);
		assertFalse(frame.isStrike());
	}

	@Test
	public void testStrikeFrameKnowsItsStrike() {
		Frame frame = new Frame(3, 10, null);
		assertTrue(frame.isStrike());
	}
}
