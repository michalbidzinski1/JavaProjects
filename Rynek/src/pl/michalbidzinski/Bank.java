package pl.michalbidzinski;

import pl.michalbidzinski.observer.MoneyTurnoverObserver;

public class Bank implements MoneyTurnoverObserver {
    private static Bank instance;
    private double inflation;
    private double avgIncome;
    private double money;
    private double transactions;
    @Override
    public void update(double amount) {

    }

    public static Bank getInstance() {
        return instance;
    }

    public static void setInstance(Bank instance) {
        Bank.instance = instance;
    }

    public double getInflation() {
        return inflation;
    }

    public void setInflation(double inflation) {
        this.inflation = inflation;
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
