import Entities.Catalog;
import Entities.Product;

import java.io.*;

public class Seeder {
    public static void fillCatalog(Catalog catalog) {
        //createFile();
        readFile(catalog);
    }

    public static void createFile() {
        File Binaries = new File("C:\\Users\\cande\\OneDrive\\Escritorio\\Tec uwu\\POO\\U5\\catalogo pt3\\Binaries.txt");

        try (FileOutputStream fos = new FileOutputStream(Binaries);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(new Product(1, "Mazapan", 5, "Dulce de cacahuate"));
            oos.writeObject(new Product(2, "Doritos", 20, "Totopos sabor nacho"));
            oos.writeObject(new Product(3, "Chela", 20, "Bebida alcohólica"));
            oos.writeObject(new Product(4, "Coca", 20, "Refresco sabor cola"));
            oos.writeObject(new Product(5, "Chicles", 25, "Dulce para masticar sabor menta"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(Catalog catalog) {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\cande\\OneDrive\\Escritorio\\Tec uwu\\POO\\U5\\catalogo pt3\\Binaries.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            catalog.addProduct((Product) ois.readObject());
            catalog.addProduct((Product) ois.readObject());
            catalog.addProduct((Product) ois.readObject());
            catalog.addProduct((Product) ois.readObject());
            catalog.addProduct((Product) ois.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
