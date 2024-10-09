import java.util.*;
import java.util.function.*;

public class FilterTransformData {
    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("Laptop", 1200.99, "Electronics"),
                new Product("Headphones", 150.50, "Electronics"),
                new Product("Food Processor", 199.99, "Appliances"),
                new Product("Sofa", 850.00, "Furniture"),
                new Product("Desk", 350.00, "Furniture"),
                new Product("Projector", 950.00, "Electronics")
        );

        System.out.println("\nInitial list of products:\n");
        products.forEach(System.out::println);

        Predicate<Product> isElectronics = product -> "Electronics".equals(product.category);

        List<Product> filteredProducts = filterProducts(products, isElectronics);
        System.out.println("\nFiltered Products - only Electronics:\n");
        filteredProducts.forEach(System.out::println);


        Function<Product, String> toUpperCaseName = product -> product.name.toUpperCase();
        List<String> transformedNames = transformProductNames(products, toUpperCaseName);

        System.out.println("\nTransformed Product Names - all Uppercase:\n");
        transformedNames.forEach(System.out::println);
    }

    private static List<Product> filterProducts(List<Product> products, Predicate<Product> filter) {
        List<Product> filteredProducts = new ArrayList<>();
        products.forEach(product -> {
            if (filter.test(product)) {
                filteredProducts.add(product);
            }
        });
        return filteredProducts;
    }

    private static List<String> transformProductNames(List<Product> products, Function<Product, String> function) {
        List<String> transformedNames = new ArrayList<>();
        products.forEach(product -> transformedNames.add(function.apply(product)));
        return transformedNames;
    }
}
