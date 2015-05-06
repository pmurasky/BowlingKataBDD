package com.ford.bowling;

public class RichsBowlingGame implements BowlingGame {

  private int[] rolls = new int[21];

  @Override
  public Integer getTotalScore() {
    int score = 0;
    for (int frame = 1; frame < 11; frame++) {
      int frameOffset = frameOffset(frame);
      if (isStrike(frameOffset)) {
        score += getStrikeBonus(frameOffset);
      }
      score += getFrameBaseScore(frameOffset);
    }
    return score;
  }

  @Override
  public void createFrame(int frame, int... rolls) {
    System.arraycopy(rolls, 0, this.rolls, frameOffset(frame), rolls.length);
  }

  private int getFrameBaseScore(int frameOffset) {
    return rolls[frameOffset] + rolls[frameOffset + 1];
  }

  private int getStrikeBonus(int frameOffset) {
    int bonus = 0;
    if (frameOffset < 11) {
      bonus = rolls[frameOffset + 2] + rolls[frameOffset + 3];
    }
    return bonus;
  }

  private boolean isStrike(int frameOffset) {
    return rolls[frameOffset] == 10;
  }

  private int frameOffset(int frame) {
    return (frame - 1) * 2;
  }

}
