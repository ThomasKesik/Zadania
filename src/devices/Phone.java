package devices;

import main.Human;

public class Phone extends Device{

    public Phone(String producer, String model, Integer yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    @Override
    public String toString() {
        return "devices.Phone{}";
    }

    @Override
    public void turnOn() {
        System.out.println("Telefon został włączony");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if(seller.getPhone() != null && seller.getPhone().equals(this)){
            if(buyer.cash >= price){
                seller.cash += price;
                buyer.cash -= price;
                buyer.setPhone(this);
                seller.setPhone(null);
                System.out.println("Telefon " + this.producer + " " + this.model + " został kupiony za " + price + " !!!");
            } else {
                System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy by kupić telefon !!!");
            }
        } else {
            System.out.println("Ten telefon nie jest twój !!!");
        }
    }
}
