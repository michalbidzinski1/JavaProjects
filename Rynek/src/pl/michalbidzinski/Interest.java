package pl.michalbidzinski;

import pl.michalbidzinski.observer.OfferObserver;

public class Interest implements OfferObserver {
    private Offer offer;
    private Buyer buyer;

    private double interest;

    private double lastPrice;

    public Interest(Offer offer, Buyer buyer) {
        this.offer = offer;
        this.buyer = buyer;
        interest = Math.max(Math.random(), 0.5);
        lastPrice = offer.getPrice();
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }



    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = Math.max(0, interest);
    }
    public void increaseInterest(double increase) {
        setInterest(interest - increase);
    }

    public void updateInflation(double inflationDiff) {
        if (Math.abs(inflationDiff) > 0.02) {
            increaseInterest(inflationDiff * interest);
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
            if (interest >= buyer.getRule()) {
                buyer.canBuyOffer(offer);
            }
        }
    }
}
