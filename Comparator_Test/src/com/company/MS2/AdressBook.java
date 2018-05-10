package com.company.MS2;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class AdressBook {
    ArrayList<Contact> contacts = new ArrayList<Contact>();

    ContactSortBy sortBy = ContactSortBy.Name;

    Boolean isByIncreasing = true;

    Comparator<Contact> byName = new Comparator<Contact>() {
        @Override
        public int compare(Contact o1, Contact o2) {
            if (isByIncreasing) {
                return o1.name.compareTo(o2.name);
            } else {
                return o2.name.compareTo(o1.name);
            }
        }
    };

    Comparator<Contact> bySecondName = new Comparator<Contact>() {
        @Override
        public int compare(Contact o1, Contact o2) {
            if (isByIncreasing) {
                return o1.secondName.compareTo(o2.secondName);
            } else {
                return o2.secondName.compareTo(o1.secondName);
            }
        }
    };

    Comparator<Contact> byAge = new Comparator<Contact>() {
        @Override
        public int compare(Contact o1, Contact o2) {
            if (isByIncreasing) {
                return o1.age.compareTo(o2.age);
            } else {
                return o2.age.compareTo(o1.age);
            }
        }
    };

    Comparator<Contact> byPhoneNumber = new Comparator<Contact>() {
        @Override
        public int compare(Contact o1, Contact o2) {
            if (isByIncreasing) {
                return o1.phoneNumber.compareTo(o2.phoneNumber);
            } else {
                return o2.phoneNumber.compareTo(o1.phoneNumber);
            }
        }
    };


    public ArrayList<Contact> sortedArray() {
        switch (sortBy) {
            case Age:
                contacts.sort(byAge);
                break;
            case Name:
                contacts.sort(byName);
                break;
            case SecondName:
                contacts.sort(bySecondName);
                break;
            case PhoneNumber:
                contacts.sort(byPhoneNumber);
                break;
            default:
                return  contacts;
        }
        return  contacts;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void setByIncreasing(Boolean byIncreasing) {
        isByIncreasing = byIncreasing;
    }

    public void setSortBy(ContactSortBy sortBy) {
        this.sortBy = sortBy;
    }
}
