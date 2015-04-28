package com.ford.bowling;

public class Frame {

	private int roll1;
	private int roll2;
	private int roll3;
	private int baseScore;
	private int frameNumber;
	
	public Frame(int frameNumber, int roll1, Integer roll2) {
		this.frameNumber = frameNumber;
		this.roll1 = roll1;
		if (roll2 == null){
			this.roll2 = 0;
		} else {
			this.roll2 = roll2;
		}
		
	}
	
	public Frame(int frameNumber, int roll1, Integer roll2, Integer roll3) {
		this(frameNumber, roll1, roll2);
		if (roll3 == null){
			this.roll3 = 0;
		} else {
			this.roll3 = roll3;
		}
	}

	public int getFrameTotalScore() {
		return baseScore;
	}

	public boolean isStrike() {
		if (roll1 == 10){
			return true;
		}
		return false;
	}

	public boolean isSpare() {
		if (!isStrike() && (this.roll1 + this.roll2) == 10){
			return true;
		}
		return false;
	}

	public void calculateBaseFrameScore() {
		baseScore = this.roll1 + this.roll2;
	}
	
	public void addPinsToScore(int score){
		this.baseScore += score;
	}

	public int getFrameNumber() {
		return this.frameNumber;
	}
	
	public void setBaseScore(int baseScore){
		this.baseScore = roll1 + roll2;
	}

	public int getBaseScore() {
		return this.baseScore;
	}
	
	public int getRoll1() {
		return roll1;
	}

	public int getRoll2() {
		return roll2;
	}
	
	public int getRoll3() {
		return roll3;
	}

}
