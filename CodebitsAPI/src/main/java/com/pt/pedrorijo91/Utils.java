package com.pt.pedrorijo91;

import org.json.JSONObject;
import org.json.XML;

public class Utils {

    public static String xmlToJson(String xml) {
        return xmlToJson(xml, 0);
    }

    public static String xmlToJson(String xml, int indentFactor) {
        JSONObject json = XML.toJSONObject(xml);
        return json.toString(indentFactor);
    }

    public static String jsonToXml(String json) {
        JSONObject jsonObj = new JSONObject(json);
        return XML.toString(jsonObj);
    }

    public static String extractToken(String token) {
        JSONObject jsonToken = new JSONObject(token);

        return jsonToken.getString("token");
    }
}
