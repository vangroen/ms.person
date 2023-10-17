package com.owner.ms.person.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helpers {

    public static String getLocalDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
