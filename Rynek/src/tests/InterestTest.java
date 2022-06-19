package tests;
import org.junit.jupiter.api.Test;
import pl.michalbidzinski.Buyer;
import pl.michalbidzinski.Interest;
import pl.michalbidzinski.Offer;
import pl.michalbidzinski.Product;
import pl.michalbidzinski.Seller;


import static org.junit.jupiter.api.Assertions.*;

public class InterestTest {
    @Test
    public void updateDemandAfterPriceChangeTest() {
        Buyer buyer = new Buyer("Buyer1");
        Offer offer = new Offer(new Product("Product1"), 10, 1);
        Interest interest = new Interest(offer, buyer);
        interest.setDemand(0.5);
        offer.addObserver(interest);
        double currentInterest = interest.getDemand();
        offer.increasePrice(1);

        assertNotEquals(interest.getDemand(), currentInterest);


    }
    @Test
    public void buyIfIntrestedTest() {
        Buyer buyer = new Buyer("Buyer1");
        Product p1 = new Product("Product1423");
        Seller seller = new Seller();
        Offer offer = new Offer(p1, 610, 1);
        seller.addOffer(offer);
        Interest interest = new Interest(offer, buyer);
        offer.addObserver(interest);
        interest.setDemand(0.75);

        offer.increasePrice(-512);
        assertTrue(buyer.getPucharsedProducts().contains(p1));

    }


}
