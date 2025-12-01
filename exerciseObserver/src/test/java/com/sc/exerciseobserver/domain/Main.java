package com.sc.exerciseobserver.domain;

import com.sc.exerciseobserver.domain.model.ConcreteStock;
import com.sc.exerciseobserver.domain.model.IndividualInvestor;
import com.sc.exerciseobserver.domain.model.InstitutionalInvestor;

public class Main {
    public static void main(String[] args) {
        // Create stock
        ConcreteStock aapl = new ConcreteStock("AAPL", 150.0);

        // Create investors
        IndividualInvestor john = new IndividualInvestor("John Doe");
        InstitutionalInvestor hedgeFund = new InstitutionalInvestor("Alpha Hedge Fund");

        // Subscribe investors
        aapl.addInvestor(john);
        aapl.addInvestor(hedgeFund);

        System.out.println("Initial AAPL price: $" + aapl.getPrice());
        System.out.println("--- Price change to $155.0 ---\n");

        // Simulate price changes
        aapl.setPrice(155.0);

        System.out.println("\n--- Price change to $152.5 ---\n");
        aapl.setPrice(152.5);

        System.out.println("\n--- Removing John and changing price to $160.0 ---\n");
        aapl.removeInvestor(john);
        aapl.setPrice(160.0);
    }
}

