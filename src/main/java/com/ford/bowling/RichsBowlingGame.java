package com.ford.bowling;

public class RichsBowlingGame implements BowlingGame {

  private int[] rolls = new int[21];

  @Override
  public Integer getTotalScore() {
    int score = 0;
    for (int frame = 1; frame < 11; frame++) {
      int frameOffset = (frame-1)*2;
      if ( rolls[frameOffset] == 10 ) {
        //strike!
        int bonus = rolls[frameOffset+2] + rolls[frameOffset+3];
        score += bonus;
      }
      score += rolls[frameOffset] + rolls[frameOffset+1];
    }
    return score;
  }

  @Override
  public void createFrame(int frame, int... rolls) {
    System.arraycopy(rolls, 0, this.rolls, (frame-1)*2, rolls.length);
  }

}
  