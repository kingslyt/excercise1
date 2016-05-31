package com.kingsly.dedup.strategy.set.impl;

import java.util.LinkedHashSet;

import com.kingsly.dedup.strategy.set.SetBasedDeDuplicationStrategy;

public class LinkedHashSetBasedStableDeDuplicationStrategy extends SetBasedDeDuplicationStrategy {
	public LinkedHashSetBasedStableDeDuplicationStrategy() {
		super(new LinkedHashSet<Integer>());
	}
	

	@Override
	public boolean isStableDeDupping() {
		return true;
	}

}
