package pl.dabrowicz;

public class Product {
    private String name;
    private int cost;

    public Product(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void displayProductInformation() {
        System.out.println(name + ", " + cost + "€");
    }

    
    @Override
    public String toString() {
        return String.format(name, cost);
    }
}
