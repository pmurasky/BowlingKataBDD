package com.ford.bowling;

public class FrameCalculator {
	
	public int calculateFrameScore(Frame frame, Frame nextFrame, Frame nextNextFrame) {
		int score = frame.getRoll1() + frame.getRoll2() + frame.getRoll3();
		if(frame.isStrike()) {
			score += nextFrame.getRoll1() + nextFrame.getRoll2();
			if(nextFrame.isStrike()){
				score += nextNextFrame.getRoll1();
			}
		}
		else if(frame.isSpare()){
			score += nextFrame.getRoll1();
		}
		return score;
	}
	
}
