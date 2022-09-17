package com.java.basic.utils;

public class JsonUtil {

    /**
     * Json转对象List
     * JSONObject jsonobject = JSONObject.fromObject(responseBody);
     * JSONObject aggregations = (JSONObject) jsonobject.get("aggregations");
     * JSONObject groupDate = (JSONObject) aggregations.get("groupDate");
     * String buckets = groupDate.getString("buckets");
     * JSONArray bucketsJsonArray = JSONArray.fromObject(buckets);
     * // 参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
     * List<Buckets> bucketsList = JSONArray.toList(bucketsJsonArray, new Buckets(), new JsonConfig());
     */

    /**
     * JSONObject遍历Key
     * JSONObject rule = JSONObject.fromObject(oaSyncShipment.getRule());
     * JSONObject countries = rule.getJSONObject("countries");
     * @SuppressWarnings("unchecked")
     * Iterator<String> keys = countries.keys();
     * while (keys.hasNext()) {
     * String teams = keys.next();// key
     * String teamsInfo = countries.optString(teams);// value
     * }
     */

}
