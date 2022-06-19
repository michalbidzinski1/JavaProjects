package pl.michalbidzinski;

import pl.michalbidzinski.observer.OfferObserver;
import pl.michalbidzinski.visitor.Visitor;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Offer {
    private final Product product;
    private Seller seller;
    private double price;
    private final double productionCost;
    private List<OfferObserver> observers;
    boolean bought;

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }



    public Offer(Product product, double price, double productionCost) {
        this.product = product;
        this.price = price;
        this.productionCost = productionCost;
        this.observers = new CopyOnWriteArrayList<>();
    }
    public  void increasePrice(double value) {
        this.setPrice(price +  price * value);
        for (OfferObserver observer : observers) {
            observer.update(this);
        }
    }



    public void setSeller(Seller seller) {

        this.seller = seller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }





    public boolean isBought() {
        return bought;
    }
    public void addObserver(OfferObserver observer) {
        observers.add(observer);
    }

    public void buy(Buyer buyer) {
        buyer.buyTheProduct(this.product);
        buyer.payForTheProduct(price);
        bought = true;
        for (OfferObserver observer : observers) {
            observer.update(this);
            observers.remove(observer);
        }
        observers = null;
        seller.addMoney(price - productionCost);
        seller.getOffers().remove(this);
    }
}
