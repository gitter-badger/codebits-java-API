package com.pt.pedrorijo91;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;

public class CodebitsAPI {

    /**
     * General endpoints
     */

    public static String getRssFeed(boolean xml) throws ClientProtocolException, IOException {
        String url = "https://codebits.eu/rss";

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpGetRequest(url);
    }

    public static String getRssFeed() throws ClientProtocolException, IOException {
        return getRssFeed(false);
    }

    public static String getCalendarIcs(boolean xml) throws ClientProtocolException, IOException {
        String url = "https://codebits.eu/s/calendar.ics";

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpGetRequest(url);
    }

    public static String getCalendarIcs() throws ClientProtocolException, IOException {
        return getCalendarIcs(false);
    }

    public static String getCalendar(boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/calendar";

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpGetRequest(url);
    }

    public static String getCalendar() throws ClientProtocolException, IOException {
        return getCalendar(false);
    }

    public static String getSessionInfo(String sessionId, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/session/" + sessionId;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpGetRequest(url);
    }

    public static String getSessionInfo(String sessionId) throws ClientProtocolException, IOException {
        return getSessionInfo(sessionId, false);
    }

    public static String getSubmissionList(String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/calltalks";

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        if (token != null) {
            return HttpUtils.httpAuthGetRequest(url, token);
        } else {
            return HttpUtils.httpGetRequest(url);
        }
    }

    public static String getSubmissionList(String token) throws ClientProtocolException, IOException {
        return getSubmissionList(token, false);
    }

    public static String getSubmissionList(boolean xml) throws ClientProtocolException, IOException {
        return getSubmissionList(null, xml);
    }

    public static String getSubmissionList() throws ClientProtocolException, IOException {
        return getSubmissionList(null, false);
    }

    /**
     * User based endpoints
     */

    public static String getAuthToken(String username, String password, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/gettoken";
        url = HttpUtils.addParameter(url, "user", username);

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpGetRequest(HttpUtils.addParameter(url, "password", password));
    }

    public static String getAuthToken(String username, String password) throws ClientProtocolException, IOException {
        return getAuthToken(username, password, false);
    }

    public static String getUserById(String userId, String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/user/" + userId;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthGetRequest(url, token);
    }

    public static String getUserById(String userId, String token) throws ClientProtocolException, IOException {
        return getUserById(userId, token, false);
    }

    public static String getUserByNick(String nick, String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/nick/" + nick;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthGetRequest(url, token);
    }

    public static String getUserByNick(String nick, String token) throws ClientProtocolException, IOException {
        return getUserByNick(nick, token, false);
    }

    public static String getFriendsList(String userId, String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/foaf/" + userId;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthGetRequest(url, token);
    }

    public static String getFriendsList(String userId, String token) throws ClientProtocolException, IOException {
        return getFriendsList(userId, token, false);
    }

    public static String addFriend(String userId, String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/foafadd/" + userId;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthPostRequest(url, token);
    }

    public static String addFriend(String userId, String token) throws ClientProtocolException, IOException {
        return addFriend(userId, token, false);
    }

    public static String rejectFriend(String userId, String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/foafreject/" + userId;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthPostRequest(url, token);
    }

    public static String rejectFriend(String userId, String token) throws ClientProtocolException, IOException {
        return rejectFriend(userId, token, false);
    }

    public static String listAcceptedUsersBySkill(String skill, String token, boolean xml) throws ClientProtocolException,
            IOException {
        String url = "https://services.sapo.pt/Codebits/users/" + skill;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthGetRequest(url, token);
    }

    public static String listAcceptedUsersBySkill(String skill, String token) throws ClientProtocolException, IOException {
        return listAcceptedUsersBySkill(skill, token, false);
    }

    public static String listAcceptedUsers(String token, boolean xml) throws ClientProtocolException, IOException {
        return listAcceptedUsersBySkill("", token, xml);
    }

    public static String listAcceptedUsers(String token) throws ClientProtocolException, IOException {
        return listAcceptedUsersBySkill("", token, false);
    }

    public static String searchByName(String name, String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/search/" + name;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthGetRequest(url, token);
    }

    public static String searchByName(String name, String token) throws ClientProtocolException, IOException {
        return searchByName(name, token, false);
    }

    public static String getUserFavorites(String userId, String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/usersessions/" + userId;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthGetRequest(url, token);
    }

    public static String getUserFavorites(String userId, String token) throws ClientProtocolException, IOException {
        return getUserFavorites(userId, token, false);
    }

    /**
     * Talk based endpoints
     */

    public static String getTalkComments(int id, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://codebits.eu/rss/proposal/" + id;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpGetRequest(url);
    }

    public static String getTalkComments(int id) throws ClientProtocolException, IOException {
        return getTalkComments(id, false);
    }

    public static String postComment(String commentToken, String comment, String subject, String token, boolean xml)
            throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/comment/" + commentToken;
        url = HttpUtils.addParameter(url, "comment", HttpUtils.urlEncode(comment));

