package com.ford.bowling;

import java.util.List;

public class BowlingScorer {

	public int calculatedScore(List<Integer> rolls) {
		int totalScore = 0;
		int frameNumber = 1;
		int rollIndex = 0;
		for (Integer roll : rolls){
			if ((rollIndex % 2) == 0){
				frameNumber++;
			}
			int extraPins = 0;
			if (roll == 10){
				extraPins += rolls.get(rollIndex+2);
				if (extraPins == 10){
					extraPins += rolls.get(rollIndex+4);
				}
			}
			rollIndex++;
			totalScore += roll;
		}
		return totalScore;
	}

}
