package pl.michalbidzinski.visitor;

import pl.michalbidzinski.Offer;

public class DecreasePriceVisitor implements Visitor{
    @Override
    public void visit(Offer offer) {
        offer.increasePriceByPercent(-.15);
    }
}
