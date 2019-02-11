package com.example.springcloudapi.Tools;

import org.springframework.stereotype.Component;

@Component
public class DateTools {
    public String getTimeStampString() {
        return String.valueOf(System.currentTimeMillis());
    }
}
