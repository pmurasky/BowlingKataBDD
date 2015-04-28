package com.ford.bowling;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;


public class BowlingGameTest {
	
	private BowlingGame game;
	
	@Before
	public void setup(){
		game = new BowlingGame();
	}
	
	@Test
	public void canGetTotalScoreFromBowlingGame() throws Exception {
		game.createFrame(1, 2, 2);
		game.createFrame(2, 4, null);
		
		assertThat(game.getTotalScore()).isEqualTo(8);
	}
	

}
