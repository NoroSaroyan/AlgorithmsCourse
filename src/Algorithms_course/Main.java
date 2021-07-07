package Algorithms_course;

import java.io.Console;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;


public class Main {

    public static int capacity = 1000000;

    public static void main(String[] args) {
       long start = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<>(capacity);
        list = initialize(list);
        print(list);
        System.out.println("---------------------------");
        sort(list);
        print(list);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Completed in " + time + "milliseconds");
   list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        testMinCapacity();
        testMaxCapacity();
        testDeleteNegative();
        testDeletePositive();
        testIndexAdd();
        testIndexAdd2();
        testGet();
        testContains();
        testInsertionSort();
        testSelectionSort();
        testBubbleSort();
    }

    public static void testMinCapacity() {

        try {
            MyArrayList<Integer> list = new MyArrayList<>(-1);
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().contains("capacity: -1")) {
                throw new RuntimeException("fail capacity", e);
            }
        }

    }

    public static void testMaxCapacity() {
        MyArrayList<Integer> list = new MyArrayList<>(1);
        list.add(1);

        try {
            list.add(2);
        } catch (Exception e) {
            throw new RuntimeException("fail capacity", e);

        }
    }

    public static void testDeletePositive() {
        MyArrayList<Integer> list = new MyArrayList<>(1);
        if (list.size() != 0) {
            throw new RuntimeException("Size should be empty");
        }

        list.add(1);
        if (list.size() != 1) {
            throw new RuntimeException("Size should be 1");
        }

        list.remove(0);
        if (list.size() != 0) {
            throw new RuntimeException("Size should be empty");
        }

        try {
            list.remove(10);
        } catch (NoSuchElementException expected) {

        }

    }

    public static void testDeleteNegative() {
        MyArrayList<Integer> list = new MyArrayList<>(1);
        list.add(1);
        try {
            list.remove(1);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            // ожидаемое исключение ;
        } catch (Exception e) {
            throw new RuntimeException("Unknown error ", e);
        }

    }

    public static void testIndexAdd() {
        MyArrayList<Integer> list = new MyArrayList<>(1);

        try {
            list.add(-1, 2);
        } catch (IndexOutOfBoundsException expected) {
        }

        try {
            list.add(1, 2);
        } catch (IndexOutOfBoundsException expected) {
        }

        list.add(0, 2);

    }

    public static void testIndexAdd2() {
        MyArrayList<Integer> list = new MyArrayList<>(2);

        list.add(1);
        list.add(1, 2);

        if (list.size() != 2) {
            throw new RuntimeException("Wrong Size");
        }
    }

    public static void testGet() {
        MyArrayList<Integer> list = new MyArrayList<>(1);
        list.add(1);
        try {
            list.get(1);
        } catch (IndexOutOfBoundsException expected) {
        }

        try {
            list.get(-1);
        } catch (IndexOutOfBoundsException expected) {
        }

        if (list.get(0) != 1) {
            throw new RuntimeException();
        }

    }

    public static void testContains() {
        MyArrayList<String> list = new MyArrayList<>(10);
        list.add("a");
        list.add("aa");
        list.add("aaa");
        list.add("aaaa");
        list.add("aaaaa");
        list.add("b");
        list.add("bb");
        list.add("bbb");
        list.add("bbbb");
        list.add("bbbbb");

        if (!list.contains("a")) {
            throw new RuntimeException();
        }
        if (list.contains("c")) {
            throw new RuntimeException("");
        }
    }

    public static void testInsertionSort() {
        MyArrayList<Integer> list = new MyArrayList<>(10);
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(0);
        list.add(6);
        list.add(7);
        list.add(5);
        list.add(3);

        list.insertionSort();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                throw new RuntimeException();
            }
        }
    }

    public static void testSelectionSort() {
        MyArrayList<Integer> list = new MyArrayList<>(10);
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(0);
        list.add(6);
        list.add(7);
        list.add(5);
        list.add(3);

        list.selectionSort();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                throw new RuntimeException();
            }
        }
    }

    public static void testBubbleSort() {
        MyArrayList<Integer> list = new MyArrayList<>(10);
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(0);
        list.add(6);
        list.add(7);
        list.add(5);
        list.add(3);

        list.bubbleSort();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                throw new RuntimeException();
            }
        }
    }

    public static ArrayList<Integer> initialize(ArrayList<Integer> list) {
        Random rnd = new Random();
        for (int i = 0; i < capacity; i++) {
            list.add(i, rnd.nextInt(1999999999));
        }
        return list;
    }

    public static void print(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(i) > list.get(j)) {

                    int tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }
}
