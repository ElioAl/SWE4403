package com.example.paymentservice;

public class FailedState implements PaymentState{
    @Override
    public void proccess(Payment payment) {
        System.out.println("Payment Failed");
    }
}
