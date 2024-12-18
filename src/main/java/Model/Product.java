package Model;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        if (name.length() > 100) {
            throw new IllegalArgumentException
                    ("name length can't be greater than 100 char");
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price can't be negative");
        }
        this.price = price;
    }
    public String toString() {
        return "Product{" + "name = '" + name + '\'' + ", price = " + price + '}';
    }
}