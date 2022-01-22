package main;

import devices.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone("Samsung", "Galaxy", 2020);
        phone.installAnApp("AngryBirds");
        phone.installAnApp("AngryBirds", "1.2");
        phone.installAnApp("AngryBirds", "1.2", "www.wp.pl");
        ArrayList<String> appsNames = new ArrayList<>();
        appsNames.add("AngryDogs");
        appsNames.add("AngryCats");
        appsNames.add("AngryCows");
        phone.installAnApp(appsNames);
        try {
            URL url = new URL("https","www.onet.pl",443,"-AngryBirds.apk");
            phone.installAnApp(url);
        } catch (MalformedURLException e) {
            System.out.println("Cos poszło nie tak");
        }
        Car carElectric = new Electric("Tesla", "Elon", "123", 2022);
        Car carDiesel = new Diesel("Skoda", "Octavia", "213", 2000);
        Car carLpg = new LPG("Ford", "Mondeo", "321", 2010);
        carElectric.refuel();
        carDiesel.refuel();
        carLpg.refuel();
    }
}
