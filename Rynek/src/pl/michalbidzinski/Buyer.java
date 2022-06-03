package pl.michalbidzinski;

import pl.michalbidzinski.observer.InflationObserver;
import java.util.*;
public class Buyer implements InflationObserver {
    private String name;
    private List<Interest> interests;
    private Bank bank;
    private double rule;
    private double lastKnownInflation;
    private double money;
    private List<Product> boughtProducts;

    public Buyer(String name,  double rule) {
        this.name = name;
        this.interests = new ArrayList<>();
        this.bank = Bank.getInstance();
        this.rule = rule;
        this.lastKnownInflation = bank.getInflation();
        this.money = 10000;
        this.bank.addObserver(this);
        this.boughtProducts = new ArrayList<>();
    }
    public Buyer(String name) {
        this(name, 0.75);
    }

    public void addProductToBought(Product product) {
        boughtProducts.add(product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public double getRule() {
        return rule;
    }

    public void setRule(double rule) {
        this.rule = rule;
    }

    public double getLastKnownInflation() {
        return lastKnownInflation;
    }

    public void setLastKnownInflation(double lastKnownInflation) {
        this.lastKnownInflation = lastKnownInflation;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<Product> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(List<Product> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }
    public void spendMoney(double amount) {
        money -= amount;
    }

    @Override
    public void update(double inflation) {

    }
}
