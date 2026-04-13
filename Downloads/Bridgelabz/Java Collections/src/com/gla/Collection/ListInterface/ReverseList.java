package com.gla.Collection.ListInterface;
import java.util.*;

public class ReverseList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            // swap
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }

        System.out.println(list);
    }
}

