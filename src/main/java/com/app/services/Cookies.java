package com.app.services;

import javax.servlet.http.Cookie;

import com.vaadin.flow.server.VaadinService;

/**
 * The CookieService handles all functions related to cookies.
 */
public class Cookies {

    public static void setCookie(String name, String cookie) {
        // Create a new cookie
        Cookie myCookie = new Cookie(name, cookie);
        // Make cookie expire in 1 day
        myCookie.setMaxAge(86400);
        // Set the cookie path.
        myCookie.setPath(VaadinService.getCurrentRequest().getContextPath());
        // Save cookie
        VaadinService.getCurrentResponse().addCookie(myCookie);
    }

    public static String getCookie(String name) {
        Cookie cookie = get(name);
        if(cookie == null) return null;
        return cookie.getValue();
    }

    public static void removeCookie(String name) {
        Cookie cookie = get(name);
        cookie.setMaxAge(0);
        VaadinService.getCurrentResponse().addCookie(cookie);
    }

    private static Cookie get (String name) {
        // Fetch all cookies from the request
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();

        // Iterate to find cookie by its name
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
