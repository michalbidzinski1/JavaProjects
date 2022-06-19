package pl.michalbidzinski;

import pl.michalbidzinski.observer.InflationObserver;
import java.util.*;

public class Buyer implements InflationObserver {
    private final List<Interest> demand;
    private final double needs;
    private double lastInflation;
    private double money;
    private final List<Product> pucharsedProducts;

    public Buyer(String name,  double needs) {
        this.demand = new ArrayList<>();
        Bank bank = Bank.getBank();
        this.needs = needs;
        this.lastInflation = bank.getInflation();
        this.money = 12000;
        bank.addObserver(this);
        this.pucharsedProducts = new ArrayList<>();
    }
    public Buyer(String name) {
        this(name, 0.70);
    }
    public void followOffer(Offer offer) {
        Interest interest = new Interest(offer, this);
        demand.add(interest);
        offer.addObserver(interest);
    }
    public void canBuy(Offer offer) {
        if (offer.getPrice() <= money) {
            offer.buy(this);
        }
    }
    public void unfollowOffer(Offer offer) {
        demand.removeIf(o -> offer.equals(o.getOffer()));
    }


    public List<Interest> getDemand() {
        return demand;
    }

    public void buyTheProduct(Product product) {
        pucharsedProducts.add(product);
    }


    public double getNeeds() {
        return needs;
    }


    public List<Product> getPucharsedProducts() {
        return pucharsedProducts;
    }


    public void payForTheProduct(double amount) {
        money -= amount;
    }

    @Override
    public void updateInflation(double inflation) {
        double diff = inflation - lastInflation;
        lastInflation = inflation;
        demand.forEach(i -> i.inflationUpdate(diff));
    }
}
