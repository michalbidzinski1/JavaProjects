package pl.michalbidzinski;

import pl.michalbidzinski.visitor.VisitorDecreasePrice;
import pl.michalbidzinski.visitor.VisitorIncreasePrice;
import pl.michalbidzinski.visitor.Visitor;

public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getBank();
        Product p1 = new Product("Smartphone");
        Product p2 = new Product("Fridge");
        Product p3 = new Product("Water");
        Offer offer1 = new Offer(p1, 52, 15);
        Offer offer2 = new Offer(p2, 45674567, 155);
        Offer offer3 = new Offer(p3, 14, 7);
        Offer offer5 = new Offer(p3, 20, 7);
        Buyer buyer = new Buyer("Buyer1");
        Seller seller = new Seller();
        seller.addOffer(offer1);
        seller.addOffer(offer2);
        seller.addOffer(offer3);
        seller.addOffer(offer5);
        buyer.followOffer(offer1);
        buyer.followOffer(offer2);
        buyer.followOffer(offer3);
        main(seller, buyer);
        System.out.println("\n Inflation: " + bank.getInflation());
        System.out.println("\n Price decrease");
        Visitor visitor = new VisitorDecreasePrice();
        seller.acceptChanges(visitor);
        main(seller, buyer);
        System.out.println("\n Inflation: " + bank.getInflation());
        System.out.println("\n Price increase");
        visitor = new VisitorIncreasePrice();
        seller.acceptChanges(visitor);
        main(seller, buyer);
        System.out.println("\n Inflation: " + bank.getInflation());
        System.out.println("\n Price decrease");
        Visitor visitor1 = new VisitorDecreasePrice();
        seller.acceptChanges(visitor1);
        main(seller, buyer);

    }

    private static void main(Seller seller, Buyer client) {
        System.out.println("Offers" + seller.getOffers());
        System.out.println("Bought products" + client.getPucharsedProducts());
        System.out.println(client.getDemand());
    }
}