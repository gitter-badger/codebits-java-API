package com.pt.pedrorijo91;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpUtils {

    private static String executeHttpRequest(HttpRequestBase httpRequest) throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse httpResponse = client.execute(httpRequest);
        HttpEntity entity = httpResponse.getEntity();
        InputStream content = entity.getContent();

        BufferedReader reader = new BufferedReader(new InputStreamReader(content));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }

        return builder.toString();
    }

    static String httpGetRequest(String url) throws ClientProtocolException, IOException {

        HttpGet httpGetRequest = new HttpGet(url);
        return executeHttpRequest(httpGetRequest);
    }

    static String httpPostRequest(String url) throws ClientProtocolException, IOException {

        HttpPost httpPostRequest = new HttpPost(url);
        return executeHttpRequest(httpPostRequest);
    }

    static String httpAuthGetRequest(String url, String token) throws ClientProtocolException, IOException {
        return httpGetRequest(addParameter(url, "token", token));
    }

    static String httpAuthPostRequest(String url, String token) throws ClientProtocolException, IOException {
        return httpPostRequest(addParameter(url, "token", token));
    }

    static String urlEncode(String string, String encode) throws UnsupportedEncodingException {
        return URLEncoder.encode(string, encode);
    }

    static String urlEncode(String string) throws UnsupportedEncodingException {
        return urlEncode(string, "UTF-8");
    }

    static String addParameter(String url, String parameter, String value) {
        if (!url.contains("?")) {
            url += "?";
        }
        return url += "&" + parameter + "=" + value;
    }

}
