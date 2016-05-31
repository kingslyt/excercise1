package com.kingsly.dedup.utils;

import java.util.List;
import java.util.Set;

public class Utils {

	public static int[] cast(List<Integer> stablyDeDuppedList) {

		assert stablyDeDuppedList != null;

		int[] outputDeDuppedIntArray;
		int outputArrayLength = stablyDeDuppedList.size();
		outputDeDuppedIntArray = new int[outputArrayLength];

		for (int i = 0; i < outputArrayLength; i++) {
			outputDeDuppedIntArray[i] = stablyDeDuppedList.get(i);
		}
		
		return outputDeDuppedIntArray;
	}

	public static Integer[] cast(int[] randomInts) {

		assert randomInts != null;

		Integer[] inputRandomIntegers = new Integer[randomInts.length];
		for (int i = 0; i < randomInts.length; i++) {
			inputRandomIntegers[i] = new Integer(randomInts[i]);
		}
		return inputRandomIntegers;
	}

	public static int calculateInitialCapacityForFixedSizeMapUsingDefaultLoadFactorToAvoidRehashing(int length) {
		final double DEFAULT_HASHMAP_LOAD_FACTOR = 0.75D;
		return (int) (length / DEFAULT_HASHMAP_LOAD_FACTOR + 1);
	}

	public static int[] cast(Set<Integer> intArray) {

		assert intArray != null;

		int[] outputStablyDupRemovedInts = new int[intArray.size()];
		int index = 0;

		for (int currentElement : intArray) {
			outputStablyDupRemovedInts[index++] = currentElement;
		}
		return outputStablyDupRemovedInts;
	}
}
