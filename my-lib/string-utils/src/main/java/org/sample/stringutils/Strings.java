package org.sample.stringutils;

import java.util.UUID;

public class Strings {
    public static String getRandomNumber() {
        return UUID.randomUUID().toString();
    }
}
