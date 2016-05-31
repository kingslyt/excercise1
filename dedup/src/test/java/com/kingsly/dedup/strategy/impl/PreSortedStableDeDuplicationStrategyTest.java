package com.kingsly.dedup.strategy.impl;

import org.junit.Test;

import com.kingsly.dedup.strategy.DeDuplicateStrategyBaseTest;

public class PreSortedStableDeDuplicationStrategyTest extends DeDuplicateStrategyBaseTest {

	public PreSortedStableDeDuplicationStrategyTest() {
		super(new PreSortedStableDeDuplicationStrategy());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeDuplicateStablyWithRequirementProvidedInput() {
		doTestStableDeDupRequirementProvidedInput();
	}

}
