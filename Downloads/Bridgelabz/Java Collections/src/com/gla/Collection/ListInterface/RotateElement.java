package com.gla.Collection.ListInterface;
import java.util.*;

public class RotateElement {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int k = 2;

        int n = list.size();
        k = k % n; // handle k > n

        List<Integer> result = new ArrayList<>();

        // add from k to end
        for (int i = k; i < n; i++) {
            result.add(list.get(i));
        }

        // add from 0 to k-1
        for (int i = 0; i < k; i++) {
            result.add(list.get(i));
        }

        System.out.println(result);
    }
}
