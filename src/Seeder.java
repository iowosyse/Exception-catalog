import java.io.*;
import java.util.*;

public class Seeder {
    public static Catalog catalog = new Catalog();

    public static void start() {
        Random ran = new Random();
        ArrayList<Product> possibleProducts = new ArrayList<>();

        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader("Products.csv"));

            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");

                Product newProduct = new Product(row[0], row[1], row[2], row[3]);
                possibleProducts.add(newProduct);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 10; i++) {
            catalog.addProduct(possibleProducts.get(ran.nextInt(0,5)));
        }
    }
}
