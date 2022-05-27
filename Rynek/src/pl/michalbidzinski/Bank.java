package pl.michalbidzinski;

import pl.michalbidzinski.observer.InflationObserver;
import pl.michalbidzinski.observer.MoneyTurnoverObserver;
import java.util.*;
public class Bank implements MoneyTurnoverObserver {
    private static Bank instance;
    private double inflation;
    private double avgIncome;
    private double money;
    private double transactions;
    private List <InflationObserver> observers;

    public List<InflationObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<InflationObserver> observers) {
        this.observers = observers;
    }

    private Bank() {
        inflation = 3.0;
        observers = new ArrayList<>();
    }
    public void addObserver(InflationObserver observer) {
        observers.add(observer);
    }


    @Override
    public void update(double amount) {
        transactions++;
        money += amount;
        avgIncome = money / transactions;
        if (amount >= 1.2 * avgIncome) {
            setInflation(inflation + 0.1);
        } else if (amount <= 0.8 * avgIncome) {
            setInflation(inflation - 0.1);
        }

    }

    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public static void setInstance(Bank instance) {
        Bank.instance = instance;

    }

    public double getInflation() {
        return inflation;
    }

    public void setInflation(double val) {
        this.inflation = Math.max(0, val);
        observers.forEach(e -> e.update(val));
    }

    public double getAvgIncome() {
        return avgIncome;
    }

    public void setAvgIncome(double avgIncome) {
        this.avgIncome = avgIncome;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getTransactions() {
        return transactions;
    }

    public void setTransactions(double transactions) {
        this.transactions = transactions;
    }
}
