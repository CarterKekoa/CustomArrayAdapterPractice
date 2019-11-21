package com.example.customarrayadapterfuns1;


public class Contact {
    private String name;
    private String phoneNumber;

    public Contact() {
        name = "BLANK NAME";
        phoneNumber = "PHONE NUMBER";
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name;
    }
}
