package com.company.models;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private Short id;

    public Person(){
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Override
    public java.lang.String toString() {
        return "Nombre = " + firstname + '\n' +
                "Apellido= " + lastname + '\n' +
                "Teléfono = " + phoneNumber + '\n' + "Id: " + id + '\n';
    }
}

