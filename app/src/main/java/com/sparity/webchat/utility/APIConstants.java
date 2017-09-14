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

    public static String BASE_URL = "http://139.59.30.4/api/v1.0/";

    public static String LOGIN = BASE_URL + "login";
}
