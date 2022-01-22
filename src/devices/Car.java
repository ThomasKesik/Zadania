package devices;

import main.Human;

import java.util.Objects;

public abstract class Car extends Device {

    public final String VIN;
    public Double value;

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
    public void sell(Human seller, Human buyer, Double price) {
        if(seller.getCar() != null && seller.getCar().equals(this)){
            if(buyer.cash >= price){
                seller.cash += price;
                buyer.cash -= price;
                buyer.setCar(this);
                seller.setCar(null);
                System.out.println("Auto " + this.producer + " " + this.model + " zostało kupione za " + price + " !!!");
            } else {
                System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy by kupić auto !!!");
            }
        } else {
            System.out.println("To auto nie jest twoje !!!");
        }
    }

    public abstract void refuel();
}
