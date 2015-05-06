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
    return rollOneOf(frame) == 10 && (itsTheTenth(frame) || rollTwoOf(frame) == 0);
  }

  private boolean isSpare(int frame) {
    return getFrameBaseScore(frame) == 10;
  }

  private int getSpareBonus(int frame) {
    return rollOneOf(frame + 1);
  }

  private int getStrikeBonus(int frame) {
    int bonus = 0;
    if (itsTheTenth(frame)) {
      bonus += bonusBallOfFrame10();
    } else {
      int nextFrame = frame + 1;
      bonus += getFrameBaseScore(nextFrame);
      if (isStrike(nextFrame) && beforeTheNinth(frame)) {
        bonus += rollOneOf(nextFrame + 1);
      }
    }
    return bonus;
  }

  private boolean beforeTheNinth(int frame) {
    return frame < 9;
  }
  
  private boolean itsTheTenth(int frame) {
    return frame == 10;
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
