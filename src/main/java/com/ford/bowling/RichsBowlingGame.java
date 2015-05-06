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

  private int getFrameBaseScore(int frame) {
    return rollOneOf(frame) + rollTwoOf(frame);
  }

  private boolean isStrike(int frame) {
    return rollOneOf(frame) == 10 && (frame == 10 || rollTwoOf(frame) == 0);
  }

  private boolean isSpare(int frame) {
    return getFrameBaseScore(frame) == 10;
  }

  private int getSpareBonus(int frame) {
    return rollOneOf(frame + 1);
  }

  private int getStrikeBonus(int frame) {
    int nextFrame = frame + 1;
    int bonus = 0;
    if (frame < 9 && isStrike(nextFrame)) {
      bonus += rollOneOf(nextFrame + 1);
    }
    if (frame < 10) {
      bonus += getFrameBaseScore(nextFrame);
    }
    if (frame == 10) {
      bonus += bonusBallOfFrame10();
    }
    return bonus;
  }

  private int rollOneOf(int frame) {
    return rolls[rollOffsetFor(frame)];
  }

  private int rollTwoOf(int frame) {
    return rolls[rollOffsetFor(frame) + 1];
  }

  private int bonusBallOfFrame10() {
    return rolls[20];
  }

  private int rollOffsetFor(int frame) {
    return (frame - 1) * 2;
  }

}
