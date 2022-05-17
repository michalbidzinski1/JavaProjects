package pl.michalbidzinski;

import java.util.Arrays;
import java.util.Comparator;

public class Cart {
    public Product[] products = new Product[0];
    public double sum = 0;
    private Discount[] discounts = new Discount[0];
    Comparator<Product> compareByPriceASC = Comparator.comparing(Product::getDiscountPrice);
    Comparator<Product> compareByPriceDESC = Comparator.comparing(Product::getDiscountPrice).reversed();


    public void sortByPriceDESC() {
        Arrays.sort(this.products, compareByPriceDESC);
    }
    public void sortByPriceASC() {
        Arrays.sort(this.products, compareByPriceASC);
    }
    public void sortByNameASC() {
        Comparator<Product> compareByNameASC = Comparator.comparing(Product::getName);
        Arrays.sort(this.products, compareByNameASC);
    }
    public void sortByNameDESC() {
        Comparator<Product> compareByNameDESC = Comparator.comparing(Product::getName).reversed();
        Arrays.sort(this.products, compareByNameDESC);
    }


    public Product getCheapestProduct() {
            Product[] products = this.products;
            Arrays.sort(this.products, compareByPriceASC);

            return products[0];
        }
    public Product[] getCheapestProduct(int n) {


        Product[] products = this.products;
        Arrays.sort(this.products, compareByPriceASC);

        return Arrays.copyOfRange(products, 0, n);
    }
    public Product getMostExpensiveProduct() {
        Product[] products = this.products;
        Arrays.sort(this.products, compareByPriceDESC);

        return products[0];
    }
    public Product[] getMostExpensiveProduct(int n) {

        Product[] products = this.products;
        Arrays.sort(this.products, compareByPriceDESC);

        return Arrays.copyOfRange(products, 0, n);
    }
    public void addDiscount(Discount discount){
        discounts = Arrays.copyOf(discounts, discounts.length + 1);
        discounts[discounts.length - 1] = discount;
        this.sortProducts();
    }
    private void sortProducts() {
        Comparator<Product> byPrice = Comparator.comparing(Product::getPrice);
        Comparator<Product> byName = Comparator.comparing(Product::getName);
        Arrays.sort(this.products, byPrice.thenComparing(byName));
    }
    public void add(Product product) {
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = product;
        sum += product.price;
        this.sortProducts();
    }

    public Product[] getProducts() {
        return products;
    }
    public void executeDiscount(Cart cart) throws  Exception {
        for(Discount d : cart.discounts){
            d.execute(this);
        }
    }

    public double totalAfterDiscounts() {
        return Arrays.stream(products)
                .mapToDouble(Product::getDiscountPrice)
                .sum();
    }
    public double totalRetailPrice(){
        return sum;
    }
}
