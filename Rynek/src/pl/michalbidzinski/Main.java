package pl.michalbidzinski;

import pl.michalbidzinski.visitor.DecreasePriceVisitor;
import pl.michalbidzinski.visitor.IncreasePrice;
import pl.michalbidzinski.visitor.Visitor;

public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        Product p1 = new Product("Jablko");
        Product p2 = new Product("Wodka");
        Product p3 = new Product("Baklazan");
        Product p4 = new Product("Cola");
        Offer offer1 = new Offer(p1, 5.0, 3.5);
        Offer offer2 = new Offer(p2, 10000.0, 5.3);
        Offer offer3 = new Offer(p3, 1180.0, 5.0);
        Offer offer4 = new Offer(p4, 1180.0, 5.0);

        Offer offer5 = new Offer(p3, 2.0, 1.6);

        Buyer client = new Buyer("Maciek");
        Seller seller = new Seller("Janusz");

        seller.addOffer(offer1);
        seller.addOffer(offer2);
        seller.addOffer(offer3);
        seller.addOffer(offer4);
        seller.addOffer(offer5);

        client.followOffer(offer1);
        client.followOffer(offer2);
        client.followOffer(offer3);


        printInfo(seller, client);
        System.out.println("\n Inflacja: " + bank.getInflation());
        System.out.println("\n Obniżenie ceny");

        Visitor visitor = new DecreasePriceVisitor();
        seller.acceptMarketChanges(visitor);
        printInfo(seller, client);

        System.out.println("\n Inflacja: " + bank.getInflation());
        System.out.println("\n Obniżenie ceny");

        visitor = new IncreasePrice();
        seller.acceptMarketChanges(visitor);
        printInfo(seller, client);

        System.out.println("\n Inflacja: " + bank.getInflation());
        System.out.println("\n Obniżenie ceny");
        seller.acceptMarketChanges(visitor);
        printInfo(seller, client);

    }

    private static void printInfo(Seller seller, Buyer client) {
        System.out.println("Oferty sprzedawcy: " + seller.getOffers());
        System.out.println("Przedmioty kupujacego: " + client.getBoughtProducts());
        System.out.println(client.getInterests());
    }
}