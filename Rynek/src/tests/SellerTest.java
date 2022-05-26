package tests;

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
public class SellerTest {

    Seller seller;
    Bank bank;
    @BeforeEach
    public void setUp() {

        bank = Bank.getInstance();
    }
    @Test
    public void listOffer() {
        // arrange
        seller = new Seller("Test");
        Offer offer = new Offer(new Product("test1"),10, 1);

        // act
        seller.addOffer(offer);

        // assert
        assertTrue(seller.getOffers().contains(offer));
    }



}