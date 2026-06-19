package com.school.sms.util;

/**
 * Central place for constant values used across the application.
 */
public class Constants {

    private Constants() {
        // Prevent instantiation
    }

    // Security & JWT Constants
    public static final String JWT_HEADER = "Authorization";
    public static final String JWT_PREFIX = "Bearer ";
    public static final long JWT_EXPIRATION = 86400000L; // 24 hours in milliseconds

    // Role Names (must match Role.ERole enum values without "ROLE_" prefix)
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_TEACHER = "TEACHER";
    public static final String ROLE_STUDENT = "STUDENT";
    public static final String ROLE_PARENT = "PARENT";

    // API Path Constants
    public static final String API_AUTH = "/api/auth";
    public static final String API_ADMIN = "/api/admin";
    public static final String API_TEACHER = "/api/teacher";
    public static final String API_STUDENT = "/api/student";
    public static final String API_PARENT = "/api/parent";

    // Common Messages
    public static final String SUCCESS = "Success";
    public static final String USER_REGISTERED = "User registered successfully";
    public static final String LOGIN_SUCCESS = "Login successful";
    public static final String UNAUTHORIZED = "Unauthorized access";
    public static final String FORBIDDEN = "Forbidden: Insufficient permissions";

    // Date/Time Formats
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // Pagination Defaults
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int DEFAULT_PAGE_NUMBER = 0;
}