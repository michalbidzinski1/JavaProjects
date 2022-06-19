package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.michalbidzinski.Offer;
import pl.michalbidzinski.Product;


import pl.michalbidzinski.visitor.VisitorDecreasePrice;
import pl.michalbidzinski.visitor.VisitorIncreasePrice;
import pl.michalbidzinski.visitor.Visitor;

import static org.junit.jupiter.api.Assertions.*;

public class VisitorTest {
    Product product;
    Offer offer;

    @BeforeEach
    public void setUp() {
        offer = new Offer(product, 10, 1);
    }
    @Test
    public void testDecreaseOffer() {
        Visitor visitor = new VisitorDecreasePrice();
        visitor.visit(offer);
        assertEquals(offer.getPrice(), 10 + 10 * -0.20);

    }

    @Test
    public void testIncreaseVisitorOffer() {

        Visitor visitor = new VisitorIncreasePrice();

        visitor.visit(offer);
        assertEquals(offer.getPrice(), 10 + 10 * 0.20);

    }


}
