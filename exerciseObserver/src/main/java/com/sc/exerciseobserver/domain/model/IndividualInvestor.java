package com.sc.exerciseobserver.domain.model;

public class IndividualInvestor implements Investor {
    private String name;

    public IndividualInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println(name + " received update: " + stockSymbol + " is now $" + price);
    }
}

