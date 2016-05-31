package com.kingsly.dedup.strategy.set;

import java.util.Arrays;
import java.util.Set;

import com.kingsly.dedup.strategy.DeDuplicateStrategy;
import com.kingsly.dedup.utils.Utils;

public abstract class SetBasedDeDuplicationStrategy extends DeDuplicateStrategy {

	protected Set<Integer> integerSet;
	
	public SetBasedDeDuplicationStrategy(Set<Integer> set) {
		integerSet = set;
	}
	
	
	@Override
	public int[] deDuplicate(int[] input) {

		assert input != null;

		Integer[] inputRandomIntegers = Utils.cast(input);

		integerSet.clear();
		integerSet.addAll(Arrays.asList(inputRandomIntegers));

		int[] outputDupRemovedInts = Utils.cast(integerSet);

		return outputDupRemovedInts;

	}

}
