package com.ford.bowling;

import java.util.Arrays;

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
    return !isStrike(rollOffset) && getFrameBaseScore(rollOffset) == 10;
  }

  private int getFrameBaseScore(int rollOffset) {
    return rolls[rollOffset] + rolls[rollOffset + 1];
  }

  private int getStrikeBonus(int rollOffset) {
    int bonus = 0;
    if (rollOffset < 18) {
      bonus = getSpareBonus(rollOffset) + rolls[rollOffset + 3];
      if (isStrike(rollOffset + 2)) {
        bonus += rolls[rollOffset + 4];
      }
    }
    return bonus;
  }

  private boolean isStrike(int rollOffset) {
    return rolls[rollOffset] == 10;
  }

  private int rollOffsetFor(int frame) {
    return (frame - 1) * 2;
  }

}
