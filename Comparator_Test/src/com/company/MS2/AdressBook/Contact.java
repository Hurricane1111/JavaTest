package com.company.MS2.AdressBook;

import java.util.Comparator;

public class Contact {

    String name = "";;
    String secondName = "";
    String phoneNumber = "";
    Integer age = 0;

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
