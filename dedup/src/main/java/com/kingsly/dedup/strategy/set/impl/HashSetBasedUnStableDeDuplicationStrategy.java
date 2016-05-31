package com.kingsly.dedup.strategy.set.impl;

import java.util.HashSet;

import com.kingsly.dedup.strategy.set.SetBasedDeDuplicationStrategy;

public class HashSetBasedUnStableDeDuplicationStrategy extends SetBasedDeDuplicationStrategy {
	public HashSetBasedUnStableDeDuplicationStrategy() {
		super(new HashSet<Integer>());
	}

	@Override
	public boolean isStableDeDupping() {
		return false;
	}
}
