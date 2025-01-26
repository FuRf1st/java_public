package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeCalculator {

    // Метод с использованием Work Stealing
    public static List<Integer> findPrimesWorkStealing(int start, int end) throws InterruptedException, ExecutionException {
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newWorkStealingPool(numThreads);
        
        List<Future<List<Integer>>> futures = new ArrayList<>();
        int rangeSize = (end - start) / numThreads;
        
        for (int i = 0; i < numThreads; i++) {
            int rangeStart = start + i * rangeSize;
            int rangeEnd = (i == numThreads - 1) ? end : rangeStart + rangeSize;
            futures.add(executor.submit(() -> {
                List<Integer> primes = new ArrayList<>();
                for (int n = rangeStart; n < rangeEnd; n++) {
                    if (PrimeUtils.isPrime(n)) {
                        primes.add(n);
                    }
                }
                return primes;
            }));
        }
        
        List<Integer> primes = new ArrayList<>();
        for (Future<List<Integer>> future : futures) {
            primes.addAll(future.get());
        }

        executor.shutdown();
        return primes;
    }

    // Метод с равномерным распределением после перемешивания (shuffle)
    public static List<Integer> findPrimesShuffle(int start, int end) throws InterruptedException, ExecutionException {
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        
        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i < end; i++) {
            numbers.add(i);
        }
        
        Collections.shuffle(numbers);
        
        List<Future<List<Integer>>> futures = new ArrayList<>();
        int rangeSize = numbers.size() / numThreads;
        
        for (int i = 0; i < numThreads; i++) {
            int rangeStart = i * rangeSize;
            int rangeEnd = (i == numThreads - 1) ? numbers.size() : rangeStart + rangeSize;
            futures.add(executor.submit(() -> {
                List<Integer> primes = new ArrayList<>();
                for (int n = rangeStart; n < rangeEnd; n++) {
                    if (PrimeUtils.isPrime(numbers.get(n))) {
                        primes.add(numbers.get(n));
                    }
                }
                return primes;
            }));
        }
        
        List<Integer> primes = new ArrayList<>();
        for (Future<List<Integer>> future : futures) {
            primes.addAll(future.get());
        }

        executor.shutdown();
        return primes;
    }
}
