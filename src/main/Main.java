package main;

import devices.*;
import excaptions.NoCarInGarageException;
import excaptions.NoCashForCarException;
import excaptions.NoSpaceInGarageException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Car carElectric = new Electric("Tesla", "Elon", "123", 2022);
        carElectric.value = 100000.0;
        Car carDiesel = new Diesel("Skoda", "Octavia", "213", 2000);
        carDiesel.value = 20000.0;
        Car carLpg = new LPG("Ford", "Mondeo", "321", 2010);
        carLpg.value = 38000.0;

        Human seller = new Human();
        Human buyer = new Human(5);

        seller.setCar(carElectric, -1);
        seller.setCar(carElectric, 0);
        seller.setCar(carDiesel, 1);
        seller.setCar(carLpg, 1);
        seller.setCar(carLpg, 2);

        System.out.println("Wartosc aut w garazu sprzedajacy: " + seller.getCarsValue());
        System.out.println("Wartosc aut w garazu kupujacy: " + buyer.getCarsValue());

        seller.sortCars();
        System.out.println(seller);

        try {
            carDiesel.sell(seller, buyer, 10000.0);
        } catch (Exception e) {

        }

        buyer.cash = 100000.0;
        seller.cash = 100000.0;

        try {
            carDiesel.sell(buyer, seller, 10000.0);
        } catch (Exception e) {

        }

        Human buyer2 = new Human(0);
        buyer2.cash = 1000000.0;

        try {
            carDiesel.sell(seller, buyer2, 10000.0);
        } catch (Exception e) {

        }

        try {
            carDiesel.sell(seller, buyer, 10000.0);
        } catch (Exception e) {

        }

        System.out.println("Wartosc aut w garazu sprzedajacy: " + seller.getCarsValue());
        System.out.println("Wartosc aut w garazu kupujacy: " + buyer.getCarsValue());
    }
}
