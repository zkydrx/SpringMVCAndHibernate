package com.tyd.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-03
 * Time: 19:36
 * Description:
 * 获取session
 */
public class SessionUtil
{
    public static Session getSession()
    {
        Configuration configuration =  new Configuration().configure();
        Session session = configuration.buildSessionFactory().openSession();
        return session;
    }
}
