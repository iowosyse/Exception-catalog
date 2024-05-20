import java.util.Random;

public class Seeder {
    public static Catalog catalog = new Catalog();

    public static void start() {
        Random ran = new Random();

        Product[] availableProducts = new Product[5];
        availableProducts[0] = new Product(1, "Mazapan", 5, "Dulce de cacahuate");
        availableProducts[1] = new Product(2, "Doritos", 18, "Totopos sabor nacho");
        availableProducts[2] = new Product(3, "Chicles", 22, "Goma refrescante");
        availableProducts[3] = new Product(4, "Chela", 20, "Bebida alcoholica");
        availableProducts[4] = new Product(5, "Coca-Cola", 18, "Refresco sabor cola");

        for (int i = 0; i < 10; i++) {
            catalog.addProduct(availableProducts[ran.nextInt(0,5)]);
        }
    }
}
