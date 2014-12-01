package com.pt.pedrorijo91;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class CodebitsAPI {

    /**
     * General endpoints
     */

    public static String getRssFeed() throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://codebits.eu/rss");
    }

    public static String getTalkComments(int id) throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://codebits.eu/rss/proposal/" + id);
    }

    /**
     * User based endpoints
     */

    public static String getAuthToken(String username, String password) throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://services.sapo.pt/Codebits/gettoken?user=" + username + "&password=" + password);
    }

    public static String getUserById(String userId, String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthGetRequest("https://services.sapo.pt/Codebits/user/" + userId, token);
    }

    public static String getUserByNick(String nick, String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthGetRequest("https://services.sapo.pt/Codebits/nick/" + nick, token);
    }

    public static String getFriendsList(String userId, String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthGetRequest("https://services.sapo.pt/Codebits/foaf/" + userId, token);
    }

    public static String addFriend(String userId, String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthPostRequest("https://services.sapo.pt/Codebits/foafadd/" + userId, token);
    }

    public static String rejectFriend(String userId, String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthPostRequest("https://services.sapo.pt/Codebits/foafreject/" + userId, token);
    }

    public static String listAcceptedUsers(String token) throws ClientProtocolException, IOException {
        return listAcceptedUsersBySkill("", token);
    }

    public static String listAcceptedUsersBySkill(String skill, String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthGetRequest("https://services.sapo.pt/Codebits/users/" + skill, token);
    }

    /**
     * Bots based endpoints
     */
}
