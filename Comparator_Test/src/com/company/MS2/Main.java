package com.company.MS2;

import com.company.MS2.AdressBook.Formula;

public class Main {

    public static void main(String[] args) {

        Terminal.sharedTerminal.run();
    }
}

// Задание с AdressBook
//        AdressBook newBook = new AdressBook();
//
//        Contact contact1 = new Contact();
//        Contact contact2 = new Contact();
//        Contact contact3 = new Contact();
//        Contact contact4 = new Contact();
//        Contact contact5 = new Contact();
//
//        contact1.name = "A";
//        contact1.secondName = "Q";
//        contact1.age = 50;
//        contact1.phoneNumber = "+380965207198";
//
//        newBook.addContact(contact1);
//
//        contact2.name = "Q";
//        contact2.secondName = "A";
//        contact2.age = 30;
//        contact2.phoneNumber = "+380975207198";
//
//        newBook.addContact(contact2);
//
//        contact3.name = "T";
//        contact3.secondName = "F";
//        contact3.age = 78;
//        contact3.phoneNumber = "+380966207198";
//
//        newBook.addContact(contact3);
//
//        contact4.name = "B";
//        contact4.secondName = "S";
//        contact4.age = 18;
//        contact4.phoneNumber = "+380916207198";
//
//        newBook.addContact(contact4);
//
//        contact5.name = "L";
//        contact5.secondName = "P";
//        contact5.age = 78;
//        contact5.phoneNumber = "+380909207198";
//
//        newBook.addContact(contact5);
//        newBook.setSortBy(ContactSortBy.PhoneNumber);
//        newBook.setByIncreasing(true);
//        newBook.sortedArray();
//
//        for (Contact contact : newBook.sortedArray()) {
//            System.out.println(contact.name);
//            System.out.println(contact.secondName);
//            System.out.println(contact.age);
//            System.out.println(contact.phoneNumber);
//            System.out.println();
//        }
//
//


//        String command = "";
//
//        System.out.println("Run new session: " + new Date().toString());
//        while (command != "exit") {
//            System.out.print(command != "exit");
//            System.out.print("root: ");
//            Scanner keyboarIn = new Scanner(System.in);
//
//            command = keyboarIn.nextLine();
//            System.out.println(command + " is unknown command \n");
//
//        }
//        System.out.println("Session is ended at " + new Date().toString());