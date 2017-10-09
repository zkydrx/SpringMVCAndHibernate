package com.tyd.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-04
 * Time: 16:37
 * Description:
 */
public class MD5Util
{
    public static String getMD5(String str)
    {
        String resultStr="";
        try
        {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            resultStr = new BigInteger(1, md.digest()).toString(16).toUpperCase();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            try
            {
                throw new Exception("MD5加密出错。");
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
        return resultStr;
    }
}
