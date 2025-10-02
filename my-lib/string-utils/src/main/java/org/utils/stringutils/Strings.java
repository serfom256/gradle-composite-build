package org.utils.stringutils;

import java.util.UUID;

public class Strings {
    public static String getRandomNumber() {
        return UUID.randomUUID().toString();
    }
}
