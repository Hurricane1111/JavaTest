package com.company.MS2;

import java.util.Comparator;

public class Contact  {

    String name = "";;
    String secondName = "";
    String phoneNumber = "";
    Integer age = 0;

    //Constructor
    public Contact() {

    }

    // Describe contact
    public void describe() {
        System.out.println(name);
        System.out.println(secondName);
        System.out.println(age);
        System.out.println(phoneNumber);
        System.out.println();
    }

}
