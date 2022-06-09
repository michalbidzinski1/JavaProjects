package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.*;
import pl.michalbidzinski.*;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
public class BuyerTst {

    @Test
    public void followOffer() {
        Offer offer = new Offer(new Product("Product123"), 10, 1);
        Seller seller = new Seller("XD");
        Buyer buyer = new Buyer("Buyer1");
        offer.setSeller(seller);
        buyer.followOffer(offer);
        assertEquals(buyer.getInterests().size(),1 );
    }

}
