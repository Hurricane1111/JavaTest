package com.company.MS2.AdressBook;

import java.awt.*;
import java.util.Comparator;
import java.util.Dictionary;

public class Contact {

    Integer id;
    String name = "";;
    String secondName = "";
    String phoneNumber = "";
    Integer age = 0;
    String comment = "";

    public Contact(Dictionary<String, Object> info) {

        Object tempObject = info.get(contactIdKey);
        if (tempObject instanceof Integer) {
            name = (String) tempObject;
        }

        tempObject = info.get(contactNameKey);
        if (tempObject instanceof String) {
            name = (String) tempObject;
        }

        tempObject = info.get(contactSecondNameKey);
        if (tempObject instanceof String) {
            name = (String) tempObject;
        }

        tempObject = info.get(contactPhoneNumberKey);
        if (tempObject instanceof String) {
            name = (String) tempObject;
        }

        tempObject = info.get(contactAgeKey);
        if (tempObject instanceof Integer) {
            name = (String) tempObject;
        }

        tempObject = info.get(contactCommentKey);
        if (tempObject instanceof String) {
            name = (String) tempObject;
        }


    }


    // Describe contact
    public void describe() {
        System.out.println(name);
        System.out.println(secondName);
        System.out.println(age);
        System.out.println(phoneNumber);
        System.out.println(comment);
        System.out.println();
    }
    public String contactIdKey = "contactIdKey";
    public String contactNameKey = "contactNameKey";
    public String contactSecondNameKey = "contactSecondNameKey";
    public String contactPhoneNumberKey = "contactPhoneNumberKey";
    public String contactAgeKey = "contactAgeKey";
    public String contactCommentKey = "contactCommentKey";

}
