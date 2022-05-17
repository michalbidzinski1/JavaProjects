package pl.michalbidzinski;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testGetCode() {
        Product fridge = new Product("123", "Fridge", 2000);
        String code = fridge.getCode();
        assertEquals(code, fridge.getCode());
    }

    @Test
    public void testGetName() {
        Product fridge = new Product("123", "Fridge", 2000);
        assertEquals("Fridge", fridge.getName());
    }

    @Test
    public void testGetPrice() {
        Product fridge = new Product("123", "Fridge", 2000);
        assertEquals(2000, fridge.getPrice());
    }

    @Test
    public void testGetDiscountPrice() {
        Product fridge = new Product("123", "Fridge", 2000);
        assertEquals(2000, fridge.getDiscountPrice());
    }



    @Test
    public void testSetPrice() {
        Product fridge = new Product("123", "Fridge", 2000);
        fridge.setPrice(2000);
        assertEquals(2000, fridge.getPrice());
    }

    @Test
    public void testSetDiscountPrice() {
        Product fridge = new Product("123", "Fridge", 2000);
        fridge.setDiscountPrice(2000);
        assertEquals(2000, fridge.getDiscountPrice());
    }

}