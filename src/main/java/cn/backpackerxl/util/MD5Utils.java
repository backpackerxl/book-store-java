package cn.backpackerxl.util;


import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: backpackerxl
 * @create: 2021/10/29
 * @filename: MD5Utils
 **/
public class MD5Utils {
    public static String code(String str) {
        /**
         * MD5加密类
         * @param str 要加密的字符串
         * @return 加密后的字符串
         */
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Test
    public void test(){
//      admin  123@Xl123
        System.out.println(code("185219@Hy"));
    }
}
