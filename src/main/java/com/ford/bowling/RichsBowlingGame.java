package com.ford.bowling;

public class RichsBowlingGame implements BowlingGame {

  private int[] rolls = new int[21];

  @Override
  public void createFrame(int frame, int... rolls) {
    System.arraycopy(rolls, 0, this.rolls, rollOffsetFor(frame), rolls.length);
  }

  @Override
  public Integer getTotalScore() {
    class Frame {
      int[] frameRolls = new int[5];
      boolean tenthFrame = false, ninthFrame = false;

      Frame(int frameNumber, int rollOffset, int[] rolls) {
        ninthFrame = rollOffset == 16;
        tenthFrame = rollOffset == 18;
        System.arraycopy(rolls, rollOffset, frameRolls, 0, Math.min(5, 21 - rollOffset));
      }

      int getScore() {
        int score = baseScore();
        if (isStrike()) {
          score += strikeBonus();
        }
        if (isSpare()) {
          score += spareBonus();
        }
        return score;
      }

      private boolean isStrike() {
        return firstBall() == 10 && (tenthFrame || secondBall() == 0);
      }

      private boolean nextFrameIsStrike() {
        return firstBallOfNextFrame() == 10;
      }

      private boolean isSpare() {
        return baseScore() == 10 && secondBall() > 0;
      }

      private int baseScore() {
        return firstBall() + secondBall();
      }

      private int strikeBonus() {
        int bonus = 0;
        if (tenthFrame) {
          bonus = bonusBall();
        } else if (ninthFrame) {
          bonus = firstBallOfNextFrame() + secondBallOfNextFrame();
        } else if (nextFrameIsStrike()) {
          bonus = firstBallOfNextFrame() + firstBallOfNextFramesNextFrame();
        } else {
          bonus = firstBallOfNextFrame() + secondBallOfNextFrame();
        }
        return bonus;
      }

      private int spareBonus() {
        return firstBallOfNextFrame();
      }

      private int firstBall() {
        return frameRolls[0];
      }

      private int secondBall() {
        return frameRolls[1];
      }

      private int firstBallOfNextFrame() {
        return frameRolls[2];
      }

      private int secondBallOfNextFrame() {
        return frameRolls[3];
      }

      private int firstBallOfNextFramesNextFrame() {
        return frameRolls[4];
      }

      private int bonusBall() {
        return firstBallOfNextFrame();
      }

    }
    int altScore = 0;
    for (int frame = 1; frame < 11; frame++) {
      int rollOffset = rollOffsetFor(frame);
      altScore += new Frame(frame, rollOffset, rolls).getScore();
    }
    return altScore;
  }

  private int rollOffsetFor(int frame) {
    return (frame - 1) * 2;
  }

}
