package com.kingsly.dedup.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kingsly.dedup.strategy.DeDuplicateStrategy;
import com.kingsly.dedup.utils.Utils;

public class NoSetStableDeDuplicationStrategy extends DeDuplicateStrategy {

	public NoSetStableDeDuplicationStrategy() {
		super();
	}

	@Override
	public boolean isStableDeDupping() {
		return true;
	}

	@Override
	public int[] deDuplicate(int[] input) {
		assert input != null;

		List<Integer> stablyDeDuppedList = deDupStablyUsingMapAndList(input);
		return Utils.cast(stablyDeDuppedList);
	}

	private List<Integer> deDupStablyUsingMapAndList(int[] randomInts) {
		int inputArrayLength = randomInts.length;
		List<Integer> stablingList = new ArrayList<Integer>(inputArrayLength);
		Map<Integer, Integer> duplicateDetectorMap = new HashMap<Integer, Integer>(
				Utils.calculateInitialCapacityForFixedSizeMapUsingDefaultLoadFactorToAvoidRehashing(inputArrayLength));
		for (int currentElement : randomInts) {
			if (notDuplicate(duplicateDetectorMap, currentElement)) {
				stablingList.add(currentElement);
				duplicateDetectorMap.put(currentElement, currentElement);
			}
		}
		return stablingList;
	}

	private boolean notDuplicate(Map<Integer, Integer> elementEncounteredMap, int currentElement) {
		return elementEncounteredMap.get(currentElement) == null;
	}

}
