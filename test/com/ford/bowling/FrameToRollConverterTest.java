package com.ford.bowling;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class FrameToRollConverterTest {

	@Test
	public void verifyCanConvertOneFrameIntoTwoRolls() {
		List<Frame> frames = Lists.newArrayList(new Frame(1, 5, 3));
		FrameToRollConverter converter = new FrameToRollConverter();

		List<Integer> rolls = converter.convert(frames);

		assertThat(rolls).isEqualTo(Lists.newArrayList(5, 3));
	}

	@Test
	public void verifyCanConvertMultipleFramesIntoTwoRolls() {
		List<Frame> frames = Lists.newArrayList(new Frame(1, 5, 3), new Frame(2, 7, 1));
		FrameToRollConverter converter = new FrameToRollConverter();

		List<Integer> rolls = converter.convert(frames);

		assertThat(rolls).isEqualTo(Lists.newArrayList(5, 3, 7, 1));
	}

	@Test
	public void verifyCanConvertMultipleFramesAndTenthFrameWithThreeRollsIntoTwoRolls() {
		List<Frame> frames = Lists.newArrayList(new Frame(7, 5, 3), new Frame(8, 7, 1), new Frame(9, 4, 6), new Frame(
				10, 10, 5, 4));
		FrameToRollConverter converter = new FrameToRollConverter();

		List<Integer> rolls = converter.convert(frames);

		assertThat(rolls).isEqualTo(Lists.newArrayList(5, 3, 7, 1, 4, 6, 10, 5, 4));
	}

	@Test
	public void verifyCanConvertFramesWithStrikesIntoRolls() throws Exception {
		List<Frame> frames = Lists.newArrayList(new Frame(7, 10, null), new Frame(8, 8, 1), new Frame(9, 10, null));
		FrameToRollConverter converter = new FrameToRollConverter();

		List<Integer> rolls = converter.convert(frames);

		assertThat(rolls).isEqualTo(Lists.newArrayList(10, 0, 8, 1, 10, 0));
	}
	
	@Test
	public void verifyCanConvertFramesWithSparesIntoRolls() throws Exception {
		List<Frame> frames = Lists.newArrayList(new Frame(7, 9, 1), new Frame(8, 8, 1), new Frame(9, 8, 2));
		FrameToRollConverter converter = new FrameToRollConverter();

		List<Integer> rolls = converter.convert(frames);

		assertThat(rolls).isEqualTo(Lists.newArrayList(9, 1, 8, 1, 8,2));
	}

}
