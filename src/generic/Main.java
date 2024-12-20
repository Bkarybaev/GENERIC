package generic;

import generic.enums.Gender;
import generic.model.Animal;
import generic.model.Person;
import generic.service.impl.AnimalService;
import generic.service.impl.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static PersonService personService = new PersonService();
    static AnimalService animalService = new AnimalService();

    public static void main(String[] args) {
        while (true) {
            System.out.print("""
                        --- welcome to world ---
                    1.Animal
                    2.Person
                    0.logout
                    """);
            System.out.print("choice: ");
            switch (new Scanner(System.in).nextLine()) {
                case "1" -> animal();
                case "2" -> person();

                case "0" -> {
                    System.out.println("Logout...");
                    return;
                }
                default -> System.out.println("Error choice try again");
            }
        }
    }

    public static void animal() {
        while (true) {
            System.out.print("""
                    1.add animal
                    2.get by id
                    3.get all
                    4.sort by name
                    5.filter by gender
                    6.clear
                    0.logout
                    """);
            System.out.print("choice: ");
            switch (new Scanner(System.in).nextLine()) {
                case "1" -> System.out.println(animalService.add(getAnimal()));
                case "2" -> {
                    System.out.print("write id: ");
                    System.out.println(animalService.getById(new Scanner(System.in).nextLong()));
                }
                case "3" -> System.out.println(animalService.getAll());
                case "4" -> {
                    System.out.println("1 ди басканда ascending");
                    System.out.println("2 ни басканда descending");
                    System.out.print("choice: ");
                    int i = new Scanner(System.in).nextInt();
                    System.out.println(animalService.sortByName(i));
                }
                case "5" -> {
                    System.out.println("1 ди басканда female");
                    System.out.println("2 ни басканда male");
                    System.out.print("choice: ");
                    int i = new Scanner(System.in).nextInt();
                    System.out.println(animalService.filterByGender(i));
                }
                case "6" -> System.out.println(animalService.clear());
                case "0" -> {
                    return;
                }
                default -> System.out.println("Error choice!!!");
            }
        }
    }

    public static void person() {
        while (true) {
            System.out.print("""
                    1.add person
                    2.get by id
                    3.get all
                    4.sort by name
                    5.filter by gender
                    6.clear
                    0.logout
                    """);
            System.out.print("choice: ");
            switch (new Scanner(System.in).nextLine()) {
                case "1" -> System.out.println(personService.add(getPerson()));
                case "2" -> {
                    System.out.print("write id: ");
                    System.out.println(personService.getById(new Scanner(System.in).nextLong()));
                }
                case "3" -> System.out.println(personService.getAll());
                case "4" -> {
                    System.out.println("1 ди басканда ascending");
                    System.out.println("2 ни басканда descending");
                    System.out.print("choice: ");
                    int i = new Scanner(System.in).nextInt();
                    System.out.println(personService.sortByName(i));
                }
                case "5" -> {
                    System.out.println("1 ди басканда female");
                    System.out.println("2 ни басканда male");
                    System.out.print("choice: ");
                    int i = new Scanner(System.in).nextInt();
                    System.out.println(personService.filterByGender(i));
                }
                case "6" -> System.out.println(personService.clear());
                case "0" -> {
                    return;
                }
                default -> System.out.println("Error choice!!!");
            }
        }
    }

    public static List<Animal> getAnimal() {
        List<Animal> animals = new ArrayList<>(
                List.of(
                        new Animal("dogger", 4, Gender.MALE),
                        new Animal("ak tosh", 2, Gender.MALE),
                        new Animal("tom", 1, Gender.FEMALE),
                        new Animal("jerry", 5, Gender.MALE),
                        new Animal("soni", 7, Gender.FEMALE)
                )
        );
        return animals;
    }

    public static List<Person> getPerson() {
        Person[] people = {
                new Person("Baiel", 20, Gender.MALE),
                new Person("Aidai", 18, Gender.FEMALE),
                new Person("Guljamal eje", 18, Gender.FEMALE),
                new Person("Ainura eje", 18, Gender.FEMALE),
                new Person("Aibek", 16, Gender.MALE),
                new Person("Amir", 18, Gender.MALE),
                new Person("Nursultan", 27, Gender.MALE),
                new Person("Aijamal eje", 18, Gender.FEMALE),
                new Person("Almaz", 24, Gender.MALE),
                new Person("Aika", 18, Gender.FEMALE),
                new Person("Nura", 18, Gender.FEMALE)
        };
        int ran = new Random().nextInt(people.length);
        List<Person> p = new ArrayList<>();
        p.add(people[ran]);
        return p;
    }
}
