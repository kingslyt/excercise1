package com.kingsly.dedup.strategy.set.stable.impl;

import org.junit.Test;

import com.kingsly.dedup.strategy.DeDuplicateStrategyBaseTest;
import com.kingsly.dedup.strategy.set.impl.LinkedHashSetBasedStableDeDuplicationStrategy;

public class LinkedHashSetBasedStableDeDuplicationStrategyTest extends DeDuplicateStrategyBaseTest {

	public LinkedHashSetBasedStableDeDuplicationStrategyTest() {
		super(new LinkedHashSetBasedStableDeDuplicationStrategy());
	}

	@Test
	public void testDeDuplicateStablyWithRequirementProvidedInput() {
		doTestStableDeDupRequirementProvidedInput();
	}

}
