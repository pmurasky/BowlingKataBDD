package com.ford.bowling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


public class FrameTest {
	
	@Test
	public void verifyFrameIsStrike() throws Exception {
		Frame frame = new Frame(1,10,null);
		
		assertThat(frame.isStrike()).isTrue();
		
	}
	
	@Test
	public void verifyFrameIsNotStrike() throws Exception {
		Frame frame = new Frame(1,4,3);
		
		assertThat(frame.isStrike()).isFalse();
	}
}
