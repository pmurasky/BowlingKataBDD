package com.ford.bowling;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class BowlingScorerTest {

	@Test
	public void calculateTotalScoreForAllOpenFrames() {
		BowlingScorer scorer = new BowlingScorer();
		
		List<Integer> rolls = Lists.newArrayList(8,1,4,4,5,3,2,3,9,0,8,1,5,4,5,2,0,7,2,6);
		
		int totalScore = scorer.calculatedScore(rolls);
		
		assertThat(totalScore).isEqualTo(79);
		
	}
	
	@Test
	public void calculateTotalScoreForAllStrikesFrames() {
		BowlingScorer scorer = new BowlingScorer();
		
		List<Integer> rolls = Lists.newArrayList(10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,10,10);
		
		int totalScore = scorer.calculatedScore(rolls);
		
		assertThat(totalScore).isEqualTo(300);
		
	}

}
