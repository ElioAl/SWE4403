package com.example.paymentservice;

import java.util.ArrayList;

public class Payment {
    private int userId;
    private ArrayList<Product> items;
    private int cardNumber;
    private int amountInCard;
    private PaymentState state;

    public Payment(int userId, ArrayList<Product> items,int cardNumber, int amountInCard) {
        this.userId = userId;
        this.items = items;
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
        float amount = 0;
        for (Product item: items) {
            amount += item.getCost();
        }
        return amount;
    }

    public int getCardNumber() {
        return cardNumber;
    }
}
