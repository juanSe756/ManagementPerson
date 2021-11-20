package com.company.controllers;
import com.company.models.Person;
import java.io.*;

public class PersonController {
    private final String path;

    public PersonController() {
        path = "person.ser";
    }
    public void save(Person person) throws IOException {
        FileOutputStream file = new FileOutputStream(path);
        ObjectOutputStream output = new ObjectOutputStream(file);
        output.writeObject(person);
        output.close();
        file.close();
    }
    public Person read() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(path);
        ObjectInputStream input = new ObjectInputStream(file);
        Person person = (Person) input.readObject();
        input.close();
        file.close();
        return person;
    }
}
