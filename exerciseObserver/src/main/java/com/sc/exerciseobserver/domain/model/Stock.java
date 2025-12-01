package com.sc.exerciseobserver.domain.model;

public interface Stock {
    void addInvestor(Investor investor);
    void removeInvestor(Investor investor);
    void notifyInvestors();
}
