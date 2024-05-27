public class Product {
    private int ID;
    private String name;
    private double price;
    private String description;
    //pasado de burger

    public Product(int ID, String name, double price, String description) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product(String ID, String name, String price, String description) {
        this.ID = Integer.parseInt(ID);
        this.name = name;
        this.price = Double.parseDouble(price);
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%-2s, %-10s, %-5s, %-20s%n%-2s, %-10s, %-5s, %-20s%n", "ID", "Name", "Price", "Description",
                getID(), getName(), "$" + getPrice(), getDescription());
    }
}