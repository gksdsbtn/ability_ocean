package com.sindorim.abilityocean.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sindorim.abilityocean.domain.User;

public class SessionUtil
{

    public SessionUtil()
    {
    }

    public static Object getSession(HttpServletRequest request, String sessionKey)
    {
        HttpSession session = request.getSession();
        Object object = session.getAttribute(sessionKey);
        return object;
    }

    public static void createUserSession(HttpServletRequest request, User user)
    {
        HttpSession session = request.getSession();
        session.setAttribute("USER_INFO", user);
    }
}