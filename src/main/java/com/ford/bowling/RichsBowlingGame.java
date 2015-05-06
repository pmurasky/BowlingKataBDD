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
        score += rolls[rollOffset + 2];
      }
      score += getFrameBaseScore(rollOffset);
    }
    return score;
  }

  private boolean isSpare(int rollOffset) {
    return !isStrike(rollOffset) && getFrameBaseScore(rollOffset) == 10;
  }

  @Override
  public void createFrame(int frame, int... rolls) {
    System.arraycopy(rolls, 0, this.rolls, rollOffsetFor(frame), rolls.length);
  }

  private int getFrameBaseScore(int rollOffset) {
    return rolls[rollOffset] + rolls[rollOffset + 1];
  }

  private int getStrikeBonus(int rollOffset) {
    int bonus = 0;
    if (rollOffset < 18) {
      bonus = rolls[rollOffset + 2] + rolls[rollOffset + 3];
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
