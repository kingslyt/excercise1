package com.kingsly.dedup.strategy.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.kingsly.dedup.strategy.DeDuplicateStrategy;
import com.kingsly.dedup.strategy.DeDuplicateStrategyBaseTest;
import com.kingsly.dedup.strategy.set.impl.HashSetBasedUnStableDeDuplicationStrategy;
import com.kingsly.dedup.strategy.set.impl.LinkedHashSetBasedStableDeDuplicationStrategy;
import com.kingsly.dedup.strategy.set.impl.TreeSetBasedUnStableDeDuplicationStrategy;

@RunWith(Parameterized.class)
public class DeDuplicateMultipleStrategiesTest extends DeDuplicateStrategyBaseTest {

	public DeDuplicateMultipleStrategiesTest(DeDuplicateStrategy deDupStrategy) {
		super(deDupStrategy);
	}

	@Parameters
	public static List<Object[]> getParameterData() {
		return Arrays.asList(new Object[][] { { new NoSetStableDeDuplicationStrategy() },
				{ new PreSortedStableDeDuplicationStrategy() }, { new LinkedHashSetBasedStableDeDuplicationStrategy() },
				{ new PreSortedNoCollectionStableDeDuplicationStrategy() },
				{ new TreeSetBasedUnStableDeDuplicationStrategy() },
				{ new HashSetBasedUnStableDeDuplicationStrategy() } });
	}

	@Test
	public void testDeDuplicateStablyWithEmptyArray() {

		int[] inputRandomIntegers = new int[0];
		int[] expectedOutputDedupedIntegers = null;

		doTestDeDuplicated(inputRandomIntegers, expectedOutputDedupedIntegers);

	}

	@Test
	public void testDeDuplicateStablyWithSingleElementArray() {

		int[] inputRandomIntegers = { 1 };
		int[] expectedOutputDedupedIntegers = { 1 };

		doTestDeDuplicated(inputRandomIntegers, expectedOutputDedupedIntegers);

	}

	@Test
	public void testDeDuplicateStablyWithSingleRepeatedArray() {

		int[] inputRandomIntegers = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		int[] expectedOutputDedupedIntegers = { 1 };

		doTestDeDuplicated(inputRandomIntegers, expectedOutputDedupedIntegers);

	}

	@Test
	public void testDeDuplicateStablyWithPreSortedArray() {

		int[] inputRandomIntegers = { 1, 1, 22, 33, 33, 88, 88, 88, 221, 311, 311 };
		int[] expectedOutputDedupedIntegers = { 1, 22, 33, 88, 221, 311 };

		doTestDeDuplicated(inputRandomIntegers, expectedOutputDedupedIntegers);

	}

	@Test(expected = AssertionError.class)
	public void testDeDuplicateStablyWithNullInputs() {

		int[] inputRandomIntegers = null;
		int[] expectedOutputDedupedIntegers = null;

		doTestDeDuplicated(inputRandomIntegers, expectedOutputDedupedIntegers);

	}

}
