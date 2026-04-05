package com.gla.wrapperclasses;
import java.util.ArrayList;

public class WrapperVsPrimitiveBenchmark {

    public static void main(String[] args) {
        final int SIZE = 1_000_000;

        // ----------------------------
        // Benchmark int[] (primitive)
        // ----------------------------
        int[] primitiveArray = new int[SIZE];

        long startPrimitiveFill = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            primitiveArray[i] = i;
        }
        long endPrimitiveFill = System.nanoTime();

        long startPrimitiveSum = System.nanoTime();
        long sumPrimitive = 0;
        for (int i = 0; i < SIZE; i++) {
            sumPrimitive += primitiveArray[i];
        }
        long endPrimitiveSum = System.nanoTime();

        // ----------------------------
        // Benchmark ArrayList<Integer> (wrapper)
        // ----------------------------
        ArrayList<Integer> wrapperList = new ArrayList<>(SIZE);

        long startWrapperFill = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            wrapperList.add(i); // autoboxing int -> Integer
        }
        long endWrapperFill = System.nanoTime();

        long startWrapperSum = System.nanoTime();
        long sumWrapper = 0;
        for (Integer value : wrapperList) {
            sumWrapper += value; // auto-unboxing Integer -> int
        }
        long endWrapperSum = System.nanoTime();

        // ----------------------------
        // Print results
        // ----------------------------
        System.out.println("Primitive array fill time: " + (endPrimitiveFill - startPrimitiveFill) / 1_000_000.0 + " ms");
        System.out.println("Primitive array sum time: " + (endPrimitiveSum - startPrimitiveSum) / 1_000_000.0 + " ms");
        System.out.println("ArrayList<Integer> fill time: " + (endWrapperFill - startWrapperFill) / 1_000_000.0 + " ms");
        System.out.println("ArrayList<Integer> sum time: " + (endWrapperSum - startWrapperSum) / 1_000_000.0 + " ms");
    }
}

