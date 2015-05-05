package com.ford.bowling;


public interface BowlingGame {

  Integer getTotalScore();

  void createFrame(int frame, int...roll);

}
