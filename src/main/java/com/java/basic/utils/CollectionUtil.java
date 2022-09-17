package com.java.basic.utils;

import com.java.basic.entity.Person;

import java.util.*;
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

    /**
     * List的最大值
     */
    public static int maxValueOfList(List<Integer> list) {
        return list.stream().max(Comparator.comparingInt(o -> o)).orElse(0);
    }

    /**
     * List的并集、去重复并集、交集和差集
     */
    public static void unionAndDeduplicateUnionAndIntersectionAndDifferenceOfList() {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<>();
        list2.add("C");
        list2.add("B");
        list2.add("D");

        // 并集
        list1.addAll(list2);

        // 去重复并集
        list2.removeAll(list1);
        list1.addAll(list2);

        // 交集
        list1.retainAll(list2);

        // 差集
        list1.removeAll(list2);
    }

    /**
     * List的排序、求和、取最大值和按照条件过滤
     */
    public static void sortAndSumAndMaxAndFilterOfList() {
        Person p1 = new Person("麻子", 31, "");
        Person p2 = new Person("李四", 20, "");
        Person p3 = new Person("王五", 26, "");

        List<Person> personList = new ArrayList<Person>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        // 按照person的age进行排序
        personList.forEach(p -> System.out.println(p.getAge()));
        personList.sort(Comparator.comparing(Person::getAge)); // 正序
        personList.sort(Comparator.comparing(Person::getAge).reversed()); // 倒序
        personList.forEach(p -> System.out.println(p.getAge()));

        // 获取年龄最大的Person
        Person maxAgePerson = personList.stream().max(Comparator.comparing(Person::getAge)).get();
        System.out.println(maxAgePerson.getAge());

        // 获取年龄最小的Person
        Person minAgePerson = personList.stream().min(Comparator.comparing(Person::getAge)).get();
        System.out.println(minAgePerson.getAge());

        // 过滤出年龄是20的person，想过滤出什么条件的都可以
        List<Person> personList1 = personList.stream().filter(person -> person.getAge() == 20).collect(Collectors.toList());

        // 统计出年龄等于20的个数
        long count = personList.stream().filter(person -> person.getAge() == 20).count();

        // 获得年龄的平均值
        double asDouble = personList.stream().mapToInt(person -> person.getAge()).average().getAsDouble();

        // 获得年龄的求和
        int sum = personList.stream().mapToInt(person -> person.getAge()).sum();
    }

    /**
     * 集合中removeIf的使用
     */
    public static Collection<Person> collectionRemoveValue(Collection<Person> collection) {
        collection.removeIf(
                person -> person.getAge() >= 30
        );
        return collection;
    }


    static List<String> listString() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add(null);
        return list;
    }

    static List<Integer> listInteger() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        return list;
    }

    static Collection<Person> collectionPerson() {
        Collection<Person> collection = new ArrayList();
        collection.add(new Person("张三", 22, "男"));
        collection.add(new Person("李四", 19, "女"));
        collection.add(new Person("王五", 34, "男"));
        collection.add(new Person("赵六", 30, "男"));
        collection.add(new Person("田七", 25, "女"));
        return collection;
    }

    public static void main(String[] args) {
        System.out.println(CollectionUtil.listDistinct(Arrays.asList("1", "2", "2")));
        System.out.println(CollectionUtil.listFilerNull(CollectionUtil.listString()));
        System.out.println(CollectionUtil.listStringToInteger(Arrays.asList("1", "2", "3")));
        System.out.println(CollectionUtil.listToStringAddApostropheAndCommaSeparated(Arrays.asList("1", "2", "3")));
        System.out.println(Arrays.toString(CollectionUtil.listToArray(Arrays.asList("1", "2", "3"))));
        System.out.println(Arrays.toString(CollectionUtil.listToArrayByStream(Arrays.asList("1", "2", "3"))));
        System.out.println(CollectionUtil.listToStringAndCommaSeparated(Arrays.asList("Milan", "London", "New York", "San Francisco")));
        System.out.println(CollectionUtil.maxValueOfList(CollectionUtil.listInteger()));
        System.out.println(CollectionUtil.collectionRemoveValue(CollectionUtil.collectionPerson()));
    }

}
