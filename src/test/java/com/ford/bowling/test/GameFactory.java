package com.ford.bowling.test;

import com.ford.bowling.BowlingGame;
import com.ford.bowling.RichsBowlingGame;

public class GameFactory {

  public static BowlingGame newGame() {
    return new RichsBowlingGame();
  }

}
