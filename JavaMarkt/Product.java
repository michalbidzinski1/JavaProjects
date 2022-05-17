package pl.michalbidzinski;

public class Product {
    public String code;
    public String name;
    public double price;
    public double discountPrice;

    public Product(String code, String name, double price){
        if(price < 0) throw new IllegalArgumentException("Price must be a positive number");
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = price;
    }

    public void setPrice(double price) { this.price = price; }
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }
    public void setDiscountPrice(double discountPrice) { this.discountPrice = discountPrice; }
}
