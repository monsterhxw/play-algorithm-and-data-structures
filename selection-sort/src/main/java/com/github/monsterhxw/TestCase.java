package com.github.monsterhxw;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-12-21
 */
public class TestCase {

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        Student[] students = {new Student("Alice", 98), new Student("Bobo", 100), new Student("Charles", 66)};

        SelectionSort.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
