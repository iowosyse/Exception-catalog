package Entities;

import Utilities.ProductNotFoundException;

import java.util.ArrayList;

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
}
