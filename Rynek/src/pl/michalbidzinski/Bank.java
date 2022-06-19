package pl.michalbidzinski;

import pl.michalbidzinski.observer.InflationObserver;
import pl.michalbidzinski.observer.MarketTurnoverObserver;
import java.util.*;

public class Bank implements MarketTurnoverObserver {
    private static Bank bank;
    private double inflation;
    private double money;
    private double numOfTransactions;
    private final List <InflationObserver> observers;

    private Bank() {
        inflation = 6.0;
        observers = new ArrayList<>();
    }
    public void addObserver(InflationObserver observer) {
        observers.add(observer);
    }


    @Override
    public void updateInflation(double amount) {
        numOfTransactions++;
        money += amount;
        double avgIncome = money / numOfTransactions;
        if (amount >= 1.5 * avgIncome) {
            setInflation(inflation + 0.1);
        } else if (amount <= 0.9 * avgIncome) {
            setInflation(inflation - 0.1);
        }

    }

    public static Bank getBank() {
        if (bank == null) {
            bank = new Bank();
        }
        return bank;
    }

    public double getInflation() {
        return inflation;
    }

    public void setInflation(double value) {
        this.inflation = Math.max(0, value);
        observers.forEach(o -> o.updateInflation(value));
    }




}
