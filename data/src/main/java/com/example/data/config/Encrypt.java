package com.example.data.config;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class Encrypt {

    public static String encrypt(String sw, String salt) {
        String en = DigestUtils.sha1Hex(sw);
        StringBuilder s = new StringBuilder(en);
        s.insert(20, salt);
        en = DigestUtils.sha1Hex(s.toString());
        return en;
    } // 加密

    public static String firstgetSalt() {
        String salt = RandomStringUtils.randomAlphabetic(8);
        return salt;
    }

}
