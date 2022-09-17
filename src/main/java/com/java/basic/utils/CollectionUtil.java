package com.java.basic.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtil {

    /**
     * List集合去重
     */
    public static List<?> listDistinct(List<?> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 去除List集合中的null元素
     */
    public static List<?> listFilerNull(List<?> list) {
        list.removeAll(Collections.singleton(null));
        return list;
    }

    /**
     * List<String> -> List<Integer>
     */
    public static List<Integer> listStringToInteger(List<String> list) {
        return list.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    /**
     * List中的每个元素都加上单引号并用逗号隔开
     */
    public static String listToStringAddApostropheAndCommaSeparated(List<String> list) {
        return list.stream().map(s -> "\'" + s + "\'").collect(Collectors.joining(","));
    }

    /**
     * List的并集、去重复并集、交集和差集
     */
    public static void listUnionAndDeduplicateUnionAndIntersectionAndDifference() {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<>();
        list2.add("C");
        list2.add("B");
        list2.add("D");

        list1.addAll(list2); // 并集

        list2.removeAll(list1); // 去重复并集
        list1.addAll(list2);

        list1.retainAll(list2); // 交集

        list1.removeAll(list2); // 差集
    }

    /**
     * List转换为Array
     */
    public static String[] listToArray(List<String> list) {
        return list.toArray(new String[list.size()]);
    }

    /**
     * List转换为Array Stream
     */
    public static String[] listToArrayByStream(List<String> list) {
        return list.stream().toArray(String[]::new);
    }

    /**
     * List转换为逗号分隔的字符串
     */
    public static String listToStringAndCommaSeparated(List<String> list) {
        return String.join(",", list);
    }

    public static void main(String[] args) {
        System.out.println(CollectionUtil.listDistinct(Arrays.asList("1", "2", "2")));
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add(null);
        System.out.println(CollectionUtil.listFilerNull(list));
        System.out.println(CollectionUtil.listStringToInteger(Arrays.asList("1", "2", "3")));
        System.out.println(CollectionUtil.listToStringAddApostropheAndCommaSeparated(Arrays.asList("1", "2", "3")));
        System.out.println(Arrays.toString(CollectionUtil.listToArray(Arrays.asList("1", "2", "3"))));
        System.out.println(Arrays.toString(CollectionUtil.listToArrayByStream(Arrays.asList("1", "2", "3"))));
        System.out.println(CollectionUtil.listToStringAndCommaSeparated(Arrays.asList("Milan", "London", "New York", "San Francisco")));
    }

}
