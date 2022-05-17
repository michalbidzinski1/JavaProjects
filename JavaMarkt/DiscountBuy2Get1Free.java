package pl.michalbidzinski;

import java.util.Arrays;

public class DiscountBuy2Get1Free implements Discount{

    public void execute(Cart cart){
        int len = cart.getProducts().length;
        if (len > 2){

            Arrays.stream(cart.getCheapestProduct(len / 3)).forEach(p -> p.setDiscountPrice(0));


        }

    }

}