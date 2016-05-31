package com.kingsly.dedup.strategy;

public abstract class DeDuplicateStrategy {
	public abstract int[] deDuplicate(int[] input);
	public abstract boolean isStableDeDupping();
}
