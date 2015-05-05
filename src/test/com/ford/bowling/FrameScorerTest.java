package com.ford.bowling;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;

public class FrameScorerTest {

	@Test
	public void canCalculateFrameBaseScoreNoStrikesOrSpares() throws Exception {
		List<Frame> frames = newArrayList(new Frame(1, 3, 5),
				new Frame(2, 7, 0));

		FrameScorer frameScorer = new FrameScorer(frames);
		frameScorer.calculateFrameScores();

		assertThat(frames.get(0).getBaseScore()).isEqualTo(8);
		assertThat(frames.get(1).getBaseScore()).isEqualTo(7);
	}

	@Test
	public void canCalculateFramesScoreWithStrike() throws Exception {
		List<Frame> frames = newArrayList(new Frame(1, 3, 5), new Frame(2, 10,
				null), new Frame(3, 6, 1));

		FrameScorer frameScorer = new FrameScorer(frames);
		frameScorer.calculateFrameScores();

		assertThat(frames.get(0).getFrameTotalScore()).isEqualTo(8);
		assertThat(frames.get(1).getFrameTotalScore()).isEqualTo(17);
		assertThat(frames.get(2).getFrameTotalScore()).isEqualTo(7);
	}

	@Test
	public void canCalculateFramesScoreWithTwoStrikesInARow() throws Exception {
		List<Frame> frames = newArrayList(new Frame(1, 3, 5), new Frame(2, 10,
				null), new Frame(3, 10, null), new Frame(4, 3, 1));

		FrameScorer frameScorer = new FrameScorer(frames);
		frameScorer.calculateFrameScores();

		assertThat(frames.get(0).getFrameTotalScore()).isEqualTo(8);
		assertThat(frames.get(1).getFrameTotalScore()).isEqualTo(23);
		assertThat(frames.get(2).getFrameTotalScore()).isEqualTo(14);
		assertThat(frames.get(3).getFrameTotalScore()).isEqualTo(4);
	}

	@Test
	public void canCalculateFramesScoreWithThreeStrikesInARow()
			throws Exception {
		List<Frame> frames = newArrayList(new Frame(1, 3, 5), new Frame(2, 10,
				null), new Frame(3, 10, null), new Frame(4, 10, null),
				new Frame(5, 3, 1));

		FrameScorer frameScorer = new FrameScorer(frames);
		frameScorer.calculateFrameScores();

		assertThat(frames.get(0).getFrameTotalScore()).isEqualTo(8);
		assertThat(frames.get(1).getFrameTotalScore()).isEqualTo(30);
		assertThat(frames.get(2).getFrameTotalScore()).isEqualTo(23);
		assertThat(frames.get(3).getFrameTotalScore()).isEqualTo(14);
		assertThat(frames.get(4).getFrameTotalScore()).isEqualTo(4);
	}

	@Test
	public void canCalculateFramesScoreWithFourStrikesInARow() throws Exception {
		List<Frame> frames = newArrayList(new Frame(1, 3, 5), new Frame(2, 10,
				null), new Frame(3, 10, null), new Frame(4, 10, null),
				new Frame(5, 10, null), new Frame(6, 3, 1));

		FrameScorer frameScorer = new FrameScorer(frames);
		frameScorer.calculateFrameScores();

		assertThat(frames.get(0).getFrameTotalScore()).isEqualTo(8);
		assertThat(frames.get(1).getFrameTotalScore()).isEqualTo(30);
		assertThat(frames.get(2).getFrameTotalScore()).isEqualTo(30);
		assertThat(frames.get(3).getFrameTotalScore()).isEqualTo(23);
		assertThat(frames.get(4).getFrameTotalScore()).isEqualTo(14);
		assertThat(frames.get(5).getFrameTotalScore()).isEqualTo(4);
	}

	@Test
	public void canCalculateFramesScoreWithSpare() throws Exception {
		List<Frame> frames = newArrayList(new Frame(1, 3, 5),
				new Frame(2, 4, 6), new Frame(3, 6, 1));

		FrameScorer frameScorer = new FrameScorer(frames);
		frameScorer.calculateFrameScores();

		assertThat(frames.get(0).getFrameTotalScore()).isEqualTo(8);
		assertThat(frames.get(1).getFrameTotalScore()).isEqualTo(16);
		assertThat(frames.get(2).getFrameTotalScore()).isEqualTo(7);
	}

	@Test
	public void canCalculateFramesScoreWhenBowlerThrowsGutter() throws Exception {
		List<Frame> frames = newArrayList(new Frame(1, 3, 5),
				new Frame(2, 4, 6), new Frame(3, 0, 10), new Frame(4, 2, 5));

		FrameScorer frameScorer = new FrameScorer(frames);
		frameScorer.calculateFrameScores();

		assertThat(frames.get(0).getFrameTotalScore()).isEqualTo(8);
		assertThat(frames.get(1).getFrameTotalScore()).isEqualTo(10);
		assertThat(frames.get(2).getFrameTotalScore()).isEqualTo(12);
		assertThat(frames.get(3).getFrameTotalScore()).isEqualTo(7);
	}
	
	@Test
	public void canCalculateFramesScoreWithTwoSpares() throws Exception {
		List<Frame> frames = newArrayList(new Frame(1, 3, 5),
				new Frame(2, 4, 6), new Frame(3, 5, 5), new Frame(4, 2, 5));

		FrameScorer frameScorer = new FrameScorer(frames);
		frameScorer.calculateFrameScores();

		assertThat(frames.get(0).getFrameTotalScore()).isEqualTo(8);
		assertThat(frames.get(1).getFrameTotalScore()).isEqualTo(15);
		assertThat(frames.get(2).getFrameTotalScore()).isEqualTo(12);
		assertThat(frames.get(3).getFrameTotalScore()).isEqualTo(7);
	}

	@Test
	public void canCalculateFramesScoreWithStrikeRolledInTenthFrame()
			throws Exception {
		List<Frame> frames = newArrayList(new Frame(1, 1, 1),
				new Frame(2, 1, 1), new Frame(3, 1, 1), new Frame(4, 1, 1),
				new Frame(5, 1, 1), new Frame(6, 1, 1), new Frame(7, 1, 1),
				new Frame(8, 1, 1), new Frame(9, 1, 1),
				new Frame(10, 10, 4, 2));
		
		FrameScorer frameScorer = new FrameScorer(frames);
		frameScorer.calculateFrameScores();

		assertThat(frames.get(9).getFrameTotalScore()).isEqualTo(16);
	}
	
	@Test
	public void canCalculateFramesScoreWithSpareRolledInTenthFrame()
			throws Exception {
		List<Frame> frames = newArrayList(new Frame(1, 1, 1),
				new Frame(2, 1, 1), new Frame(3, 1, 1), new Frame(4, 1, 1),
				new Frame(5, 1, 1), new Frame(6, 1, 1), new Frame(7, 1, 1),
				new Frame(8, 1, 1), new Frame(9, 1, 1),
				new Frame(10, 6, 4, 4));
		
		FrameScorer frameScorer = new FrameScorer(frames);
		frameScorer.calculateFrameScores();

		assertThat(frames.get(9).getFrameTotalScore()).isEqualTo(14);
	}

}
