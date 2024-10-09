import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {

    System.out.println("Peek of Product List");
    System.out.println("-------------------------------------");

    List<Product> products = Stream.generate(Product::getRandom)
      .limit(100)
      .peek(System.out::println)
      .toList();
    System.out.println("Product count: " + products.size());
    System.out.println("-------------------------------------\n");

    System.out.println("Filtered Products price > $600.00 and < $700.00");
    System.out.println("-------------------------------------");
    var filteredProducts = filterProducts(products,
      p -> p.getPrice() > 600.00 && p.getPrice() < 700.00);
    filteredProducts.forEach(System.out::println);
    System.out.println("Filtered Product count: " + filteredProducts.size());
    System.out.println("-------------------------------------\n");

    System.out.println("Transformed Products");
    System.out.println("-------------------------------------");
    var transformedProducts = transformProductNames(products, p -> p.getName().toUpperCase());
    transformedProducts.forEach(System.out::println);
    System.out.println("Transformed Product count: " + transformedProducts.size());

  }

  private static List<Product> filterProducts(List<Product> products,
                                              Predicate<Product> predicate) {
    return products.stream()
      .filter(predicate)
      .toList();
  }

  private static List<String> transformProductNames(List<Product> products,
                                                    Function<Product, String> function) {
    return products.stream()
      .map(function)
      .sorted()
      .toList();
  }
}
