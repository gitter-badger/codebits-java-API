package com.pt.pedrorijo91;

import org.json.JSONObject;
import org.json.XML;

public class Utils {

    public static String xmlToJson(String xml) {
        return xmlToJson(xml, 0);
    }

    public static String xmlToJson(String xml, int indentFactor) {
        return XML.toJSONObject(xml).toString(indentFactor);
    }

    public static String jsonToXml(String json) {
        return XML.toString(new JSONObject(json));
    }

    public static String extractToken(String token) {
        return new JSONObject(token).getString("token");
    }
}
