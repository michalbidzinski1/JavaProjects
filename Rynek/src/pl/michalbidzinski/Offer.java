package pl.michalbidzinski;

import pl.michalbidzinski.observer.OfferObserver;
import pl.michalbidzinski.visitor.Visitor;

import java.util.*;
import java.util.ArrayList;
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
    public  void increasePrice(double val) {
        this.setPrice(price +  val);
        for (OfferObserver observer : observers) {
            observer.update(this);
        }
    }
    public  void increasePriceByPercent(double val) {
        this.setPrice(price +  price * val);
        for (OfferObserver observer : observers) {
            observer.update(this);
        }
    }


    public void setSeller(Seller seller) {
        System.out.println(seller);
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
        buyer.addProductToBought(this.product);
        buyer.spendMoney(price);
        bought = true;
        for (OfferObserver observer : observers) {
            observer.update(this);
            observers.remove(observer);
        }
        observers = null;
        seller.makeMoney(price - productionCost);
        seller.getOffers().remove(this);
    }
}
