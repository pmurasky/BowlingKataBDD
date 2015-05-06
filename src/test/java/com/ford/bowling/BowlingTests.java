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

  private void createFrame(int frame, int... rolls) {
    game.createFrame(frame, rolls);
  }

  private void createFrames(int count, int startingFrame, int... rolls) {
    for (int frame = startingFrame; frame < startingFrame + count; frame++) {
      createFrame(frame, rolls);
    }
  }

  private void assertThatScoreIs(Integer expected) {
    assertThat(game.getTotalScore(), is(expected));
  }

  @Test
  public void allGuttersIsZero() {
    createFrames(10, 1, 0, 0);
    assertThatScoreIs(0);
  }

  @Test
  public void allOnesIsTwenty() {
    createFrames(10, 1, 1, 1);
    assertThatScoreIs(20);
  }

  @Test
  public void oneStrikeIsTen() {
    createFrame(1, 10);
    createFrames(9, 2);
    assertThatScoreIs(10);
  }

  @Test
  public void twoStrikesIsThirty() {
    createFrames(2, 1, 10);
    createFrames(8, 3);
    assertThatScoreIs(30);
  }

  @Test
  public void threeStrikesIsSixty() {
    createFrames(3, 1, 10);
    createFrames(7, 4);
    assertThatScoreIs(60);
  }
}
