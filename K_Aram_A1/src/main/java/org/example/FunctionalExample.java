package org.example;

import io.vavr.collection.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
class Person {
    private String name;
    private int age;
}

public class FunctionalExample {

    public static void main(String[] args) {
        List<Person> people = createPeopleList();

        List<Person> adults = filterAdults(people);
        List<Person> sortedAdults = sortByName(adults);
        List<String> names = collectNames(sortedAdults);

        if (!names.isEmpty()) {
            printNames(names);
        } else {
            System.out.println("No names are there");
        }
    }

    private static List<Person> createPeopleList() {
        return List.of(
                new Person("Alice", 23),
                new Person("Bob", 17),
                new Person("Charlie", 20),
                new Person("David", 15),
                new Person("Eve", 19)
        );
    }

    private static List<Person> filterAdults(List<Person> people) {
        return people.filter(person -> person.getAge() >= 18);
    }

    private static List<Person> sortByName(List<Person> people) {
        return people.sortBy(Person::getName);
    }

    private static List<String> collectNames(List<Person> people) {
        return people.map(Person::getName);
    }

    private static void printNames(List<String> names) {
        names.forEach(System.out::println);
    }
}