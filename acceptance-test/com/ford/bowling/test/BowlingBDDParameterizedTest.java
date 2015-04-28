package com.ford.bowling.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.ford.bowling.BowlingGame;
import com.ford.bowling.Frame;
import com.google.common.collect.Lists;

@RunWith(Parameterized.class)
public class BowlingBDDParameterizedTest {

private BowlingGame game;

	private int totalScore = 0;
	private List<Frame> frames;
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
				{createAllStrikeGame()},
				{createAllGutterBallGame()},
				{createAllSpareGame()},
				{createStrikesAndSpareGame()},
				{createAllOpenFramesUntilAllStrikesInTenthGame()}
		});
	}
	
	@Before
	public void givenANewBowlingGame(){
		game = new BowlingGame();
	}
	
	private void thenTotalScoreShouldBe(int expectedScore){
		assertThat(game.getTotalScore()).isEqualTo(expectedScore);
	}
	
	public BowlingBDDParameterizedTest(TestGame testGame){
		this.totalScore = testGame.totalScore;
		this.frames = testGame.frames;
	}
	
	private static TestGame createAllStrikeGame(){
		return new TestGame(300, Lists.newArrayList(new Frame(1,10,null), new Frame(2,10,null), new Frame(3,10,null), 
			new Frame(4,10,null), new Frame(5,10,null),new Frame(6,10,null),new Frame(7,10,null),new Frame(8,10,null),
			new Frame(9,10,null),new Frame(10,10,10,10)));
	}
	
	private static TestGame createAllGutterBallGame(){
		return new TestGame(0, Lists.newArrayList(new Frame(1,0,0), new Frame(2,0,0), new Frame(3,0,0), new Frame(4,0,0),
				new Frame(5,0,0),new Frame(6,0,0),new Frame(7,0,0),new Frame(8,0,0),new Frame(9,0,0),new Frame(10,0,0,null)));
	}
	
	private static TestGame createAllSpareGame(){
		return new TestGame(164, Lists.newArrayList(new Frame(1,9,1), new Frame(2,4,6), new Frame(3,7,3), new Frame(4,5,5),
				new Frame(5,8,2),new Frame(6,8,2),new Frame(7,9,1),new Frame(8,0,10),new Frame(9,9,1),new Frame(10,9,1,5)));
	}
	
	private static TestGame createStrikesAndSpareGame(){
		return new TestGame(165, Lists.newArrayList(new Frame(1,9,1), new Frame(2,10,0), new Frame(3,7,2), new Frame(4,10,0),
				new Frame(5,10,0),new Frame(6,4,4),new Frame(7,9,1),new Frame(8,0,10),new Frame(9,10,0),new Frame(10,10,1,5)));
	}
	
	private static TestGame createAllOpenFramesUntilAllStrikesInTenthGame(){
		return new TestGame(100, Lists.newArrayList(new Frame(1,9,0), new Frame(2,6,0), new Frame(3,7,2), new Frame(4,3,6),
				new Frame(5,8,1),new Frame(6,4,4),new Frame(7,3,1),new Frame(8,0,8),new Frame(9,5,3),new Frame(10,10,10,10)));
	}
	
	
	@Test
	public void whenABowlerBowlsAGame() {
		game.setAllFrames(this.frames);
		thenTotalScoreShouldBe(this.totalScore);
	}
	
	private static class TestGame{
		public int totalScore = 0;
		public  List<Frame> frames;
		
		public TestGame(int score, List<Frame> allFrames){
			totalScore = score;
			frames = allFrames;
		}
	}
	
}
