package com.kingsly.dedup.strategy.impl;

import java.util.ArrayList;
import java.util.List;

import com.kingsly.dedup.strategy.DeDuplicateStrategy;
import com.kingsly.dedup.utils.Utils;

public class PreSortedStableDeDuplicationStrategy extends DeDuplicateStrategy {

	public PreSortedStableDeDuplicationStrategy() {
		super();
	}

	@Override
	public boolean isStableDeDupping() {
		return true;
	}
	@Override
	public int[] deDuplicate(int[] input) {

		assert input != null;

		List<Integer> deDuppedList = new ArrayList<Integer>();
		int previousValue = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			int currentValue = input[i];
			if (i == 0) {
				previousValue = currentValue;
				deDuppedList.add(currentValue);
				continue;
			}
			if (currentValue == previousValue) {
				continue;
			} else if (currentValue < previousValue) {
				throw new IllegalArgumentException(
						"Input array is not naturally (ascending) sorted, consider using a different DeDup strategy!!");
			} else {
				previousValue = currentValue;
				deDuppedList.add(currentValue);
			}
		}
		return Utils.cast(deDuppedList);
	}

}
