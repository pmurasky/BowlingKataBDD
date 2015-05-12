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

    Frame(int frameNumber, int[] rolls) {
      frameId = frameNumber;
      System.arraycopy(rolls, 0, frameRolls, 0, Math.min(MAX_ROLLS_IN_FRAME, rolls.length));
    }

    int getScore() {
      int score = baseScore();
      if (isStrike()) {
        score += strikeBonus();
      }
      if (isSpare()) {
        score += spareBonus();
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
      return firstBall() == 10 && (isTenthFrame() || secondBall() == 0);
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
      if (isTenthFrame()) {
        bonus = bonusBall();
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