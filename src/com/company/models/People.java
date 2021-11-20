package com.company.models;
import java.io.Serializable;
import java.util.ArrayList;
public class People implements Serializable {
    private ArrayList <Person> personList = new ArrayList <Person>();

    public ArrayList<Person> getPersonList() {
        return personList;
    }
    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public void addPerson(Person person){
        personList.add(person);
    }

    public void deletePerson(short id) {
        personList.remove(findPerson(id));
    }
    public Person findPerson(short id){
        Person aux = null;
        for(Person person : personList) {
            if(personList != null && person.getId() == id)
                aux = person;
        }
        return aux;
    }

    public String printPersonList() {
        StringBuilder peopleString = new StringBuilder();
        for (Person person: personList) {
            peopleString.append(person).append("\n");
        }
        return peopleString.toString();
    }
    @Override
    public String toString() {
        return "Personas en la lista: " + personList;
    }
}
