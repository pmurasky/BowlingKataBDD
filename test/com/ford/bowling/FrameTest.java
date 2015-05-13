package com.ford.bowling;

import static org.junit.Assert.*;

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
	
	@Test
	public void frameKnowsItIsASpare() {
		assertTrue(new Frame(1,5,5).isSpare());
	}
	
	@Test
	public void frameKnowsItsNotASpare() {
		assertFalse(new Frame(1,3,3).isSpare());
	}
	
	@Test
	public void frameKnowsDifferenceBetweenStrikeAndSpare() {
		assertFalse(new Frame(1,10,0).isSpare());
	}
	
	@Test
	public void testFrameScoreNoStrikesOrSparesButSomeValue() {
		Frame frame1 = new Frame(1, 1, 8);
		Frame frame2 = new Frame(2, 1, 0);
		frame1.setNextFrame(frame2);
		Frame frame3 = new Frame(3, 1, 0);
		frame2.setNextFrame(frame3);
		assertEquals(frame1.calculateScore(), 9);
	}
	
	@Test
	public void testFrameScoreThreeStrikes() {
		Frame frame1 = new Frame(1, 10, null);
		Frame frame2 = new Frame(2, 10, null);
		frame1.setNextFrame(frame2);
		Frame frame3 = new Frame(3, 10, null);
		frame2.setNextFrame(frame3);
		assertEquals(frame1.calculateScore(), 30);
	}

	@Test
	public void testFrameScoreStrikeSecondFrameTwoRolls() throws Exception {
		Frame frame1 = new Frame(1, 10, null);
		Frame frame2 = new Frame(2, 2, 3);
		frame1.setNextFrame(frame2);
		Frame frame3 = new Frame(3, 10, null);
		frame2.setNextFrame(frame3);
		assertEquals(frame1.calculateScore(), 15);
	}
	
	
	
	
	@Test
	public void testFrameScoreSpareSecondFrameTwoRolls() throws Exception {
		Frame frame1 = new Frame(1, 5, 5);
		Frame frame2 = new Frame(2, 2, 3);
		frame1.setNextFrame(frame2);
		Frame frame3 = new Frame(3, 10, null);
		frame2.setNextFrame(frame3);
		assertEquals(frame1.calculateScore(), 12);
	}
	
	@Test
	public void testTenthFrameScoreStrike() throws Exception {
		Frame frame10 = new Frame(10, 10, 10,10);
		assertEquals(frame10.calculateScore(), 30);
	}

	@Test
	public void testTenthFrameScoreTwoStrikesAndGutter() throws Exception {
		Frame frame10 = new Frame(10, 10, 10,null);
		assertEquals(frame10.calculateScore(), 20);
	}
	@Test
	public void testNinethFrameScoreStrike() throws Exception {
		Frame frame9 = new Frame(9, 10, 0);
		Frame frame10 = new Frame(10, 10, 10,10);
		frame9.setNextFrame(frame10);
		assertEquals(frame9.calculateScore(), 30);
	}
}