package pl.michalbidzinski;

public class DiscountFreeCup implements Discount {
    @Override
    public void execute(Cart cart) throws Exception {
        if (cart.sum >= 200) {
            cart.add(new Product("000", "Cup", 0));
        }

    }
}