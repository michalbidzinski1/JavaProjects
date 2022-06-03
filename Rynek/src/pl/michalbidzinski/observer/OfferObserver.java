package pl.michalbidzinski.observer;

import pl.michalbidzinski.Offer;

public interface OfferObserver {
    void update(Offer offer);
}