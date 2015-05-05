package com.ford.bowling;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;


public class FrameTest {
	
	@Test
	public void canCalculateBaseFrameScore() throws Exception {
		Frame frame = new Frame(1,3,2);
		
		frame.calculateBaseFrameScore();
		
		assertThat(frame.getFrameTotalScore()).isEqualTo(5);
	}
	
	@Test
	public void canVerifyAStrikeWasRolled() throws Exception {
		Frame frame = new Frame(1,10,null);
		
		assertThat(frame.isStrike()).isTrue();
	}
	
	@Test
	public void canVerifyaStrikeWasNotRolled() throws Exception {
		Frame frame = new Frame(1,3,2);
		
		assertThat(frame.isStrike()).isFalse();
	}
	
	@Test
	public void canVerifyASpareWasRolled() throws Exception {
		Frame frame = new Frame(1,4,6);
		frame.calculateBaseFrameScore();
		
		assertThat(frame.isSpare()).isTrue();
	}
	
	@Test
	public void canVerifyASpareWasNotRolled() throws Exception {
		Frame frame = new Frame(1,4,5);
		
		assertThat(frame.isSpare()).isFalse();
	}

}
