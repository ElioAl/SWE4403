package com.example.paymentservice;

import java.util.ArrayList;

public class Payment {
    private int userId;
    private float amount;
    private int cardNumber;
    private int amountInCard;
    private PaymentState state;

    public Payment(float amount, int cardNumber, int amountInCard) {
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.amountInCard =amountInCard;
        state =  new IntializedState();
    }

    public void changeState(PaymentState state){
        this.state = state;
    }

    public void proccess(){
        state.proccess(this);
    }

    public int getAmountInCard() {
        return amountInCard;
    }

    public float getAmount() {
        return amount;
    }

    public int getCardNumber() {
        return cardNumber;
    }
}
