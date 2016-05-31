package com.kingsly.dedup.strategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.internal.ArrayComparisonFailure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeDuplicateStrategyBaseTest {
	private final Logger logger = LoggerFactory.getLogger(DeDuplicateStrategyBaseTest.class);

	private final int[] requirementProvidedRandomInputArray = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43,
			2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18,
			10, 14, 20, 17, 16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14,
			13, 2, 11 };
	private final int[] expectedStablyDeDupedIntegerArrayForRequirementProvidedInput = { 1, 2, 34, 25, 45, 3, 26, 85, 4,
			86, 43, 10000, 11, 16, 19, 18, 9, 20, 17, 8, 15, 6, 5, 10, 14, 12, 13, 7 };

	private DeDuplicateStrategy deDupStrategy;

	public DeDuplicateStrategyBaseTest(DeDuplicateStrategy deDupStrategy) {
		this.deDupStrategy = deDupStrategy;
	}

	protected void doTestDeDuplicated(int[] inputRandomIntegers, int[] expectedOutputDedupedIntegers)
			throws ArrayComparisonFailure {
		int[] duplicateRemovedIntegerArray = deDupStrategy.deDuplicate(inputRandomIntegers);

		checkDeDuplicated(duplicateRemovedIntegerArray);

		if (deDupStrategy.isStableDeDupping()) {
			checkStable(inputRandomIntegers, duplicateRemovedIntegerArray);
		}

		if (expectedOutputDedupedIntegers != null) {
			if (deDupStrategy.isStableDeDupping()) {
				Assert.assertArrayEquals("Does not match", expectedOutputDedupedIntegers, duplicateRemovedIntegerArray);
			} else {
				Assert.assertEquals("Length does not match", expectedOutputDedupedIntegers.length,
						duplicateRemovedIntegerArray.length);
				checkAllElementsMatch(expectedOutputDedupedIntegers, duplicateRemovedIntegerArray);
			}
		}
	}

	private void checkAllElementsMatch(int[] expectedOutputDedupedIntegers, int[] duplicateRemovedIntegerArray) {
		setDifferenceLeftHandSideMinusRightHandSide(expectedOutputDedupedIntegers, duplicateRemovedIntegerArray);
		setDifferenceLeftHandSideMinusRightHandSide(duplicateRemovedIntegerArray, expectedOutputDedupedIntegers);

	}

	private void setDifferenceLeftHandSideMinusRightHandSide(int[] lhs, int[] rhs) {
		Map<Integer, Integer> expectedIntMap = new HashMap<Integer, Integer>();
		for (Integer currentValue : lhs) {
			expectedIntMap.put(currentValue, currentValue);
		}
		for (Integer currentValue : rhs) {
			expectedIntMap.remove(currentValue);
		}
		if (expectedIntMap.size() != 0) {
			logger.error(new StringBuilder("lhs=").append(Arrays.toString(lhs)).toString());
			logger.error(new StringBuilder("rhs=").append(Arrays.toString(rhs)).toString());
			logger.error(new StringBuilder("Set difference, lhs - rhs = {")
					.append(Arrays.toString(expectedIntMap.keySet().toArray())).append("}").toString());
			Assert.fail("Array contents do not match (see error log for details)");

		}
	}

	protected void doTestStableDeDupRequirementProvidedInput() {
		doTestDeDuplicated(requirementProvidedRandomInputArray,
				expectedStablyDeDupedIntegerArrayForRequirementProvidedInput);
	}

	private void checkDeDuplicated(int[] deDuppedArray) {
		int inputLength = deDuppedArray.length;
		Map<Integer, Integer> elementEncounteredMap = new HashMap<Integer, Integer>();
		for (int inputIndex = 0; inputIndex < inputLength; inputIndex++) {
			int currentInt = deDuppedArray[inputIndex];
			if (elementEncounteredMap.get(currentInt) == null) {
				elementEncounteredMap.put(currentInt, currentInt);
			} else {
				logger.error(new StringBuilder("input array : ").append(Arrays.toString(deDuppedArray)).toString());
				Assert.fail(new StringBuilder("Element ").append(currentInt).append(" is duplicated at index : ")
						.append(inputIndex).toString());
			}
		}
	}

	private void checkStable(int[] inputIntArray, int[] outputDuplicateRemovedIntArray) {
		int inputLength = inputIntArray.length;
		Map<Integer, Integer> elementEncounteredMap = new HashMap<Integer, Integer>();
		for (int inputIndex = 0, outputIndex = 0; inputIndex < inputLength; inputIndex++) {
			int currentInt = inputIntArray[inputIndex];
			if (elementEncounteredMap.get(currentInt) == null) {
				elementEncounteredMap.put(currentInt, currentInt);
				if (inputIntArray[inputIndex] != outputDuplicateRemovedIntArray[outputIndex]) {
					Assert.fail(new StringBuilder("Element ").append(outputDuplicateRemovedIntArray[outputIndex])
							.append(" in the output array at index [").append(outputIndex)
							.append("] is out of position, expected element ").append(inputIntArray[inputIndex])
							.toString());
				}
				outputIndex++;
			}
		}

	}

}
