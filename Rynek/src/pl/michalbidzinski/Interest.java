package pl.michalbidzinski;

import pl.michalbidzinski.observer.OfferObserver;

public class Interest implements OfferObserver {
    private Offer offer;
    private final Buyer buyer;

    private double demand;

    private double lastPrice;

    public Interest(Offer offer, Buyer buyer) {
        this.offer = offer;
        this.buyer = buyer;
        demand = Math.max(Math.random(), 0.5);
        lastPrice = offer.getPrice();
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }



    public double getDemand() {
        return demand;
    }

    public void setDemand(double demand) {
        this.demand = Math.max(0, demand);
    }
    public void increaseInterest(double increase) {
        setDemand(demand - increase);
    }

    public void inflationUpdate(double diff) {
        if (Math.abs(diff) > 0.02) {
            increaseInterest(diff * demand);
        }
    }
    @Override
    public void update(Offer offer) {
        if (offer.isBought()) {
            buyer.unfollowOffer(offer);
        }
        double increase = (offer.getPrice() - lastPrice) / lastPrice;
        lastPrice = offer.getPrice();
        if(Math.abs(increase) > 0.02) {
            increaseInterest(increase);
            if (demand >= buyer.getNeeds()) {
                buyer.canBuy(offer);
            }
        }
    }
}
