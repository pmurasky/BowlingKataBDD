package com.ford.bowling;

public class RichsBowlingGame implements BowlingGame {

  private Frame head, tail;

  @Override
  public void createFrame(int frame, int... rolls) {
    appendNewFrame(new Frame(frame, rolls));
  }

  @Override
  public Integer getTotalScore() {
    return head.getScore();
  }

  private void appendNewFrame(Frame newFrame) {
    if (null == head) {
      head = tail = newFrame;
    } else {
      tail.setNextFrame(newFrame);
    }
    tail = newFrame;
  }

  private class Frame {
    private static final int MAX_ROLLS_IN_FRAME = 3;
    private int frameId;
    private int[] frameRolls = new int[MAX_ROLLS_IN_FRAME];
    private Frame nextFrame;

    private Frame(int frameNumber, int[] rolls) {
      frameId = frameNumber;
      System.arraycopy(rolls, 0, frameRolls, 0, Math.min(MAX_ROLLS_IN_FRAME, rolls.length));
      validate();
    }
    
    private void validate() {
      if ( !isTenthFrame() && firstBall() + secondBall() > 10 ) {
        throw new IllegalArgumentException("The maximum per frame score is 10");
      }
      if ( 0 > firstBall() || firstBall() > 10) {
        throw new IllegalArgumentException("A ball can score zero to 10 points.");
      }
      if ( 0 > secondBall() || secondBall() > 10) {
        throw new IllegalArgumentException("A ball can score zero to 10 points.");
      }
      if ( 0 > bonusBall() || bonusBall() > 10 ) {
        throw new IllegalArgumentException("The bonus ball can score zero to 10 points.");
      }
    }

    private int getScore() {
      int score = firstBall();
      if (isStrike()) {
        score += strikeBonus();
      } else if (isSpare()) {
        score += secondBall() + spareBonus();
      } else {
        score += secondBall();
      }
      return score + getNextFramesScore();
    }

    private int getNextFramesScore() {
      int score = 0;
      if (null != nextFrame) {
        score = nextFrame.getScore();
      }
      return score;
    }

    private boolean isStrike() {
      return firstBall() == 10;
    }

    private boolean nextFrameIsStrike() {
      return firstBallOfNextFrame() == 10;
    }

    private boolean isSpare() {
      return !isStrike() && firstBall() + secondBall() == 10;
    }

    private int strikeBonus() {
      int bonus = 0;
      if (isTenthFrame()) {
        bonus = secondBall() + bonusBall();
      } else if (isNinthFrame()) {
        bonus = firstBallOfNextFrame() + secondBallOfNextFrame();
      } else if (nextFrameIsStrike()) {
        bonus = firstBallOfNextFrame() + firstBallOfNextFramesNextFrame();
      } else {
        bonus = firstBallOfNextFrame() + secondBallOfNextFrame();
      }
      return bonus;
    }

    private int spareBonus() {
      int bonus = 0;
      if (isTenthFrame()) {
        bonus = bonusBall();
      } else {
        bonus = firstBallOfNextFrame();
      }
      return bonus;
    }

    private int firstBall() {
      return frameRolls[0];
    }

    private int secondBall() {
      return frameRolls[1];
    }

    private int firstBallOfNextFrame() {
      return getNextFrame().firstBall();
    }

    private int secondBallOfNextFrame() {
      return getNextFrame().secondBall();
    }

    private int firstBallOfNextFramesNextFrame() {
      return getNextFrame().getNextFrame().firstBall();
    }

    private int bonusBall() {
      return frameRolls[2];
    }

    private boolean isTenthFrame() {
      return frameId == 10;
    }

    private boolean isNinthFrame() {
      return frameId == 9;
    }

    protected Frame getNextFrame() {
      return nextFrame;
    }

    protected void setNextFrame(Frame frame) {
      nextFrame = frame;
    }
  }
}