package com.game.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtils {

    public static String encrypt(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(value.getBytes());
            return new String(array);
        } catch(NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
