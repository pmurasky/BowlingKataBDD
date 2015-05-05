package com.ford.bowling;

import java.util.List;

public class FrameScorer {

	private List<Frame> frames;

	public FrameScorer(List<Frame> frames) {
		this.frames = frames;
	}

	public void calculateFrameScores() {

		for (Frame frame : frames) {
			if (frame.getFrameNumber() == 10) {
				if (frame.isStrike() || frame.isSpare()) {
					frame.addPinsToScore(frames.get(frame.getFrameNumber() - 1).getRoll1());
					frame.addPinsToScore(frames.get(frame.getFrameNumber() - 1).getRoll2());
					frame.addPinsToScore(frames.get(frame.getFrameNumber() - 1).getRoll3());
				} else {
					frame.setBaseScore(frame.getRoll1() + frame.getRoll2());
				}
			} else {
				frame.setBaseScore(frame.getRoll1() + frame.getRoll2());
				if (frame.isStrike()) {
					Frame nextFrame = frames.get(frame.getFrameNumber());
					frame.addPinsToScore(nextFrame.getRoll1());
					if (nextFrame.isStrike()) {
						if(nextFrame.getFrameNumber() == 10){
							frame.addPinsToScore(nextFrame.getRoll2());
						} else {
						Frame nextNextFrame = frames.get(frame.getFrameNumber() + 1);
						frame.addPinsToScore(nextNextFrame.getRoll1());
						}
					} else {
						frame.addPinsToScore(nextFrame.getRoll2());
					}
				} else if (frame.isSpare()) {
					Frame nextFrame = frames.get(frame.getFrameNumber());
					frame.addPinsToScore(nextFrame.getRoll1());
				}
			}
			System.out.println(String.format("Frame:%s, Roll1:%s, Roll2:%s, FrameScore:%s",
					frame.getFrameNumber(), frame.getRoll1(), frame.getRoll2(), frame.getBaseScore()));
		}

	}

}
