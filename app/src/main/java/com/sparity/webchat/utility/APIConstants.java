package com.sparity.webchat.utility;

/**
 * Created by Shankar on 9/14/2017.
 */

public class APIConstants {
    public enum REQUEST_TYPE {
        GET, POST, MULTIPART_GET, MULTIPART_POST, DELETE, PUT, PATCH
    }

    private static final String STATUS = "status";
    public final static String SERVER_NOT_RESPONDING = "We are unable to connect the internet. " +
            "Please check your connection and try again.";

    public static String ERROR_MESSAGE = "We could not process your request at this time. Please try again later.";

    public static String BASE_URL = "http://52.9.66.98:3000/api/";
    public static final String CHAT_SERVER_URL = "http://52.9.66.98:3000/";

    public static String LOGIN = BASE_URL + "users/login";
    public static String OTHERS = BASE_URL + "others";
    public static String HISTORY_DATA = BASE_URL + "history/";
}
