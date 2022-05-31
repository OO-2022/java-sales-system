package com.mycompany.javasalessystem.Utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {

    public static String hashMD5(String value) {
        MessageDigest md5;
        
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        BigInteger hash = new BigInteger(1, md5.digest(value.getBytes()));
        return hash.toString(16);
    }
}
