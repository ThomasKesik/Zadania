package main;

import devices.Car;
import devices.Phone;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Skoda", "Octavia", "1J8FFC7Y77D356964", 2000);
        car.value = 500.0;

        Phone phone = new Phone("Samsung", "A20", 2012);

        Animal animal = new Animal("Kot");

        Human seller = new Human();
        seller.setSalary(1000.0);
        Human buyer = new Human();
        buyer.setSalary(1000.0);

        car.sell(seller, buyer, 1000.0);
        phone.sell(seller, buyer, 129.99);
        animal.sell(seller, buyer, 580.0);

        buyer.cash = 3000.0;
        System.out.println(buyer.cash);
        System.out.println(seller.cash);

        seller.setCar(car);
        seller.setPhone(phone);
        seller.pet = animal;

        car.sell(seller, buyer, 1000.0);
        phone.sell(seller, buyer, 129.99);
        animal.sell(seller, buyer, 580.0);

        System.out.println(buyer.cash);
        System.out.println(seller.cash);
    }
}
