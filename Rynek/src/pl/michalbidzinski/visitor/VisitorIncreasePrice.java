package pl.michalbidzinski.visitor;

import pl.michalbidzinski.Offer;

public class VisitorIncreasePrice implements  Visitor {
    @Override
    public void visit(Offer offer) {
        offer.increasePrice(0.20);
    }
}
