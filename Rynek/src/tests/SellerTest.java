package tests;

import org.junit.*;
import pl.michalbidzinski.Bank;
import pl.michalbidzinski.Offer;
import pl.michalbidzinski.Product;
import pl.michalbidzinski.Seller;

import java.util.ArrayList;


import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import pl.michalbidzinski.visitor.VisitorIncreasePrice;
import pl.michalbidzinski.visitor.Visitor;

import static org.junit.jupiter.api.Assertions.*;
public class SellerTest {
    Seller seller;
    Bank bank;
    @BeforeEach
    public void setUp() {
        bank = Bank.getBank();
    }
    @Test
    public void testGetOffers() {
        seller = new Seller();
        Offer offer = new Offer(new Product("Product1"),10, 1);
        seller.addOffer(offer);
        assertTrue(seller.getOffers().contains(offer));
    }
    @Test
    public void testPricesAfterInflation() {
        bank = Bank.getBank();
        seller = new Seller();
        int price1 = 10;
        Offer offer1 = new Offer(new Product("Product1"), price1 , 1);
        Offer offer2 = new Offer(new Product("Product2"), price1, 2);
        seller.addOffer(offer1);
        seller.addOffer(offer2);
        bank.setInflation(bank.getInflation() + 0.5);
        List<Double> prices = seller.getOffers().stream().map(Offer::getPrice).collect(Collectors.toList());
        assertEquals(prices, List.of((price1 + price1 * 0.5), price1 + price1 * 0.5));
    }
    @Test
    public void testVisitorAccept() {
        seller = new Seller();
        Offer offer1 = new Offer(new Product("Product1"), 10, 1);
        Offer offer2 = new Offer(new Product("Product2"), 11, 1);
        seller.addOffer(offer1);
        seller.addOffer(offer2);
        Visitor visitor = new VisitorIncreasePrice();
        seller.acceptChanges(visitor);
        List<Double> prices = seller.getOffers().stream().map(Offer::getPrice).collect(Collectors.toList());
        List<Double> list = new ArrayList<>();
        list.add(10 + 10 * 0.2);
        list.add(11 + 11 * 0.2);
        assertEquals(prices, (list));
    }



}