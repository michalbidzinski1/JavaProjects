package pl.michalbidzinski;

import pl.michalbidzinski.observer.InflationObserver;
import pl.michalbidzinski.visitor.Visitor;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Seller implements InflationObserver {
    private final List<Offer> offers;
    private double lastInflation;
    private double money;
    private final Bank bank;

    public void acceptChanges(Visitor visitor) {
        for (Offer offer : offers) {
            offer.accept(visitor);
        }
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

    public Seller() {
        this.offers = new CopyOnWriteArrayList<>();
        this.bank = Bank.getBank();
        this.lastInflation = bank.getInflation();
        this.bank.addObserver(this);
    }

    public void addMoney(double amount) {
        bank.updateInflation(amount);
        setMoney(money + amount);
    }



    @Override
    public void updateInflation(double inflation) {
        double diff = inflation - lastInflation;
        if (Math.abs(diff) > 0.05) {
            lastInflation = inflation;
            offers.forEach(o -> o.setPrice(o.getPrice() + o.getPrice() * diff));
        }
    }
}
