package pl.dabrowicz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Machine implements Task {
    Scanner scanner = new Scanner(System.in);
    private final List<Product> productList = new ArrayList();
    private int account = 0;

    Product product0 = new Product("", 0);
    Product product1 = new Product("1. Cola", 3);
    Product product2 = new Product("2. Candy Bar", 2);
    Product product3 = new Product("3. Potatoe", 1);
    Product product4 = new Product("4. Milk", 3);
    Product product5 = new Product("5. Cookies", 5);
    Product product6 = new Product("6. Cigarettes", 10);
    Product product7 = new Product("7. Chocolate", 4);
    Product product8 = new Product("8. Pencil", 1);
    Product product9 = new Product("9. Face mask", 4);
    Product product10 = new Product("10. Soap", 6);

    @Override
    public void run() {
        boolean shouldContinue = true;

        Machine machine = new Machine();
        machine.addProducts();

        while (shouldContinue) {
            System.out.println("************************************************");
            System.out.println("Hello! I'm Vending Machine. Products:");
            System.out.println("************************************************");
            System.out.println();
            machine.displayProducts();
            System.out.println();
            System.out.println("************************************************");
            System.out.println("Choose options:");
            System.out.println("1. Insert coins");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    machine.startMenu();
                case 2:
                    System.out.println("Turning off the system.");
                    shouldContinue = false;
                    break;
            }
        }
    }

    public void addProducts() {
        productList.add(product0);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        productList.add(product10);
    }

    public void displayProducts() {
        Consumer<Product> c = Product::displayProductInformation;
        productList.stream()
                .skip(1)
                .forEach(c);
        /*  for (Product product : productList) {
            product.displayProductInformation();
        }*/
    }

        public void displayAccount () {
            System.out.println("Your balance is: " + account + " PLN");
        }

        public void startMenu () {
            System.out.println("Insert coin: (1, 2, 5 PLN)");
            insertCoin();
            buyProduct();
        }

        public void insertCoin () {
            while (true) {
                int coin = scanner.nextInt();

                if (coin == 1) {
                    account++;
                } else if (coin == 2) {
                    account = account + 2;
                } else if (coin == 5) {
                    account = account + 5;
                } else if (coin == 0) {
                    break;
                } else {
                    System.out.println("You are not allowed to use this coin.");
                }

                displayAccount();
                System.out.println("You tossed " + coin + " PLN");
                System.out.println("Toss another or buy?");
                System.out.println("Press '0' to buy a product.");
            }
        }

        public void buyProduct () {
            displayProducts();
            System.out.println();
            System.out.println("Choose product: ");
            int choice = scanner.nextInt();

            Product chosenProduct = productList.get(choice);
            int cost = chosenProduct.getCost();

            if (account >= cost) {
                System.out.println("You choose " + chosenProduct);
                System.out.println();
                account = account - cost;
                displayAccount();
            } else {
                System.out.println("You don't have enough money balance. Insert some coins.");
                displayAccount();
            }
            startMenu();
        }
    }

