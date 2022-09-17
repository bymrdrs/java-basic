package com.java.basic.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapUtil {

    /**
     * 高效的遍历Map
     */
    public static void mapForeach() {
        System.out.println("\n通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : MapUtil.map().entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }

    /**
     * 基于Lambda的for循环
     */
    public static void mapLambdaForeach() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "张三");
        map.put("2", "李四");
        map.put("3", "王五");
        map.forEach((k, v) -> System.out.println(k + "--------" + v));
    }

    /**
     * 基于Lambda的for循环
     */
    public static void listMapLambdaForeach() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "张三");
        map.put("2", "李四");
        map.put("3", "王五");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("4", "德玛西亚");
        map2.put("5", "索瑞玛");
        map2.put("6", "艾欧尼亚");
        ArrayList<Map> list1 = new ArrayList<>();
        list1.add(map);
        list1.add(map2);
        list1.forEach(map1 -> {
            map1.forEach((k, v) -> System.out.println(v));
        });
        System.out.println("-----分割线------");
        list1.forEach(map1 -> {
            map1.forEach((k, v) -> System.out.println(k + "----" + v));
        });
    }

    static Map<String, String> map() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        map.put("4", "value4");
        return map;
    }

    public static void main(String[] args) {
        MapUtil.mapForeach();
        MapUtil.mapLambdaForeach();
        MapUtil.listMapLambdaForeach();
    }

}
