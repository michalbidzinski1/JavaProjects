package tests;

import org.junit.*;
import pl.michalbidzinski.Bank;
import pl.michalbidzinski.Offer;
import pl.michalbidzinski.Product;
import pl.michalbidzinski.Seller;

import java.util.ArrayList;
import java.util.Arrays;


import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import pl.michalbidzinski.visitor.IncreasePrice;
import pl.michalbidzinski.visitor.Visitor;

import static org.junit.jupiter.api.Assertions.*;
public class SellerTest {
    Seller seller;
    Bank bank;
    @BeforeEach
    public void setUp() {
        bank = Bank.getInstance();
    }
    @Test
    public void testGetOffers() {
        seller = new Seller("Test");
        Offer offer = new Offer(new Product("test1"),10, 1);

        // act
        seller.addOffer(offer);

        // assert
        assertTrue(seller.getOffers().contains(offer));
    }
    @Test
    public void testPriceAfterInflation() {
        bank = Bank.getInstance();
        seller = new Seller("Test");
        int price1 = 10;
        Offer offer1 = new Offer(new Product("test1"), price1 , 1);
        Offer offer2 = new Offer(new Product("test2"), price1, 2);
        seller.addOffer(offer1);
        seller.addOffer(offer2);
        bank.setInflation(bank.getInflation() + 0.1);
        List<Double> prices = seller.getOffers().stream().map(Offer::getPrice).collect(Collectors.toList());
        assertEquals(prices, List.of((price1 + price1 * 0.1), price1 + price1 * 0.1));
    }
    @Test
    public void acceptVisitor() {
        seller = new Seller("Test");
        Offer offer1 = new Offer(new Product("Product1"), 10, 1);
        Offer offer2 = new Offer(new Product("Product2"), 11, 1);
        seller.addOffer(offer1);
        seller.addOffer(offer2);
        Visitor visitor = new IncreasePrice();

        seller.acceptMarketChanges(visitor);


        List<Double> prices = seller.getOffers().stream().map(Offer::getPrice).collect(Collectors.toList());

        List<Double> list = new ArrayList<>();
        list.add(10 + 10 * .15);
        list.add(11 + 11 * .15);
        assertEquals(prices, (list));
    }



}