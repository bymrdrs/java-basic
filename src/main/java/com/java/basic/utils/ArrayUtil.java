package com.java.basic.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayUtil {

    /**
     * 删除数组中的NULL元素
     */
    public static String[] arrayDeleteNull(String[] strings) {
        return Arrays.stream(strings).filter(s -> (s != null && s.length() > 0)).toArray(String[]::new);
    }

    /**
     * String[] -> int[]
     */
    public static int[] arrayIntToString(String[] strings) {
        return Arrays.stream(strings).mapToInt(Integer::valueOf).toArray();
    }

    /**
     * int[] -> Integer[]
     */
    public static Integer[] arrayIntToInteger(int[] ints) {
        IntStream stream = Arrays.stream(ints); // 先将int数组转换为数值流
        Stream<Integer> integerStream = stream.boxed(); // 流中的元素全部装箱，转换为流 -> int转为Integer
        return integerStream.toArray(Integer[]::new);
    }

    /**
     * 数组去重
     */
    public static Integer[] arrayDistinct(int[] ints) {
        IntStream stream = Arrays.stream(ints);
        Stream<Integer> integerStream = stream.distinct().boxed();
        return integerStream.toArray(Integer[]::new);
    }

    /**
     * 判断数组中是否包含某个元素
     */
    public static Boolean arrayContains(String[] strings, String targetValue) {
        return Arrays.asList(strings).contains(targetValue);
    }

    /**
     * Array转换为List
     */
    public static List<String> arrayToList(String[] strings) {
        return Arrays.asList(strings);
    }

    /**
     * Array转换为List 流
     */
    public static List<String> arrayToListByStream(String[] strings) {
        return Stream.of(strings).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ArrayUtil.arrayDeleteNull(new String[]{"test1", "", "test2", "test4", "", null})));
        System.out.println(Arrays.toString(ArrayUtil.arrayIntToString(new String[]{"1", "2", "3"})));
        System.out.println(Arrays.toString(ArrayUtil.arrayIntToInteger(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(ArrayUtil.arrayDistinct(new int[]{1, 2, 3, 3})));
        System.out.println(ArrayUtil.arrayContains(new String[]{"1", "2", "3"}, "2"));
        System.out.println(ArrayUtil.arrayToList(new String[]{"a", "b", "c"}));
        System.out.println(ArrayUtil.arrayToListByStream(new String[]{"a", "b", "c"}));
    }

}
