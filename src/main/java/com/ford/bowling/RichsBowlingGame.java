package com.ford.bowling;


public class RichsBowlingGame implements BowlingGame {

  private int[] rolls = new int[21];

  @Override
  public Integer getTotalScore() {
    int score = 0;
    for (int frame = 1; frame < 11; frame++) {
      int rollOffset = rollOffsetFor(frame);
      if (isStrike(rollOffset)) {
        score += getStrikeBonus(rollOffset);
      } else if (isSpare(rollOffset)) {
        score += getSpareBonus(rollOffset);
      }
      score += getFrameBaseScore(rollOffset);
    }
    return score;
  }

  @Override
  public void createFrame(int frame, int... rolls) {
    System.arraycopy(rolls, 0, this.rolls, rollOffsetFor(frame), rolls.length);
  }

  private int getSpareBonus(int rollOffset) {
    return rolls[rollOffset + 2];
  }

  private boolean isSpare(int rollOffset) {
    return getFrameBaseScore(rollOffset) == 10;
  }

  private int getFrameBaseScore(int rollOffset) {
    return rolls[rollOffset] + rolls[rollOffset + 1];
  }

  private int getStrikeBonus(int rollOffset) {
    int bonus = 0;
    if (rollOffset < 18) {
      bonus = rolls[rollOffset + 2] + rolls[rollOffset + 3];
      if (rolls[rollOffset + 3] == 0 && isStrike(rollOffset + 2)) { 
        bonus += rolls[rollOffset + 4];
      }
    } else {
      bonus = rolls[rollOffset + 2];
    }
    return bonus;
  }
  //what's making me nuts here is that we ended up with a frameless solution but frameness is coming into play
//add method for firstBallOfFrameId and secondBallOfFrameId, frame ten might have bonusball?
  private boolean isStrike(int rollOffset) { //change semantics back to frames
    return rolls[rollOffset] == 10;
  }

  private int rollOffsetFor(int frame) {
    return (frame - 1) * 2;
  }

}
