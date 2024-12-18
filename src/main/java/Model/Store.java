package Model;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products;
    public Store() {
        products = new ArrayList<>();
        products.add(new Product("Product-1", 100));
        products.add(new Product("Product-2", 150));
        products.add(new Product("Product-3", 50));
    }

    public void addProduct(String name, double price) throws IllegalArgumentException {
        Product product = new Product(name, price);
        products.add(product);
    }

    public void removeProduct(String name) {
        products = products.stream()
                .filter(product -> !product.getName().equals(name))
                .toList();
    }

    public void updateProduct(String name, double newPrice) {
        products = products.stream()
                .map(product -> {
                    if (product.getName().equals(name)) {
                        return new Product(name, newPrice);
                    }
                    return product;
                }).toList();
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void print() {
        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }
}