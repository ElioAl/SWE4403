package com.example.paymentservice;

public class CompleteState implements PaymentState{
    @Override
    public void proccess(Payment payment) {
        System.out.println("Payment Complete");
        //add database method
    }
}
