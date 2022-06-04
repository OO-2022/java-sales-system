package com.mycompany.salessystem.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ConversionToDate {
    public static Date conversionToDate(String date) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date newDate = format.parse(date);
        
        return newDate;
    }
    
    public static String conversionToString(Date date) throws ParseException{
        String newDate = date.toInstant()
				.atOffset(ZoneOffset.UTC)
				.format( DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        
        return newDate;
    }
}