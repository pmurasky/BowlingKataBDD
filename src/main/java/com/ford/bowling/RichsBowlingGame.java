package com.ford.bowling;

public class RichsBowlingGame implements BowlingGame {

  private int score = 0;

  @Override
  public Integer getTotalScore() {
    return score;
  }

  @Override
  public void createFrame(int frame, int... rolls) {
    for (int roll : rolls) {
      score += roll;
    }
  }

}
