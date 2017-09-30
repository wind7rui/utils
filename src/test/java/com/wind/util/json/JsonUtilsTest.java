package com.wind.util.json;

import org.junit.Test;


public class JsonUtilsTest {

    /**
     *
     * {"name":"刘禅","age":"6","father":{"name":"刘备","age":"50","properties": {"country": {"id": "002","name": "蜀"},"education": {"description": "学历","value": "私塾"},
     " job":[{"id":"1","position":"大王"}],"wife": {"hasOne": false,"list": ["糜夫人","孙夫人","甘皇后","吴夫人"]}}}}
     *
     */
    @Test
    public void test() {
        String response = "{\n" +
                "    \"name\": \"刘禅\", \n" +
                "    \"age\": \"6\", \n" +
                "    \"father\": {\n" +
                "        \"name\": \"刘备\", \n" +
                "        \"age\": \"50\", \n" +
                "        \"properties\": {\n" +
                "            \"country\": {\n" +
                "                \"id\": \"002\", \n" +
                "                \"name\": \"蜀\"\n" +
                "            }, \n" +
                "            \"education\": {\n" +
                "                \"description\": \"学历\", \n" +
                "                \"value\": \"私塾\"\n" +
                "            }, \n" +
                "            \"job\": [\n" +
                "                {\n" +
                "                    \"id\": \"1\", \n" +
                "                    \"position\": \"大王\"\n" +
                "                }\n" +
                "            ], \n" +
                "            \"wife\": {\n" +
                "                \"hasOne\": false, \n" +
                "                \"list\": [\n" +
                "                    \"糜夫人\", \n" +
                "                    \"孙夫人\", \n" +
                "                    \"甘皇后\", \n" +
                "                    \"吴夫人\"\n" +
                "                ]\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        System.out.println(JsonUtils.getValueByKeyExpression(response, "father", "father#properties#education#value"));

        System.out.println(JsonUtils.getValueByKeyExpression(response, "father", "father#properties#wife#list"));

        System.out.println(JsonUtils.getValueByKeyExpression(response, "father", "father#properties#job#position"));
    }

}