package com.kingsly.dedup.strategy.impl;

import com.kingsly.dedup.strategy.DeDuplicateStrategy;

public class PreSortedNoCollectionStableDeDuplicationStrategy extends DeDuplicateStrategy {

	public PreSortedNoCollectionStableDeDuplicationStrategy() {
		super();
	}

	@Override
	public boolean isStableDeDupping() {
		return true;
	}
	@Override
	public int[] deDuplicate(int[] input) {

		assert input != null;

		int[] deDuppedIntArray = new int[input.length];
		int deDuppedIndex = 0;
		int previousValue = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			int currentValue = input[i];
			if (i == 0) {
				previousValue = currentValue;
				deDuppedIntArray[deDuppedIndex++] = currentValue;
				continue;
			}
			if (currentValue == previousValue) {
				continue;
			} else if (currentValue < previousValue) {
				throw new IllegalArgumentException(
						"Input array is not naturally (ascending) sorted, consider using a different DeDup strategy!!");
			} else {
				previousValue = currentValue;
				deDuppedIntArray[deDuppedIndex++] = currentValue;
			}
		}
		
		int[] trimmedDeDuppedIntArray = new int[deDuppedIndex];
		System.arraycopy(deDuppedIntArray, 0, trimmedDeDuppedIntArray, 0, deDuppedIndex);
		
		return trimmedDeDuppedIntArray;
	}

}
