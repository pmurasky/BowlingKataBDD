package com.ford.bowling;

public class RichsBowlingGame implements BowlingGame {

  private int[] rolls = new int[21];

  @Override
  public Integer getTotalScore() {
    int score = 0;
    for (int frame = 1; frame < 11; frame++) {
      int frameOffset = frameOffset(frame);
      if ( isStrike(frameOffset) ) {
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
    System.arraycopy(rolls, 0, this.rolls, frameOffset(frame), rolls.length);
  }
  
  private boolean isStrike(int frameOffset) {
    return rolls[frameOffset] == 10;
  }

  private int frameOffset(int frame) {
    return (frame-1)*2;
  }

}
  