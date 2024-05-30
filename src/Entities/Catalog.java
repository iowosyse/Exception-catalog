package Entities;

import Utilities.Colors;
import Utilities.ProductNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Catalog {
    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product findById(int id) throws ProductNotFoundException {
        for (Product product : products) {
            if (product.getID() == id){
                return product;
            }
        }

        throw new ProductNotFoundException();
    }

    public Product findByName(String name) throws ProductNotFoundException {
        for (Product product : products) {
            if (product.getName().equals(name)){
                return product;
            }
        }

        throw new ProductNotFoundException();
    }

    public Product searchByDescription(String description) throws ProductNotFoundException {
        for (Product product : products) {
            if (product.getDescription().contains(description)) {
                return product;
            }
        }

        throw new ProductNotFoundException();
    }

    public void addProduct(Product p){
        products.add(p);
    }

    public boolean removeProduct(Product p) throws ProductNotFoundException {
        for (Product ps : products) {
            if (p.equals(ps)){
                products.remove(p);
                return true;
            }
        }
        throw new ProductNotFoundException();
    }

    public boolean removeProduct(String name) throws ProductNotFoundException {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                products.remove(p);
                return true;
            }
        }

        throw new ProductNotFoundException();
    }

    public void exportBinaryFile() {
        File Binaries = new File("C:\\Users\\cande\\OneDrive\\Escritorio\\Tec uwu\\POO\\U5\\catalogo pt2\\BinariesExported.txt");
        try (FileOutputStream fos = new FileOutputStream(Binaries);
             DataOutputStream dos = new DataOutputStream(fos)) {

            for (Product p : products) {
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

            System.out.println("Exported successfully");
        } catch (IOException e) {
            System.out.println(Colors.yellow + "An error occurred during the writing of the file.\n" +
                    "The resulting file may be corrupted" + Colors.reset);
            e.printStackTrace();
        }
    }
}
