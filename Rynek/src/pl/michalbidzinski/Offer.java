package pl.michalbidzinski;

import pl.michalbidzinski.observer.OfferObserver;
import java.util.*;
import java.util.ArrayList;

public class Offer {
    private final Product product;
    private Seller seller;
    private double price;
    private final double productionCost;
    private List<OfferObserver> observers;
    boolean bought;

    public Offer(Product product,double price, double productionCost) {
        this.product = product;
        this.price = price;
        this.productionCost = productionCost;
        this.observers = new ArrayList<>();
    }

    public Product getProduct() {
        return product;
    }

    public Seller getSeller() {
        return seller;
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

    public double getProductionCost() {
        return productionCost;
    }

    public List<OfferObserver> getFollowers() {
        return observers;
    }

    public void setFollowers(List<OfferObserver> followers) {
        this.observers = observers;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
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
