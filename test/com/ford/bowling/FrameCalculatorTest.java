package com.ford.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FrameCalculatorTest {
	
	@Test
	public void testFrameScore() {
		Frame frame1 = new Frame(1, 10, null);
		Frame frame2 = new Frame(2, 10, null);
		Frame frame3 = new Frame(3, 10, null);
		assertEquals(new FrameCalculator().calculateFrameScore(frame1, frame2, frame3), 30);
	}
	
}
