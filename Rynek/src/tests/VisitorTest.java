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
import pl.michalbidzinski.visitor.DecreasePriceVisitor;
import pl.michalbidzinski.visitor.IncreasePrice;
import pl.michalbidzinski.visitor.Visitor;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class VisitorTest {
    Product product;
    Offer offer;

    @BeforeEach
    public void setUp() {
        offer = new Offer(product, 10, 1);
    }
    @Test
    public void testHighDecreaseVisitOffer() {

        Visitor visitor = new DecreasePriceVisitor();

        visitor.visit(offer);
        assertEquals(offer.getPrice(), 10 + 10 * -.15);

    }

    @Test
    public void testIncreaseVisitOffer() {

        Visitor visitor = new IncreasePrice();

        visitor.visit(offer);
        assertEquals(offer.getPrice(), 10 + 10 * .15);

    }


}
