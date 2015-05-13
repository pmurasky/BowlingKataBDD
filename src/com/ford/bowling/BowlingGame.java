package com.ford.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	
	public static final int FRAMES_PER_GAME = 10;

	private List<Frame> frames = new ArrayList<Frame>();

	public BowlingGame(){
		for(int i=1;i <= 10;i++){
			frames.add(new Frame(i,0,0));
		}
	}
	
	private void linkFrames() {
		for(int i = 0; i < FRAMES_PER_GAME - 1; i++) {
			frames.get(i).setNextFrame(frames.get(i + 1));
		}
	}
	
	public int getTotalScore() {
		linkFrames();
		
		int totalScore = 0;
		for (Frame frame : frames) {
			totalScore += frame.calculateScore();
		}

		return totalScore;
	}



	public void createFrame(int frameNumber, int roll1, Integer roll2) {
		frames.set(frameNumber-1, new Frame(frameNumber, roll1, roll2));
	}
	
	public void setAllFrames(List<Frame> allFrames) {
		this.frames = allFrames;
	}

	public void createTenthFrame(int frameNumber, int roll1, Integer roll2, Integer roll3) {
		frames.set(frameNumber -1, new Frame(frameNumber, roll1, roll2, roll3));
	}

}
