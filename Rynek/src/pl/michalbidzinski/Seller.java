package pl.michalbidzinski;

import pl.michalbidzinski.observer.InflationObserver;
import pl.michalbidzinski.visitor.Visitor;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Seller implements InflationObserver {
    private final String name;
    private final List<Offer> offers;
    private double lastKnownInflation;
    private double money;
    private final Bank bank;

    public String getName() {
        return name;
    }

    public double getLastKnownInflation() {
        return lastKnownInflation;
    }

    public void setLastKnownInflation(double lastKnownInflation) {
        this.lastKnownInflation = lastKnownInflation;
    }
    public void acceptMarketChanges(Visitor visitor) {
        for (Offer offer : offers) {
            offer.accept(visitor);
        }
    }

    public double getMoney() {
        return money;
    }

    public Bank getBank() {
        return bank;
    }

    public void addOffer(Offer offer) {

        offer.setSeller(this);
        offers.add(offer);
    }
    public void setMoney(double money) {
        this.money = money;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public Seller(String name) {
        this.name = name;
        this.offers = new CopyOnWriteArrayList<>();
        this.bank = Bank.getInstance();
        this.lastKnownInflation = bank.getInflation();
        this.bank.addObserver(this);
    }

    public void makeMoney(double amount) {
        bank.update(amount);
        setMoney(money + amount);
    }



    @Override
    public void update(double inflation) {
        double diff = inflation - lastKnownInflation;
        if (Math.abs(diff) > 0.05) {
            lastKnownInflation = inflation;
            offers.forEach(e -> e.setPrice(e.getPrice() + e.getPrice() * diff));
        }
    }
}
