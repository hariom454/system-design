package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Loan {

  private int principalAmount;
  private int rateOfInterest;
  private int tenure;
  private int monthlyEmi;

  private int totalAmount;

  private int lumsup;

  private List<Repayment> repayments;

  public Loan(int principalAmount, int r, int tenure) {
    this.principalAmount = principalAmount;
    this.rateOfInterest = r;
    this.tenure = tenure;

    double i = principalAmount * r * tenure;
    i = (int) Math.ceil(i / 100.0);
    double total = principalAmount + i;
    this.totalAmount = (int) Math.ceil(total);

    this.monthlyEmi = (int) Math.ceil(total / (tenure * 12));
    this.repayments = new ArrayList<>();
  }

  public void repayment(int amount, int emi) {
    Repayment repayment = new Repayment(amount, emi);
    lumsup += amount;
    repayments.add(repayment);
  }

  public Balance calculateBalance(int emiNo) {
    AtomicInteger totalPaid = new AtomicInteger(emiNo * monthlyEmi);
    repayments.forEach(item -> {
      if (item.getEmiNumber() <= emiNo) {
        totalPaid.addAndGet(item.getAmount());
      }
    });

    double remaining = totalAmount - totalPaid.get();
    int remainingEmi = (int) Math.ceil(remaining / monthlyEmi);
    return new Balance(Math.min(totalPaid.get(), totalAmount), remainingEmi);
  }
}
