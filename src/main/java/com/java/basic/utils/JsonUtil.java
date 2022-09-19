package com.java.basic.utils;

import com.java.basic.entity.Person;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.Iterator;
import java.util.List;

public class JsonUtil {

    /**
     * Json转对象List
     */
    public static List<Person> jsonToObjectList(String jsonString) {
        JSONObject jsonobject = JSONObject.fromObject(jsonString);
        JSONObject aggregations = (JSONObject) jsonobject.get("aggregations");
        JSONObject groupDate = (JSONObject) aggregations.get("groupDate");
        String buckets = groupDate.getString("buckets");
        JSONArray bucketsJsonArray = JSONArray.fromObject(buckets);
        // 参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
        List<Person> bucketsList = JSONArray.toList(bucketsJsonArray, new Person(), new JsonConfig());
        return bucketsList;
    }

    /**
     * JSONObject遍历Key
     */
    @SuppressWarnings("unchecked")
    public static void jsonForeachKey(String jsonString) {
        JSONObject jsonobject = JSONObject.fromObject(jsonString);
        JSONObject aggregations = jsonobject.getJSONObject("aggregations");
        Iterator<String> keys = aggregations.keys();
        while (keys.hasNext()) {
            String teams = keys.next();// key
            String teamsInfo = aggregations.optString(teams);// value
            System.out.println(teams + " - " + teamsInfo);
        }
    }

    public static void main(String[] args) {
        System.out.println(JsonUtil.jsonToObjectList("{\"aggregations\":{\"groupDate\":{\"buckets\":[{\"name\":\"wangjun\"},{\"name\":\"lisi\"}]}}}"));
        JsonUtil.jsonForeachKey("{\"aggregations\":{\"groupDate\":{\"buckets\":[{\"name\":\"wangjun\"},{\"name\":\"lisi\"}]}}}");
    }

}
