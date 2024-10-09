import java.util.Random;

public class Product {
  private String name;
  private double price;
  private String category;
  private static final Random random = new Random();

  private Product(String name, double price, String category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }

  public static Product getRandom() {
    String[] name = {"Apple", "Banana", "Lemon", "Cabbage", "Lettuce"};
    String[] prefix = {"common", "uncommon", "rare", "unique", "epic", "legendary"};
    String[] categories = {"Fruit", "Electronics", "Appliances", "Vegetables", "Weapon"};

    String fullName = prefix[random.nextInt(0, prefix.length)] + " " +
      name[random.nextInt(0, name.length)];
    double price = random.nextDouble(9.99, 1_000.0);
    String category = categories[random.nextInt(0, categories.length)];
    return new Product(fullName, price, category);

  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getCategory() {
    return category;
  }

  @Override
  public String toString() {
    return "%s($%.2f, %s)".formatted(name, price, category);
  }
}
