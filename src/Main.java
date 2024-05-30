import Entities.Catalog;
import Utilities.ConsoleReader;
import Utilities.ProductNotFoundException;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        Seeder.fillCatalog(catalog);

        menu(catalog);
    }

    public static void findProducts(Catalog catalog) {
        int opt;
        do {
            System.out.println("-----------------------------------");
            System.out.println("Find products by:");
            System.out.println("1. ID");
            System.out.println("2. Name");
            System.out.println("3. Description");
            System.out.println("------------------");
            System.out.println("0. Exit");
            opt = ConsoleReader.readInteger();

            switch (opt) {
                case 1 -> {
                    int id;
                    try {
                        System.out.println("Enter the ID");
                        id = ConsoleReader.readInteger();
                        System.out.println("You got : ");
                        System.out.println(catalog.findById(id));
                    } catch (ProductNotFoundException e) {
                        System.out.println("-- That product does not exist --");
                        System.out.println();
                    }
                } case 2 -> {
                    String name;
                    try {
                        System.out.println("Enter the name");
                        name = ConsoleReader.readString();
                        System.out.println("You got:");
                        System.out.println(catalog.findByName(name));
                    } catch (ProductNotFoundException e) {
                        System.out.println("-- That product does not exist --");
                        System.out.println();
                    }
                } case 3 -> {
                    String description;
                    try {
                        System.out.println("Enter the description");
                        description = ConsoleReader.readString();
                        System.out.println("You got: ");
                        System.out.println(catalog.searchByDescription(description));
                    } catch (ProductNotFoundException e) {
                        System.out.println("-- That product does not exist --");
                        System.out.println();
                    }
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Not an option.");
            }
        } while (opt != 0);
    }

    public static void menu(Catalog catalog) {
        int opt;

        do {
            System.out.println("-----------------------------------");
            System.out.println("1. Search products.");
            System.out.println("2. Export catalog as binary file");
            System.out.println("0. Exit");

            opt = ConsoleReader.readInteger();

            switch (opt) {
                case 1 -> findProducts(catalog);
                case 2 -> catalog.exportBinaryFile();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Not an option");
            }
        } while (opt != 0);
    }
}