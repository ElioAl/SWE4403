package com.example.paymentservice;

public class PendingState implements PaymentState{
    @Override
    public void proccess(Payment payment) {
        System.out.println("Payment Pending");
        try {            // Sleep for 5 seconds (5000 milliseconds)
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Handle interrupted exception if necessary
            e.printStackTrace();
        }
        if(payment.getAmountInCard() >= payment.getAmount()){
            payment.changeState(new CompleteState());
            payment.proccess();
        }else {
            payment.changeState(new FailedState());
            payment.proccess();
        }
    }
}
