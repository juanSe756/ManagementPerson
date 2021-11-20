package com.company.controllers;

import com.company.models.People;
import com.company.models.Person;

import java.io.*;
import java.util.ArrayList;

public class PeopleController {
    private final String path;

    public PeopleController() {
        path = "people.ser";
    }
    public void save(ArrayList<Person> personArrayList) throws IOException {
        FileOutputStream file = new FileOutputStream(path);
        ObjectOutputStream output = new ObjectOutputStream(file);
        output.writeObject(personArrayList);
        output.close();
        file.close();
    }
    public People read() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(path);
        ObjectInputStream input = new ObjectInputStream(file);
        People personArrayList = (People) input.readObject();
        input.close();
        file.close();
        return personArrayList;
    }
}
