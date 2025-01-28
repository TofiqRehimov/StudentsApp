package org.example.studentsapp.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String getFormatter(LocalDateTime time, boolean showTime) {
        if (showTime) {
            return time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
