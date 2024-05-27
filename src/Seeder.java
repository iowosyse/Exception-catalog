import java.io.*;
import java.util.*;

public class Seeder {
    public static Catalog catalog = new Catalog();

    public static void fillCatalog() {
        Random ran = new Random();
        ArrayList<Product> possibleProducts = new ArrayList<>();

        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader("Products.csv"));
            //No use at all
            String[] headers = br.readLine().split(",");

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

        int bound = possibleProducts.size();
        for (int i = 0; i < 10; i++) {
            catalog.addProduct(possibleProducts.get(ran.nextInt(0,bound)));
        }
    }
}
