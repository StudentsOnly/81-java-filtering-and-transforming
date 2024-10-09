import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

class Main {
    public static void main(String[] args) {

        ArrayList<Product> listWithProducts = new ArrayList<>(List.of(
                new Product("Laptop", "Electronics", 1200),
                new Product("Refrigerator", "Home", 800),
                new Product("Smartphone", "Electronics", 900),
                new Product("Vacuum Cleaner", "Home", 150),
                new Product("Headphones", "Electronics", 120)
        ));

        System.out.println("\n===Printing original list===");
        listWithProducts.forEach(System.out::println);

        System.out.println("\n===Printing filtered sublist===");
        filterProducts(listWithProducts, product -> product.getPrice() > 500).forEach(System.out::println);

        //modifies original list
        //System.out.println("\n===Printing transformed list===");
        //transformProductNames(listWithProducts, String::toUpperCase).forEach(System.out::println);

        // creates and modifies new list
        System.out.println("\n===Printing transformed list===");
        transformProductNamesToDifferentArrayList(listWithProducts, String::toUpperCase).forEach(System.out::println);

        System.out.println("\n===Printing original list again===");
        listWithProducts.forEach(System.out::println);
    }

    /**
     * Creates new ArrayList with filtered references to same instances of Products
     * @param products
     * @param p
     * @return ArrayList with references to same instances
     */

    static ArrayList<Product> filterProducts(ArrayList<Product> products, Predicate<Product> p) {
        ArrayList<Product> outputList = new ArrayList<>();
        products.forEach(product -> {
            if (p.test(product)) outputList.add(product);
        });
        return outputList;
    }

    /**
     * Transforms names in original ArrayList
     *
     * @param products
     * @param uop
     */
    static void transformProductNames(ArrayList<Product> products, UnaryOperator<String> uop) {
        products.forEach(p -> p.setName(uop.apply(p.getName())));
    }

    /**
     * Creates copy of ArrayList with separate instances of Products and changes names in them
     *
     * @param products
     * @param uop
     * @return ArrayList with separate instances of Products with transformed names
     */
    static ArrayList<Product> transformProductNamesToDifferentArrayList(ArrayList<Product> products, UnaryOperator<String> uop) {
        ArrayList<Product> output = new ArrayList<>();
        products.forEach(s -> output.add(s.clone()));
        transformProductNames(output, uop);
        return output;
    }

}
