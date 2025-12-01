package com.sc.exerciseobserver.domain.model;

public class InstitutionalInvestor implements Investor {
    private String name;

    public InstitutionalInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println(name + " portfolio alert: " + stockSymbol + " updated to $" + price +
                          ". Rebalancing required.");
    }
}