        if ((subject != null) && (subject.length() > 0)) {
            url = HttpUtils.addParameter(url, "subject", HttpUtils.urlEncode(subject));
        }

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthPostRequest(url, token);
    }

    public static String postComment(String commentToken, String comment, String subject, String token)
            throws ClientProtocolException, IOException {
        return postComment(commentToken, comment, subject, token, false);
    }

    public static String postComment(String commentToken, String comment, String token, boolean xml)
            throws ClientProtocolException, IOException {
        return postComment(commentToken, comment, null, token, xml);
    }

    public static String postComment(String commentToken, String comment, String token) throws ClientProtocolException,
    IOException {
        return postComment(commentToken, comment, null, token, false);
    }

    public static String voteTalkUp(String talkId, String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/calluptalk/" + talkId;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthPostRequest(url, token);
    }

    public static String voteTalkUp(String talkId, String token) throws ClientProtocolException, IOException {
        return voteTalkUp(talkId, token, false);
    }

    public static String voteTalkDown(String talkId, String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/calldowntalk/" + talkId;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthPostRequest(url, token);
    }

    public static String voteTalkDown(String talkId, String token) throws ClientProtocolException, IOException {
        return voteTalkDown(talkId, token, false);
    }

    /**
     * Bot based endpoints
     */

    public static String getBodyParts(boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/botparts";

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpGetRequest(url);
    }

    public static String getBodyParts() throws ClientProtocolException, IOException {
        return getBodyParts(false);
    }

    public static String getUserBot(String userId, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/botuser/" + userId;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpGetRequest(url);
    }

    public static String getUserBot(String userId) throws ClientProtocolException, IOException {
        return getUserBot(userId, false);
    }

    public static String makeBot(String body, String bgcolor, String grad, String eyes, String mouth, String legs, String head,
            String arms, String balloon) throws ClientProtocolException, IOException {
        String url =
                "https://services.sapo.pt/Codebits/botmake/" + body + "," + bgcolor + "," + grad + "," + eyes + "," + mouth + ","
                        + legs + "," + head + "," + arms + "," + HttpUtils.urlEncode(balloon);

        return HttpUtils.httpGetRequest(url);
    }

    public static String makeBot(String body, String bgcolor, String grad, String eyes, String mouth, String legs, String head,
            String arms) throws ClientProtocolException, IOException {
        return makeBot(body, bgcolor, grad, eyes, mouth, legs, head, arms, "");
    }

    public static String setBot(String body, String bgcolor, String grad, String eyes, String mouth, String legs, String head,
            String arms, String balloon, String token, boolean xml) throws ClientProtocolException, UnsupportedEncodingException,
            IOException {
        String url =
                "https://services.sapo.pt/Codebits/botmake/" + body + "," + bgcolor + "," + grad + "," + eyes + "," + mouth + ","
                        + legs + "," + head + "," + arms + "," + HttpUtils.urlEncode(balloon);

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthPostRequest(url, token);
    }

    public static String setBot(String body, String bgcolor, String grad, String eyes, String mouth, String legs, String head,
            String arms, String balloon, String token) throws ClientProtocolException, UnsupportedEncodingException, IOException {
        return setBot(body, bgcolor, grad, eyes, mouth, legs, head, arms, balloon, token, false);
    }

    public static String setBot(String body, String bgcolor, String grad, String eyes, String mouth, String legs, String head,
            String arms, String token, boolean xml) throws ClientProtocolException, UnsupportedEncodingException, IOException {
        return setBot(body, bgcolor, grad, eyes, mouth, legs, head, arms, "", token, xml);
    }

    public static String setBot(String body, String bgcolor, String grad, String eyes, String mouth, String legs, String head,
            String arms, String token) throws ClientProtocolException, UnsupportedEncodingException, IOException {
        return setBot(body, bgcolor, grad, eyes, mouth, legs, head, arms, "", token, false);
    }

    /**
     * Badge based endpoints
     */

    public static String listBadges(boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/listbadges";

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpGetRequest(url);
    }

    public static String listBadges() throws ClientProtocolException, IOException {
        return listBadges(false);
    }

    public static String getUsersByBadge(String badgeId, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/badgesusers/" + badgeId;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpGetRequest(url);
    }

    public static String getUsersByBadge(String badgeId) throws ClientProtocolException, IOException {
        return getUsersByBadge(badgeId, false);
    }

    public static String redeemBadge(String badgeCode, String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/redeem/" + badgeCode;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthGetRequest(url, token);
    }

    public static String redeemBadge(String badgeCode, String token) throws ClientProtocolException, IOException {
        return redeemBadge(badgeCode, token, false);
    }

    /**
     * Project based endpoints
     */

    public static String listProjects(String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/projects";

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthGetRequest(url, token);
    }

    public static String listProjects(String token) throws ClientProtocolException, IOException {
        return listProjects(token, false);
    }

    public static String getProjectInfo(String projectId, String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/project/" + projectId;

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthGetRequest(url, token);
    }

    public static String getProjectInfo(String projectId, String token) throws ClientProtocolException, IOException {
        return getProjectInfo(projectId, token, false);
    }

    public static String getCurrentVotes(boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/votes";

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpGetRequest(url);
    }

    public static String getCurrentVotes() throws ClientProtocolException, IOException {
        return getCurrentVotes(false);
    }

    public static String voteProject(boolean vote, String token, boolean xml) throws ClientProtocolException, IOException {
        String url = "https://services.sapo.pt/Codebits/vote/" + (vote ? 1 : 0);

        if (xml) {
            url = HttpUtils.addParameter(url, "format", "xml");
        }

        return HttpUtils.httpAuthPostRequest(url, token);
    }

    public static String voteProject(boolean vote, String token) throws ClientProtocolException, IOException {
        return voteProject(vote, token, false);
    }

}
