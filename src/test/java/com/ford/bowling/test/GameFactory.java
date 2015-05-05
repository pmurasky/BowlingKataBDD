package com.ford.bowling.test;

import com.ford.bowling.BowlingGame;

public class GameFactory {

  public static BowlingGame newGame() {
    return new BowlingGame() {

      @Override
      public Integer getTotalScore() {
        return Integer.valueOf(0);
      }

      @Override
      public void createFrame(int frame, int... roll) {
      }
    };
  }

}
