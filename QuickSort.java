package com.anuj.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Anuj
 * @source goldenpackagebyanuj.blogspot.com
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        List<Integer> input = quickSort.generateRandomNumbers(10);

        System.out.println("Before Sorting : " + input);
        System.out.println("After Sorting : " + quickSort.quickSort(input));
    }

    private List<Integer> generateRandomNumbers(int n) {
        List<Integer> input = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            input.add(random.nextInt(n * 10));
        }
        return input;
    }

    private List<Integer> quickSort(List<Integer> input) {
        if (input.size() <= 1) {
            return input;
        }

        int middle = (int) Math.ceil((double) input.size() / 2);
        int pivot = input.get(middle);

        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) <= pivot) {
                if (i == middle) {
                    continue;
                }
                less.add(input.get(i));
            } else {
                greater.add(input.get(i));
            }
        }

        return concate(quickSort(less), pivot, quickSort(greater));
    }

    private List<Integer> concate(List<Integer> less, int pivot, List<Integer> greater) {
        List<Integer> list = new ArrayList<>();

        for (Integer i : less) {
            list.add(i);
        }
        /*less.stream().forEach((i) -> {
            list.add(i);
        });*/
        list.add(pivot);
        for (Integer j : greater) {
            list.add(j);
        }
        /*greater.stream().forEach((j) -> {
            list.add(j);
        });*/

        return list;
    }
}
