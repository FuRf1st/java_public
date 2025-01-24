package com;

public class Main {
    public static void main(String[] args) {
        int maxN = 40;
        int[] nValues = new int[maxN];
        long[] classicTimes = new long[maxN];
        long[] memoizedTimes = new long[maxN];

        for (int n = 1; n <= maxN; n++) {
            nValues[n - 1] = n;

            long startClassic = System.nanoTime();
            FibonacciClassic.fibonacci(n);
            classicTimes[n - 1] = System.nanoTime() - startClassic;

            long startMemoized = System.nanoTime();
            FibonacciMemoized.fibonacci(n);
            memoizedTimes[n - 1] = System.nanoTime() - startMemoized;
        }

        ChartExample.displayChart(nValues, classicTimes, memoizedTimes);
    }
}
