package pl.michalbidzinski.visitor;

import pl.michalbidzinski.Offer;

public interface Visitor {
    void visit(Offer offer);
}
