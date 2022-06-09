package pl.michalbidzinski;

import pl.michalbidzinski.observer.InflationObserver;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Buyer implements InflationObserver {
    private String name;
    private List<Interest> interests;
    private Bank bank;
    private double rule;
    private double lastKnownInflation;
    private double money;
    private List<Product> boughtProducts;

    public Buyer(String name,  double rule) {
        this.name = name;
        this.interests = new ArrayList<>();
        this.bank = Bank.getInstance();
        this.rule = rule;
        this.lastKnownInflation = bank.getInflation();
        this.money = 10000;
        this.bank.addObserver(this);
        this.boughtProducts = new CopyOnWriteArrayList<>();
    }
    public Buyer(String name) {
        this(name, 0.75);
    }
    public void followOffer(Offer offer) {
        Interest interest = new Interest(offer, this);
        interests.add(interest);
        offer.addObserver(interest);
    }
    public void canBuyOffer(Offer offer) {
        if (offer.getPrice() <= money) {
            offer.buy(this);
        }
    }
    public void unfollowOffer(Offer offer) {
        interests.removeIf(o -> offer.equals(o.getOffer()));
    }


    public List<Interest> getInterests() {
        return interests;
    }

    public void addProductToBought(Product product) {
        boughtProducts.add(product);
    }


    public double getRule() {
        return rule;
    }


    public List<Product> getBoughtProducts() {
        return boughtProducts;
    }


    public void spendMoney(double amount) {
        money -= amount;
    }

    @Override
    public void update(double inflation) {
        double inflationDiff = inflation - lastKnownInflation;
        lastKnownInflation = inflation;
        interests.forEach(i -> i.updateInflation(inflationDiff));
    }
}
