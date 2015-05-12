package com.ford.bowling;

public class Frame {

	private int roll1;
	private int roll2;
	private int roll3;
	private int frameNumber;
	
	public Frame(int frameNumber, int roll1, Integer roll2) {

		this.frameNumber = frameNumber;
		this.roll1 = roll1;
		if (roll2 == null) {
			this.roll2 = 0;
		} else {
			this.roll2 = roll2;
		}
		
		validateFrameNumber();
		validateRolls();

	}

	public Frame(int frameNumber, int roll1, Integer roll2, Integer roll3) {
		this(frameNumber, roll1, roll2);
		if (roll3 == null) {
			this.roll3 = 0;
		} else {
			this.roll3 = roll3;
		}
	}

	public int getFrameNumber() {
		return this.frameNumber;
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

	private void validateFrameNumber() {
		if (this.frameNumber > 10 || this.frameNumber < 1)
			throw new RuntimeException();
	}

	public boolean isStrike() {
		return (10 == roll1);
	}

	public void validateRolls() {

		if (this.roll1 > 10 || this.roll1 < 0) {
			throw new RuntimeException("Roll one is invalid.");
		}

		if (this.roll2 > 10 || this.roll2 < 0) {
			throw new RuntimeException("Roll two invalid.");
		}

		int sum = this.roll1 + this.roll2;
		
		
		
		if (this.frameNumber <10 &&  (sum > 10 || sum < 0))  {
			throw new RuntimeException("Roll total invalid.");
		}

	}
	
}
