package com.java.basic.utils;

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
    }

}
