package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    
    public String convertDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
