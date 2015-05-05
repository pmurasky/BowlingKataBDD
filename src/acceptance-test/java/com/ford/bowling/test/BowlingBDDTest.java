package com.ford.bowling.test;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import com.ford.bowling.BowlingGame;

public class BowlingBDDTest {

  private BowlingGame game;

  @Before
  public void givenANewBowlingGame() {
    game = GameFactory.newGame();
  }

  private void thenTotalScoreShouldBe(int expectedScore) {
    assertThat(game.getTotalScore()).isEqualTo(expectedScore);
  }

  @Test
  public void whenABowlerRollsAGutterBallForEveryFrame() {
    for (int frame = 1; frame <= 10; frame++) {
      game.createFrame(frame);
    }
    thenTotalScoreShouldBe(0);
  }

  @Test
  public void whenABowlerRollsAStrikeForEveryFrame() {
    for (int frame = 1; frame <= 9; frame++) {
      game.createFrame(frame, 10);
    }
    game.createFrame(10, 10, 10, 10);
    thenTotalScoreShouldBe(300);
  }

  @Test
  public void whenABowlerRollsAOneForEveryFrameForFirstRoll() throws Exception {
    for (int frame = 1; frame <= 9; frame++) {
      game.createFrame(frame, 1);
    }
    game.createFrame(10, 1);
    thenTotalScoreShouldBe(10);
  }

  @Test
  public void whenABowlerRollsAOneForEveryFrameForFirstAndSecondRoll() throws Exception {
    for (int frame = 1; frame <= 9; frame++) {
      game.createFrame(frame, 1, 1);
    }
    game.createFrame(10, 1, 1);
    thenTotalScoreShouldBe(20);
  }
}
