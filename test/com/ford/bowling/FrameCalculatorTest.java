package com.ford.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FrameCalculatorTest {

	@Test
	public void testFrameScoreNoStrikesOrSparesButSomeValue() {
		Frame frame1 = new Frame(1, 1, 8);
		Frame frame2 = new Frame(2, 1, 0);
		Frame frame3 = new Frame(3, 1, 0);
		assertEquals(new FrameCalculator().calculateFrameScore(frame1, frame2, frame3), 9);
	}
	
	@Test
	public void testFrameScoreThreeStrikes() {
		Frame frame1 = new Frame(1, 10, null);
		Frame frame2 = new Frame(2, 10, null);
		Frame frame3 = new Frame(3, 10, null);
		assertEquals(new FrameCalculator().calculateFrameScore(frame1, frame2, frame3), 30);
	}

	@Test
	public void testFrameScoreStrikeSecondFrameTwoRolls() throws Exception {
		Frame frame1 = new Frame(1, 10, null);
		Frame frame2 = new Frame(2, 2, 3);
		Frame frame3 = new Frame(3, 10, null);
		assertEquals(new FrameCalculator().calculateFrameScore(frame1, frame2, frame3), 15);
	}
	
	
	@Test
	public void testFrameScoreSpareSecondFrameTwoRolls() throws Exception {
		Frame frame1 = new Frame(1, 5, 5);
		Frame frame2 = new Frame(2, 2, 3);
		Frame frame3 = new Frame(3, 10, null);
		assertEquals(new FrameCalculator().calculateFrameScore(frame1, frame2, frame3), 12);
	}
}
