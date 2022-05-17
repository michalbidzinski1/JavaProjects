package pl.michalbidzinski;
import org.junit.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
public class CartTest {
    @Test
    public void testAdd() {
        Cart cart = new Cart();
        Product fridge = new Product("123", "Fridge", 3339);
        cart.add(fridge);
        assertEquals(fridge, cart.getProducts()[0]);
    }
    @Test
    public void testGetTheCheapest() {
        Cart cart = new Cart();
        Product fridge = new Product("123", "Fridge", 3339);
        Product table = new Product("122", "Table", 11233);
        cart.add(fridge);
        cart.add(table);
        assertEquals(fridge, cart.getCheapestProduct());
    }
    @Test
    public void testGetTheMostExpensive() {
        Cart cart = new Cart();
        Product fridge = new Product("123", "Fridge", 3339);
        Product table = new Product("122", "Table", 11233);
        cart.add(fridge);
        cart.add(table);
        assertEquals(table, cart.getMostExpensiveProduct());
    }
    @Test
    public void testGetTheNCheapestElements() {
        Cart cart = new Cart();
        Product fridge = new Product("123", "Fridge", 3339);
        Product table = new Product("122", "Table", 11233);
        Product water = new Product("124", "Water", 12);
        cart.add(fridge);
        cart.add(table);
        cart.add(water);
        assertEquals(2, cart.getCheapestProduct(2).length);
    }
    @Test
    public void testGetTheNMostExpensiveElements() {
        Cart cart = new Cart();
        Product fridge = new Product("123", "Fridge", 3339);
        Product table = new Product("122", "Table", 11233);
        Product water = new Product("124", "Water", 12);
        cart.add(fridge);
        cart.add(table);
        cart.add(water);
        assertEquals(2, cart.getMostExpensiveProduct(2).length);
    }
    @Test
    public void testTotal() {
        Cart cart = new Cart();
        Product fridge = new Product("123", "Fridge", 100);
        Product table = new Product("122", "Table", 200);
        cart.add(fridge);
        cart.add(table);
        assertEquals(300, cart.totalRetailPrice());
    }
    @Test
    public void testDiscount5PercentOver300() throws  Exception {
        Cart cart = new Cart();
        Product fridge = new Product("123", "Fridge", 152);
        Product table = new Product("122", "Table", 1500);
        cart.add(fridge);
        cart.add(table);
        cart.addDiscount(new Discount5PercOver300());
        cart.executeDiscount(cart);
        assertEquals(1569.4, cart.totalAfterDiscounts());
    }

    @Test(expected = Exception.class)
    public void testDiscount5PercentOver300_2() throws  Exception {
        Cart cart = new Cart();
        Product fridge = new Product("123", "Fridge", 11);
        Product table = new Product("122", "Table", 123);
        cart.add(fridge);
        cart.add(table);
        cart.addDiscount(new Discount5PercOver300());
        cart.executeDiscount(cart);
        assertEquals(3325, cart.totalAfterDiscounts());
    }
    @Test
    public void testDiscountBuy2Get1Free() throws  Exception {
        Cart cart = new Cart();
        Product fridge = new Product("123", "Fridge", 2000);
        Product table = new Product("122", "Table", 1500);
        Product pencil = new Product("1225", "Pencil", 521);
        cart.add(fridge);
        cart.add(table);
        cart.add(pencil);
        cart.addDiscount(new DiscountBuy2Get1Free());
        cart.executeDiscount(cart);
        assertEquals(3500, cart.totalAfterDiscounts());
    }
    @Test
    public void testDiscountFreeCup() throws  Exception {
        Cart cart = new Cart();
        Product fridge = new Product("123", "Fridge", 2000);
        cart.add(fridge);
        cart.addDiscount(new DiscountFreeCup());
        cart.executeDiscount(cart);
        assertEquals("Cup", cart.getCheapestProduct().getName());
    }
    @Test
    public void testDiscount30Percent() throws  Exception {
        Cart cart = new Cart();
        Product fridge = new Product("123", "Fridge", 2000);
        Product watch = new Product("1233", "Watch", 123);
        cart.add(fridge);
        cart.add(watch);
        cart.addDiscount(new Discount30Percent());
        cart.executeDiscount(cart);
        assertEquals(1523, cart.totalAfterDiscounts());
    }
    @Test
    public void testSortByPriceASC() throws  Exception {
        Cart cart = new Cart();
        Product fridge = new Product("123", "Fridge", 2000);
        Product watch = new Product("124", "Watch", 12344);
        Product bosh = new Product("125", "Bosh", 123);
        cart.add(fridge);
        cart.add(watch);
        cart.add(bosh);
        cart.sortByPriceASC();

        assertEquals(  Arrays.toString(new String[]{"Bosh", "Fridge", "Watch",}),
                Arrays.toString(Arrays.stream(cart.getProducts()).map(Product::getName).toArray()));
    }
    @Test
    public void testSortByPriceDESC() throws  Exception {
        Cart cart = new Cart();
        Product fridge = new Product("123", "Fridge", 2000);
        Product watch = new Product("124", "Watch", 12344);
        Product bosh = new Product("125", "Bosh", 123);
        cart.add(fridge);
        cart.add(watch);
        cart.add(bosh);
        cart.sortByPriceDESC();

        assertEquals(  Arrays.toString(new String[]{"Watch", "Fridge", "Bosh",}),
                Arrays.toString(Arrays.stream(cart.getProducts()).map(Product::getName).toArray()));
    }
    @Test
    public void testSortByNameDESC() throws  Exception {
        Cart cart = new Cart();
        Product fridge = new Product("123", "A", 2000);
        Product watch = new Product("124", "B", 12344);
        Product bosh = new Product("125", "C", 123);
        cart.add(fridge);
        cart.add(watch);
        cart.add(bosh);
        cart.sortByNameDESC();

        assertEquals(  Arrays.toString(new String[]{"C", "B", "A",}),
                Arrays.toString(Arrays.stream(cart.getProducts()).map(Product::getName).toArray()));
    }
    @Test
    public void testSortByNameASC() throws  Exception {
        Cart cart = new Cart();
        Product fridge = new Product("123", "A", 2000);
        Product watch = new Product("124", "B", 12344);
        Product bosh = new Product("125", "C", 123);
        cart.add(fridge);
        cart.add(watch);
        cart.add(bosh);
        cart.sortByNameASC();

        assertEquals(  Arrays.toString(new String[]{"A", "B", "C",}),
                Arrays.toString(Arrays.stream(cart.getProducts()).map(Product::getName).toArray()));
    }
    @Test
    public void testGetSumOfProducts() throws  Exception {
        Cart cart = new Cart();
        Product fridge = new Product("123", "A", 100);
        Product watch = new Product("124", "B", 200);
        Product bosh = new Product("125", "C", 300);
        cart.add(fridge);
        cart.add(watch);
        cart.add(bosh);
        assertEquals(  600,
                cart.totalRetailPrice());
    }



}
