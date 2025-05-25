import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ethan", "Foster", 27));
        people.add(new Person("Charlotte", "Harrison", 35));
        people.add(new Person("James", "Russell", 23));
        people.add(new Person("Amelia", "Sullivan", 40));
        people.add(new Person("Benjamin", "Coleman", 29));
        people.add(new Person("Lily", "Peterson", 32));
        people.add(new Person("Henry", "Gonzalez", 26));
        people.add(new Person("Ella", "Morales", 37));
        people.add(new Person("Daniel", "Carter", 21));
        people.add(new Person("Grace", "Evans", 45));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name to search (first or last): ");
        String search = scanner.nextLine().toLowerCase();

        List<Person> matches = people.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(search) || p.getLastName().equalsIgnoreCase(search))
                .collect(Collectors.toList());

        System.out.println("Matching people:");
        for (Person p : matches) {
            System.out.println(p);
        }

        // Step 3: Age stats
        if (!people.isEmpty()) {
            double averageAge = people.stream()
                    .mapToInt(Person::getAge)
                    .average()
                    .orElse(0);

            int maxAge = people.stream()
                    .mapToInt(Person::getAge)
                    .max()
                    .orElse(0);

            int minAge = people.stream()
                    .mapToInt(Person::getAge)
                    .min()
                    .orElse(0);

            System.out.printf("\nAverage Age: %.2f\n", averageAge);
            System.out.println("Oldest Age: " + maxAge);
            System.out.println("Youngest Age: " + minAge);
        }
    }
}