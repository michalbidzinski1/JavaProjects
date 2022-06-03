package pl.michalbidzinski;

public class Interest {
    private Offer offer;
    private Buyer buyer;

    private double interest;

    private double lastPrice;

    public Interest(Offer offer, Buyer buyer, double interest, double lastPrice) {
        this.offer = offer;
        this.buyer = buyer;
        this.interest = interest;
        this.lastPrice = lastPrice;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }
}
