package pl.michalbidzinski;

import pl.michalbidzinski.observer.OfferObserver;
import java.util.*;
import java.util.ArrayList;

public class Offer {
    private final Product product;
    private Seller seller;
    private double price;
    private final double productionCost;
    private List<OfferObserver> followers;
    boolean bought;

    public Offer(Product product,double price, double productionCost) {
        this.product = product;
        this.price = price;
        this.productionCost = productionCost;
        this.followers = new ArrayList<>();
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
        return followers;
    }

    public void setFollowers(List<OfferObserver> followers) {
        this.followers = followers;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }
}
