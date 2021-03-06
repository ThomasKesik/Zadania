package devices;

import excaptions.NoCarInGarageException;
import excaptions.NoCashForCarException;
import excaptions.NoSpaceInGarageException;
import main.Human;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Car extends Device {

    public final String VIN;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Car(String producer, String model, String VIN,  Integer yearOfProduction) {
        super(producer, model, yearOfProduction);
        this.VIN = VIN;
    }

    @Override
    public void turnOn() {
        System.out.println("Auto zostało włączone");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(producer, car.producer) && Objects.equals(model, car.model) && Objects.equals(VIN, car.VIN) && Objects.equals(yearOfProduction, car.yearOfProduction) && Objects.equals(value, car.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model, VIN, yearOfProduction, value);
    }

    @Override
    public String toString() {
        return "devices.Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", VIN='" + VIN + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", value=" + value +
                '}';
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws NoCarInGarageException, NoCashForCarException, NoSpaceInGarageException {
        if(buyer.cash < price){
            throw new NoCashForCarException();
        }
        int sellerCarPosition = -1;
        Car [] sellerCars = seller.getGarage();
        for(int i = 0; i < sellerCars.length; i++){
            if(sellerCars[i] != null && sellerCars[i].equals(this)){
                sellerCarPosition = i;
                break;
            }
        }
        if(sellerCarPosition == -1 || !this.getLastOwner().equals(seller)){
            throw new NoCarInGarageException();
        }

        int buyerFirstFreeSpace = -1;
        Car [] buyerCars = buyer.getGarage();
        for(int i = 0; i < buyerCars.length; i++){
            if(buyerCars[i] == null){
                buyerFirstFreeSpace = i;
                break;
            }
        }
        if(buyerFirstFreeSpace == -1){
            throw new NoSpaceInGarageException();
        }
        seller.cash += price;
        buyer.cash -= price;
        buyer.setCar(this, buyerFirstFreeSpace);
        seller.setCar(null, sellerCarPosition);
        Transaction transaction = new Transaction(seller, buyer, price);
        transactions.add(transaction);
        System.out.println("Auto " + this.producer + " " + this.model + " zostało kupione za " + price + " !!!");
    }

    public void addOwner(Human human) {
        Transaction transaction = new Transaction(null, human, 0.0);
        transactions.add(transaction);
    }

    public Human getLastOwner(){
        Transaction lastTransaction = transactions.get(transactions.size()-1);
        return lastTransaction.getBuyer();
    }

    public boolean wasOwner(Human human){
        for(Transaction transaction: transactions){
            if(transaction.getBuyer().equals(human)){
                return true;
            }
        }
        return false;
    }

    public boolean transactionCheck(Human seller, Human buyer){
        for(Transaction transaction: transactions){
            if(transaction.getSeller() == null || transaction.getBuyer() == null){
                continue;
            }
            if(transaction.getSeller().equals(seller) && transaction.getBuyer().equals(buyer)){
                return true;
            }
        }
        return false;
    }

    public int transactionCount(){
        return transactions.size();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void printTransactions(){
        for (Transaction transaction: transactions){
            System.out.println(transaction);
            System.out.println();
        }
    }

    public abstract void refuel();
}
