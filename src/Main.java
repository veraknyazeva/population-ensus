import java.util.*;


public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        persons.stream()
                .filter(person -> person.getAge() < 18)
                .forEach(System.out::println);

        List<String> lastNames = persons.stream()
                .filter(person -> person.getSex().equals(Sex.MAN))
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 27)
                .map(person -> person.getFamily())
                .toList();
        System.out.println(lastNames);


        persons.stream()
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .filter(person -> {
                    if(person.getSex().equals(Sex.WOMAN) ){
                        return person.getAge() >= 18 && person.getAge() <= 60;
                    } else {
                        return person.getAge() >= 18 && person.getAge() <= 65;
                    }
                })
                .sorted((person1, person2) -> person1.getFamily().compareTo(person2.getFamily()))
                .forEach(System.out::println);

    }
}