package com.company.date;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Demo {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = localDateTime.format(formatter);
        System.out.println("After Formatting: "+formatDateTime);
        System.out.println();
    }
}
