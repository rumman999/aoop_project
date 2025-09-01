package com.example.aoop_project;

public class Session {
    private static String loggedInUserEmail;

    public static void setLoggedInUserEmail(String email) { loggedInUserEmail = email; }
    public static String getLoggedInUserEmail() { return loggedInUserEmail; }
    public static void clear() { loggedInUserEmail = null; }
}

