package com.ford.bowling;

import static com.ford.bowling.test.GameFactory.newGame;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BowlingTests {

  private BowlingGame game;
  
  @Before
  public void beforeEach() {
    game = newGame();
  }
  
  private void createFrame(int frame, int...rolls) {
    game.createFrame(frame,rolls);  
  }
  
  @Test
  public void allGuttersIsZero() {
    for (int frame = 1; frame < 11; frame++) {
      createFrame(frame, 0, 0);
    }
    assertThat(game.getTotalScore(), is(0));
  }

  @Test
  public void allOnesIsTwenty() {
    for (int frame = 1; frame < 11; frame++) {
      createFrame(frame, 1, 1);
    }
    assertThat(game.getTotalScore(), is(20));
  }
}
