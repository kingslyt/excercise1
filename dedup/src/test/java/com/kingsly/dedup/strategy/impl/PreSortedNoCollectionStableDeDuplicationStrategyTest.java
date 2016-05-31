package com.kingsly.dedup.strategy.impl;

import org.junit.Test;

import com.kingsly.dedup.strategy.DeDuplicateStrategyBaseTest;

public class PreSortedNoCollectionStableDeDuplicationStrategyTest extends DeDuplicateStrategyBaseTest {

	public PreSortedNoCollectionStableDeDuplicationStrategyTest() {
		super(new PreSortedNoCollectionStableDeDuplicationStrategy());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeDuplicateStablyWithRequirementProvidedInput() {
		doTestStableDeDupRequirementProvidedInput();
	}

}
