package com.kingsly.dedup.strategy.set.impl;

import java.util.TreeSet;

import com.kingsly.dedup.strategy.set.SetBasedDeDuplicationStrategy;

public class TreeSetBasedUnStableDeDuplicationStrategy extends SetBasedDeDuplicationStrategy {
	public TreeSetBasedUnStableDeDuplicationStrategy() {
		super(new TreeSet<Integer>());
	}

	@Override
	public boolean isStableDeDupping() {
		return false;
	}
}
