package tests;
import org.junit.*;
import pl.michalbidzinski.*;

import static org.junit.jupiter.api.Assertions.*;
public class BuyerTst {

    @Test
    public void followOfferTest() {
        Offer offer = new Offer(new Product("Product123"), 10, 1);
        Seller seller = new Seller();
        Buyer buyer = new Buyer("Buyer1");
        offer.setSeller(seller);
        buyer.followOffer(offer);
        assertEquals(buyer.getDemand().size(),1 );
    }

}
