package com.company;

import com.company.controllers.PeopleController;
import com.company.models.People;
import com.company.models.Person;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        People people = new People();
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("----------BIENVENIDO--------- \n Elige una opción: ");
            System.out.println("Opción 1: Agregar una persona");
            System.out.println("Opción 2: Mostrar personas");
            System.out.println("Opción 3: Eliminar una persona");
            System.out.println("Opción 4: Cancelar");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado la opcion 1");
                    people.addPerson(this.createPerson());
                    this.savePersonList(people.getPersonList());
                    System.out.println("La persona se guardó con éxito!");
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");
                    System.out.println("Las personas existentes son: "+"\n" + people.printPersonList());
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    System.out.println("Digite el id de la persona a eliminar: ");
                    people.deletePerson(scanner.nextShort());
                    this.savePersonList(people.getPersonList());
                    System.out.println("La persona fue borrada con éxito!");
                    break;
                case 4:
                    salir = true;
                    System.out.println("Se cerró el programa");
                    break;
                default:
                    System.out.println("Selecciona una opción válida");
            }
        }
    }

    private Person createPerson() {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite el nombre: ");
        person.setFirstname(scanner.nextLine());
        System.out.print("Digite el apellido: ");
        person.setLastname(scanner.nextLine());
        System.out.print("Digite el número de teléfono: ");
        person.setPhoneNumber(scanner.nextLine());
        System.out.print("Digite el id: ");
        person.setId(scanner.nextShort());
        return person;
    }

    public void savePersonList(ArrayList<Person> personArrayList){
        PeopleController peopleController = new PeopleController();
        try {
            peopleController.save(personArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public People readPersonList() {
        PeopleController peopleController = new PeopleController();
        People personArrayList = null;
        try {
            personArrayList = peopleController.read();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personArrayList;
    }
}
