package com.ford.bowling;

import java.util.ArrayList;
import java.util.List;

public class FrameToRollConverter {

	public List<Integer> convert(List<Frame> frames) {
		List<Integer> rolls = new ArrayList<Integer>();
		for (Frame frame : frames) {
			if (frame.getFrameNumber() == 10) {
				if (frame.isStrike()) {
					rolls.add(frame.getRoll1());
					rolls.add(frame.getRoll2());
					rolls.add(frame.getRoll3());
				} else {
					rolls.add(frame.getRoll1());
					rolls.add(frame.getRoll2());
				}
			} else {
				rolls.add(frame.getRoll1());
				rolls.add(frame.getRoll2());
			}

		}
		return rolls;
	}

}
