import Entities.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Seeder {
    public static void fillCatalog(Catalog catalog) {
        createFile(catalog);
        ArrayList<Product> products = readFile();

        for (int i = 0; i < readFile().size(); i++) {
            catalog.addProduct(products.get(i));
        }
    }

    public static ArrayList<Product> readFile(){
        ArrayList<Product> products = new ArrayList<>();

        try (
                FileInputStream fis = new FileInputStream("Binaries.txt");
                DataInputStream dis = new DataInputStream(fis)
                ) {
            int id;
            double price;
            short maxLength;
            String name, description;

            while (true) {
                try {
                    id = dis.readInt();

                    maxLength = dis.readShort();

                    byte[] bytes = new byte[maxLength];
                    for (int i = 0; i < maxLength; i++) {
                        bytes[i] = dis.readByte();
                    }
                    name = new String(bytes, StandardCharsets.UTF_8);

                    price = dis.readDouble();

                    maxLength = dis.readShort();
                    bytes = new byte[maxLength];

                    for (int i = 0; i < maxLength; i++) {
                        bytes[i] = dis.readByte();
                    }
                    description = new String(bytes, StandardCharsets.UTF_8);

                    products.add(new Product(id, name, price, description));
                } catch (EOFException e) {
                    break;
                }
            }

            return products;
        } catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

        return null;
    }

    public static void createFile(Catalog catalog) {
        Product p1 = new Product(1, "Mazapan", 5, "Dulce de cacahuate");
        Product p2 = new Product(2, "Doritos", 20, "Totopos sabor nacho");
        Product p3 = new Product(3, "Chela", 20, "Bebida alcohólica");
        Product p4 = new Product(4, "Coca", 20, "Refresco sabor cola");
        Product p5 = new Product(5, "Chicles", 25, "Dulce para masticar sabor menta");

        catalog.addProduct(p1);
        catalog.addProduct(p2);
        catalog.addProduct(p3);
        catalog.addProduct(p4);
        catalog.addProduct(p5);

        File Binaries = new File("C:\\Users\\cande\\OneDrive\\Escritorio\\Tec uwu\\POO\\U5\\catalogo pt2\\Binaries.txt");

        try (
                FileOutputStream fos = new FileOutputStream(Binaries);
                DataOutputStream dos = new DataOutputStream(fos)
        ) {

            for (Product p : catalog.getProducts()) {
                dos.writeInt(p.getID());

                short maxLength = (short) p.getName().length();
                dos.writeShort(maxLength);

                byte[] nameBytes = p.getName().getBytes();
                for (int i = 0; i < maxLength; i++) {
                    dos.writeByte(nameBytes[i]);
                }

                dos.writeDouble(p.getPrice());

                maxLength = (short) p.getDescription().length();
                dos.writeShort(maxLength);

                byte[] descriptionBytes = p.getDescription().getBytes();
                for (int i = 0; i < maxLength; i++) {
                    dos.writeByte(descriptionBytes[i]);
                }
            }

        } catch (IOException e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        }
    }
}
