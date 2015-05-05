package com.ford.bowling;

import static com.ford.bowling.test.GameFactory.newGame;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BowlingTests {

  @Test
  public void allGuttersIsZero() {
    BowlingGame game = newGame();
    for (int frame = 1; frame < 11; frame++) {
      game.createFrame(frame, 0, 0);
    }
    assertThat(game.getTotalScore(), is(0));
  }

  @Test
  public void allOnesIsTwenty() {
    BowlingGame game = newGame();
    for (int frame = 1; frame < 11; frame++) {
      game.createFrame(frame, 1, 1);
    }
    assertThat(game.getTotalScore(), is(20));
  }
}
