package com.ford.bowling;

public class RichsBowlingGame implements BowlingGame {

  private int[] rolls = new int[21];

  @Override
  public void createFrame(int frame, int... rolls) {
    System.arraycopy(rolls, 0, this.rolls, rollOffsetFor(frame), rolls.length);
  }

  @Override
  public Integer getTotalScore() {
    int score = 0;
    for (int frameId = 1; frameId < 11; frameId++) {
      score += createFrame(frameId).getScore();
    }
    return score;
  }

  private Frame createFrame(int frameId) {
    int rollOffset = rollOffsetFor(frameId);
    int[] frameRolls = new int[5];
    System.arraycopy(rolls, rollOffset, frameRolls, 0, Math.min(5, 21 - rollOffset));
    Frame frame = new Frame(frameId, frameRolls);
    return frame;
  }

  private int rollOffsetFor(int frame) {
    return (frame - 1) * 2;
  }

}

class Frame {
  private int[] frameRolls = new int[5];
  private int frameId;

  Frame(int frameNumber, int[] rolls) {
    frameId = frameNumber;
    frameRolls = rolls;
  }

  int getScore() {
    int score = baseScore();
    if (isStrike()) {
      score += strikeBonus();
    }
    if (isSpare()) {
      score += spareBonus();
    }
    return score;
  }

  private boolean isStrike() {
    return firstBall() == 10 && (isTenthFrame() || secondBall() == 0);
  }

  private boolean nextFrameIsStrike() {
    return firstBallOfNextFrame() == 10;
  }

  private boolean isSpare() {
    return baseScore() == 10 && secondBall() > 0;
  }

  private int baseScore() {
    return firstBall() + secondBall();
  }

  private int strikeBonus() {
    int bonus = 0;
    if (isTenthFrame()) {
      bonus = bonusBall();
    } else if (isNinthFrame()) {
      bonus = firstBallOfNextFrame() + secondBallOfNextFrame();
    } else if (nextFrameIsStrike()) {
      bonus = firstBallOfNextFrame() + firstBallOfNextFramesNextFrame();
    } else {
      bonus = firstBallOfNextFrame() + secondBallOfNextFrame();
    }
    return bonus;
  }

  private int spareBonus() {
    return firstBallOfNextFrame();
  }

  private int firstBall() {
    return frameRolls[0];
  }

  private int secondBall() {
    return frameRolls[1];
  }

  private int firstBallOfNextFrame() {
    return frameRolls[2];
  }

  private int secondBallOfNextFrame() {
    return frameRolls[3];
  }

  private int firstBallOfNextFramesNextFrame() {
    return frameRolls[4];
  }

  private int bonusBall() {
    return firstBallOfNextFrame();
  }

  private boolean isTenthFrame() {
    return frameId == 10;
  }

  private boolean isNinthFrame() {
    return frameId == 9;
  }

}