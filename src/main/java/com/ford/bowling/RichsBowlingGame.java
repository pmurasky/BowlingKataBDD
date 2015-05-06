package com.ford.bowling;

public class RichsBowlingGame implements BowlingGame {

  private int[] rolls = new int[21];

  @Override
  public Integer getTotalScore() {
    int score = 0;
    for (int frame = 1; frame < 11; frame++) {
      if (isStrike(frame)) {
        score += getStrikeBonus(frame);
      } else if (isSpare(frame)) {
        score += getSpareBonus(frame);
      }
      score += getFrameBaseScore(frame);
    }
    return score;
  }

  @Override
  public void createFrame(int frame, int... rolls) {
    System.arraycopy(rolls, 0, this.rolls, rollOffsetFor(frame), rolls.length);
  }

  private int getSpareBonus(int frame) {
    return rollOneOf(frame + 1);
  }

  private boolean isSpare(int frame) {
    return getFrameBaseScore(frame) == 10;
  }

  private int getFrameBaseScore(int frame) {
    return rollOneOf(frame) + rollTwoOf(frame);
  }

  private int getStrikeBonus(int frame) {
    int nextFrame = frame + 1;
    int bonus = 0;
    if (frame < 10) {
      bonus += rollOneOf(nextFrame) + rollTwoOf(nextFrame);
      if (isStrike(nextFrame) && rollTwoOf(nextFrame) == 0) {
        bonus += rollOneOf(nextFrame + 1);
      }
    } else {
      bonus += rollOneOf(nextFrame);
    }
    return bonus;
  }

  private int rollOneOf(int frame) {
    return rolls[rollOffsetFor(frame)];
  }

  private int rollTwoOf(int frame) {
    return rolls[rollOffsetFor(frame) + 1];
  }

  private boolean isStrike(int frame) {
    return rollOneOf(frame) == 10;
  }

  private int rollOffsetFor(int frame) {
    return (frame - 1) * 2;
  }

}
