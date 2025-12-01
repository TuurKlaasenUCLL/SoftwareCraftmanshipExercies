package com.sc.exerciseobserver.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ConcreteStock {
    private String symbol;
    private double price;
    private List<Investor> investors = new ArrayList<>();

    public ConcreteStock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void addInvestor(Investor investor) {
        investors.add(investor);
    }

    public void removeInvestor(Investor investor) {
        investors.remove(investor);
    }

    public void notifyInvestors() {
        for (Investor investor : investors) {
            investor.update(symbol, price);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyInvestors();
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}