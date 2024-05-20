import java.util.ArrayList;

public class Catalog {
    private ArrayList<Product> products = new ArrayList<>();

    public Product findById(int id) throws ProductNotFoundException {
        for (Product product : products) {
            if (product.getID() == id){
                return product;
            }
        }

        throw new ProductNotFoundException();
    }

    public Product findByName(String name) throws ProductNotFoundException{
        for (Product product : products) {
            if (product.getName().equals(name)){
                return product;
            }
        }

        throw new ProductNotFoundException();
    }

    public Product findByDescription(String description) throws ProductNotFoundException{
        for (Product product : products) {
            if (product.getDescription().equals(description)){
                return product;
            }
        }

        throw new ProductNotFoundException();
    }

    public void addProduct(Product p){
        products.add(p);
    }

    public void removeProduct(Product p) {
        products.remove(p);
    }

    public boolean removeProduct(String name) throws ProductNotFoundException {
        for (Product p : products) {
            if (p.getName().equals(name))
                return true;
        }

        throw new ProductNotFoundException();
    }
}
