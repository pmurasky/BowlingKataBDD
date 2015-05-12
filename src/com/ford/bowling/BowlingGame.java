package com.ford.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();

	public BowlingGame(){
		for(int i=1;i <= 10;i++){
			frames.add(new Frame(i,0,0));
		}
	}
	
	public int getTotalScore() {
		int totalScore = 0;
		FrameCalculator frameCalculator = new FrameCalculator();
		for (int frameIndex = 0; frameIndex < frames.size(); frameIndex++) {
			Frame frame = frames.get(frameIndex);
			Frame nextFrame = getNextFrame(frameIndex);
			Frame nextNextFrame = getNextFrame(frameIndex + 1);
			
			totalScore += frameCalculator.calculateFrameScore(frame, nextFrame, nextNextFrame);
		}

		return totalScore;
	}

	private Frame getNextFrame(int frameIndex) {
		if(frameIndex < frames.size() - 1) {
			return frames.get(frameIndex + 1);
		}
		return new Frame(10, 0, 0);
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
