package tests;

import org.junit.*;
import pl.michalbidzinski.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
public class BankTest {
    @Test
    public void updateInflationAfterTransaction() {
        // arrange
        Bank bank = Bank.getInstance();
        Buyer buyer = new Buyer("Test");
        Seller seller = new Seller("Test");
        Offer offer = new Offer(new Product("test"), 10, 1);
        Offer offer2 = new Offer(new Product("test2"), 10 * 10, 1);
        seller.addOffer(offer);
        seller.addOffer(offer2);
        double inflation = bank.getInflation();

        // act
        offer.buy(buyer);
        offer2.buy(buyer);
//
        // assert
//        assertEquals(bank.getInflation(), );
//        assertTrue(bank.getInflation())
//                .isGreaterThan(inflation);
    }



}