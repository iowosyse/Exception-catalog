import java.io.*;
import java.util.*;

public class Seeder {
    public static Catalog catalog = new Catalog();

    public static void fillCatalog() {
        Random ran = new Random();
        ArrayList<Product> possibleProducts = new ArrayList<>();
        HashMap<String, Integer> indexAttribute = new HashMap<>();

        BufferedReader br = null;
        String line;

        try {
            br = new BufferedReader(new FileReader("Products.csv"));
            String[] headers = br.readLine().split(",");

            for (int i = 0; i < headers.length; i++) {
                indexAttribute.put(headers[i], i);
            }

            int iID = indexAttribute.get("ID");
            int iName = indexAttribute.get("name");
            int iPrice = indexAttribute.get("price");
            int iDescription = indexAttribute.get("description");

            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");

                Product newProduct = new Product(row[iID], row[iName], row[iPrice], row[iDescription]);
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
