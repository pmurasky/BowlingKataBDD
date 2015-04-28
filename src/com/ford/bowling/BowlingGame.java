package com.ford.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	
	private List<Frame> frames = new ArrayList<Frame>();

	public int getTotalScore() {
		int totalScore = 0;
		FrameScorer frameScorer = new FrameScorer(this.frames);
		frameScorer.calculateFrameScores();
		for(Frame frame : this.frames){
			totalScore += frame.getFrameTotalScore();
		}
		return totalScore;
	}

	public void createFrame(int frameNumber, int roll1, Integer roll2) {
		frames.add(new Frame(frameNumber, roll1, roll2));
	}
	
	public void setAllFrames(List<Frame> allFrames){
		this.frames = allFrames;
	}

	public void createTenthFrame(int frameNumber, int roll1, Integer roll2, Integer roll3) {
		frames.add(new Frame(frameNumber, roll1, roll2, roll3));
	}

}
