package com.pt.pedrorijo91;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;

public class CodebitsAPI {

    /**
     * General endpoints
     */

    public static String getRssFeed() throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://codebits.eu/rss");
    }

    public static String getCalendarIcs() throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://codebits.eu/s/calendar.ics");
    }

    public static String getCalendar() throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://services.sapo.pt/Codebits/calendar");
    }

    public static String getSessionInfo(String sessionId) throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://services.sapo.pt/Codebits/session/" + sessionId);
    }

    public static String getSubmissionList() throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://services.sapo.pt/Codebits/calltalks");
    }

    public static String getSubmissionList(String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthGetRequest("https://services.sapo.pt/Codebits/calltalks", token);
    }

    /**
     * User based endpoints
     */

    public static String getAuthToken(String username, String password) throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest(HttpUtils.addParameter(
                HttpUtils.addParameter("https://services.sapo.pt/Codebits/gettoken", "user", username), "password", password));
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

    public static String searchByName(String name, String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthGetRequest("https://services.sapo.pt/Codebits/search/" + name, token);
    }

    public static String getUserFavorites(String userId, String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthGetRequest("https://services.sapo.pt/Codebits/usersessions/" + userId, token);
    }

    /**
     * Talk based endpoints
     */

    public static String getTalkComments(int id) throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://codebits.eu/rss/proposal/" + id);
    }

    public static String postComment(String commentToken, String comment, String subject, String token)
            throws ClientProtocolException, IOException {

        String url = "https://services.sapo.pt/Codebits/comment/" + commentToken;

        url = HttpUtils.addParameter(url, "comment", HttpUtils.urlEncode(comment));

        if ((subject != null) && (subject.length() > 0)) {
            url = HttpUtils.addParameter(url, "subject", HttpUtils.urlEncode(subject));
        }

        return HttpUtils.httpAuthPostRequest(url, token);
    }

    public static String postComment(String commentToken, String comment, String token) throws ClientProtocolException,
            IOException {
        return postComment(commentToken, comment, null, token);
    }

    public static String voteTalkUp(String talkId, String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthPostRequest("https://services.sapo.pt/Codebits/calluptalk/" + talkId, token);
    }

    public static String voteTalkDown(String talkId, String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthPostRequest("https://services.sapo.pt/Codebits/calldowntalk/" + talkId, token);
    }

    /**
     * Bot based endpoints
     */

    public static String getBodyParts() throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://services.sapo.pt/Codebits/botparts");
    }

    public static String getUserBot(String userId) throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://services.sapo.pt/Codebits/botuser/" + userId);
    }

    public static String makeBot(String body, String bgcolor, String grad, String eyes, String mouth, String legs, String head,
            String arms, String balloon) throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://services.sapo.pt/Codebits/botmake/" + body + "," + bgcolor + "," + grad + ","
                + eyes + "," + mouth + "," + legs + "," + head + "," + arms + "," + HttpUtils.urlEncode(balloon));
    }

    public static String makeBot(String body, String bgcolor, String grad, String eyes, String mouth, String legs, String head,
            String arms) throws ClientProtocolException, IOException {
        return makeBot(body, bgcolor, grad, eyes, mouth, legs, head, arms, "");
    }

    public static String setBot(String body, String bgcolor, String grad, String eyes, String mouth, String legs, String head,
            String arms, String balloon, String token) throws ClientProtocolException, UnsupportedEncodingException, IOException {
        return HttpUtils.httpAuthPostRequest("https://services.sapo.pt/Codebits/botmake/" + body + "," + bgcolor + "," + grad
                + "," + eyes + "," + mouth + "," + legs + "," + head + "," + arms + "," + HttpUtils.urlEncode(balloon), token);
    }

    public static String setBot(String body, String bgcolor, String grad, String eyes, String mouth, String legs, String head,
            String arms, String token) throws ClientProtocolException, UnsupportedEncodingException, IOException {
        return setBot(body, bgcolor, grad, eyes, mouth, legs, head, arms, "", token);
    }

    /**
     * Badge based endpoints
     */

    public static String listBadges() throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://services.sapo.pt/Codebits/listbadges");
    }

    public static String getUsersByBadge(String badgeId) throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://services.sapo.pt/Codebits/badgesusers/" + badgeId);
    }

    public static String redeemBadge(String badgeCode, String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthGetRequest("https://services.sapo.pt/Codebits/redeem/" + badgeCode, token);
    }

    /**
     * Project based endpoints
     */

    public static String listProjects(String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthGetRequest("https://services.sapo.pt/Codebits/projects", token);
    }

    public static String getProjectInfo(String projectId, String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthGetRequest("https://services.sapo.pt/Codebits/project/" + projectId, token);
    }

    public static String getCurrentVotes() throws ClientProtocolException, IOException {
        return HttpUtils.httpGetRequest("https://services.sapo.pt/Codebits/votes");
    }

    public static String voteProject(boolean vote, String token) throws ClientProtocolException, IOException {
        return HttpUtils.httpAuthPostRequest("https://services.sapo.pt/Codebits/vote1" + (vote ? 1 : 0), token);
    }

}
