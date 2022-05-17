package pl.michalbidzinski;

public class Discount30Percent implements Discount {

    @Override
    public void execute(Cart cart) {
        cart.getMostExpensiveProduct().setDiscountPrice(cart.getMostExpensiveProduct().getPrice() - 0.3*cart.getMostExpensiveProduct().getPrice());
    }
}