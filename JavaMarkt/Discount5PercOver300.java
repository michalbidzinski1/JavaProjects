package pl.michalbidzinski;

public class Discount5PercOver300 implements Discount {
    @Override
    public void execute(Cart cart) {
        if (cart.sum > 300) {
            for(Product i : cart.getProducts()){
                i.setDiscountPrice(i.getDiscountPrice()- (i.getPrice() * 0.05));
            }
        }
        else {
            throw new IllegalArgumentException("The total of the products is less than 300");
        }

    }
}
