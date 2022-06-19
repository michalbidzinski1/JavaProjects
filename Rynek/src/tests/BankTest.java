package tests;

import org.junit.*;
import pl.michalbidzinski.*;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.jupiter.api.Assertions.*;
public class BankTest {
    @Test
    public void updateInflationTest() {
        Bank bank = Bank.getBank();
        Buyer buyer = new Buyer("Buyer1");
        Seller seller = new Seller();
        Offer offer = new Offer(new Product("Product1"), 10, 1);
        Offer offer2 = new Offer(new Product("Product2"), 10 * 10, 1);
        seller.addOffer(offer);
        seller.addOffer(offer2);
        double inflation = bank.getInflation();
        offer.buy(buyer);
        offer2.buy(buyer);
        assertNotEquals(bank.getInflation(), inflation);
    }



}