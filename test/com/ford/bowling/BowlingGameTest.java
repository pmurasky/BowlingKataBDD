package com.ford.bowling;



import org.junit.Assert;
import org.junit.Test;

public class BowlingGameTest {
	
	
	@Test
	public void testGetTotalScoreWhenAllGutterBalls() {
		BowlingGame game = new BowlingGame();
		Assert.assertTrue(game.getTotalScore() == 0);
	}

	@Test
	public void testGetTotalScoreWhenIKnockedDown1pinFirstRoll() {
		BowlingGame game = new BowlingGame();
		game.createFrame(1, 1, 0);

		Assert.assertTrue(game.getTotalScore() == 1);
	}

	@Test
	public void testGetTotalScoreWhenIKnockedDown1pinSecondRoll() {
		BowlingGame game = new BowlingGame();
		game.createFrame(1, 0, 1);

		Assert.assertTrue(game.getTotalScore() == 1);
	}

	@Test
	public void testOpenFirstFrameWithPinsKnockedInBothRolls() {
		BowlingGame game = new BowlingGame();
		game.createFrame(1, 4, 4);

		Assert.assertTrue(game.getTotalScore() == 8);
	}

	@Test
	public void testOpenNinthFrameWithPinsKnockedInBothRolls() {
		BowlingGame game = new BowlingGame();
		game.createFrame(9, 4, 4);

		Assert.assertTrue(game.getTotalScore() == 8);
	}
	

	@Test
	public void testStrikeInFirstFrameFollowedByTwoGutterBalls() {
		BowlingGame game = new BowlingGame();
		game.createFrame(1, 10, null);
		game.createFrame(2, 0, 0);
		Assert.assertEquals("after enough post-strike rolls", 10, game.getTotalScore());
	}
	
	@Test
	public void testStrikeInFirstFrameFollowedBySecondFrameNoGutterBalls() {
		BowlingGame game = new BowlingGame();
		game.createFrame(1, 10, null);
		game.createFrame(2, 2, 7);
		Assert.assertEquals("after enough post-strike rolls", 28, game.getTotalScore());
	}

	@Test
	public void testStrikeInFirstFrameWithNoSecondFrame() {
		BowlingGame game = new BowlingGame();
		game.createFrame(1, 10, null);
		Assert.assertEquals("after enough post-strike rolls", 10, game.getTotalScore());
	}
	
	@Test
	public void testStrikeInFirstFrameWithStrikeInSecondFrame() {
		BowlingGame game = new BowlingGame();
		game.createFrame(1, 10, null);
		game.createFrame(2, 10, null);
		game.createFrame(3, 0, 0);
		
		Assert.assertEquals("after enough post-strike rolls", 30, game.getTotalScore());
	}
	@Test
	public void testStrikeInFirstFrameWithStrikeInSecondFrameAndOneInThirdFrame() {
		BowlingGame game = new BowlingGame();
		game.createFrame(1, 10, null);
		game.createFrame(2, 10, null);
		game.createFrame(3, 1, 0);
		Assert.assertEquals("after enough post-strike rolls", 33, game.getTotalScore());
	}
	
	@Test
	public void testForFirstThreeStrikes() {
		BowlingGame game = new BowlingGame();
		game.createFrame(1, 10, null);
		game.createFrame(2, 10, null);
		game.createFrame(3, 10, null);
		Assert.assertEquals("after enough post-strike rolls",60 , game.getTotalScore());
	}
}