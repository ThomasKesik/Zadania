package devices;

import main.Human;

import java.util.Calendar;
import java.util.Date;

public class Transaction {
    private final Human seller;
    private final Human buyer;
    private final Double price;
    private final Date transactionDate;

    public Transaction(Human seller, Human buyer, Double price) {
        this.seller = seller;
        this.buyer = buyer;
        this.price = price;
        this.transactionDate = Calendar.getInstance().getTime();
    }

    public Human getSeller() {
        return seller;
    }

    public Human getBuyer() {
        return buyer;
    }

    public Double getPrice() {
        return price;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "seller=" + seller +
                ", buyer=" + buyer +
                ", price=" + price +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
