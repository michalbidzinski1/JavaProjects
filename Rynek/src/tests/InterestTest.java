package tests;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.michalbidzinski.Buyer;
import pl.michalbidzinski.Interest;
import pl.michalbidzinski.Offer;
import pl.michalbidzinski.Product;
import org.junit.*;
import pl.michalbidzinski.Bank;
import pl.michalbidzinski.Offer;
import pl.michalbidzinski.Product;
import pl.michalbidzinski.Seller;

import java.util.Arrays;


import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
public class InterestTest {
    @Test
    public void updateAfterPriceChange() {
        Buyer buyer = new Buyer("Buyer1");
        Offer offer = new Offer(new Product("Product1"), 10, 1);
        Interest interest = new Interest(offer, buyer);
        interest.setInterest(0.5);
        offer.addObserver(interest);
        double currentInterest = interest.getInterest();
        offer.increasePrice(1);

        assertNotEquals(interest.getInterest(), currentInterest);


    }
    @Test
    public void buyIfInterestIncrease() {
        Buyer buyer = new Buyer("Buyer1");
        Product p1 = new Product("Product1423");
        Seller seller = new Seller("Seller1");
        Offer offer = new Offer(p1, 610, 1);
        seller.addOffer(offer);
        Interest interest = new Interest(offer, buyer);
        offer.addObserver(interest);
        interest.setInterest(0.75);

        offer.increasePrice(-512);
        assertTrue(buyer.getBoughtProducts().contains(p1));

    }


}
