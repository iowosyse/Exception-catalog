import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt;
        Seeder.start();

        do {
            System.out.println("Find products by:");
            System.out.println("1. ID");
            System.out.println("2. Name");
            System.out.println("3. Description");
            System.out.println("------------------");
            System.out.println("0. Exit");
            System.out.print(">> ");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1 -> {
                    int id;
                    try {
                        System.out.println("Enter the ID");
                        System.out.print(">> ");
                        id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("You got : " + Seeder.catalog.findById(id));
                        System.out.println();
                    } catch (ProductNotFoundException e) {
                        System.out.println("-- That product does not exist --");
                        System.out.println();
                    }
                } case 2 -> {
                    String name;
                    try {
                        System.out.println("Enter the name");
                        System.out.print(">> ");
                        name = sc.nextLine();
                        System.out.println("You got: " + Seeder.catalog.findByName(name));
                        System.out.println();
                    } catch (ProductNotFoundException e) {
                        System.out.println("-- That product does not exist --");
                        System.out.println();
                    }
                } case 3 -> {
                    String description;
                    try {
                        System.out.println("Enter the description");
                        System.out.print(">> ");
                        description = sc.nextLine();
                        System.out.println("You got: " + Seeder.catalog.findByDescription(description));
                        System.out.println();
                    } catch (ProductNotFoundException e) {
                        System.out.println("-- That product does not exist --");
                        System.out.println();
                    }
                } case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Not an option.");
            }
        } while (opt != 0);
    }
}