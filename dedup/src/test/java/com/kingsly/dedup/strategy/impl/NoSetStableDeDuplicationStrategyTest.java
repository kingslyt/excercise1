package com.kingsly.dedup.strategy.impl;

import org.junit.Test;

import com.kingsly.dedup.strategy.DeDuplicateStrategyBaseTest;

public class NoSetStableDeDuplicationStrategyTest extends DeDuplicateStrategyBaseTest {

	public NoSetStableDeDuplicationStrategyTest() {
		super(new NoSetStableDeDuplicationStrategy());
	}

	@Test
	public void testDeDuplicateStablyWithRequirementProvidedInput() {
		doTestStableDeDupRequirementProvidedInput();
	}

}
