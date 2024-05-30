import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Seeder {
    public static Catalog catalog = new Catalog();

    public static void fillCatalog() {
        Random ran = new Random();
        ArrayList<Product> possibleProducts = new ArrayList<>();
        HashMap<String, Integer> indexAttribute = new HashMap<>();

        String line;

        try (BufferedReader br = new BufferedReader(new FileReader("Products.csv"))){
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
        }

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Binaries.txt"));
             FileWriter fw = new FileWriter("Binaries.txt");
             BufferedWriter bw = new BufferedWriter(fw);
             FileInputStream fis = new FileInputStream("Binaries.txt");
             DataInputStream dis = new DataInputStream(fis)
        ) {
            writeFile(bw, possibleProducts, dos);
            readFile(dis, possibleProducts);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int bound = possibleProducts.size();
        for (int i = 0; i < 5; i++) {
            catalog.addProduct(possibleProducts.get(ran.nextInt(0,bound)));
        }
    }

    //save for later
    public static void readFile(DataInputStream dis, ArrayList<Product> possibleProducts) throws IOException {
        //adds every product from possible products
        while (true) {
            try {
                for (Product p : possibleProducts) {
                    int id = dis.readInt();
                    double price = dis.readDouble();

                    short maxSize = dis.readShort();
                    byte[] nameBytes = new byte[maxSize];

                    for (int i = 0; i < maxSize; i++) {
                        nameBytes[i] = dis.readByte();
                    }
                    String name = new String(nameBytes, StandardCharsets.UTF_8);

                    maxSize = dis.readShort();
                    byte[] descriptionBytes = new byte[maxSize];

                    for (int i = 0; i < maxSize; i++) {
                        descriptionBytes[i] = dis.readByte();
                    }
                    String description = new String(descriptionBytes, StandardCharsets.UTF_8);

                    Product newProduct = new Product(id, name, price, description);
                    catalog.addProduct(newProduct);
                }
            } catch (EOFException e) {
                //when reaching end of file, exit the loop
                break;
            }
        }
    }

    //save for later
    public static void writeFile(BufferedWriter bw, ArrayList<Product> possibleProducts, DataOutputStream dos) throws IOException {
        //for every execution, rewrite the file.
        bw.write("");
        //writing every byte of every possible product
        for (Product p : possibleProducts) {
            dos.writeInt(p.getID());
            dos.writeDouble(p.getPrice());

            short nameLength = (short) p.getName().length();
            dos.writeShort(nameLength);

            byte[] nameBytes = p.getName().getBytes();
            for (byte b : nameBytes) {
                dos.writeByte(b);
            }

            short descriptionLength = (short) p.getDescription().length();
            dos.writeShort(descriptionLength);

            byte[] descriptionBytes = p.getDescription().getBytes();
            for (byte b : descriptionBytes) {
                dos.writeByte(b);
            }
        }
    }
}
