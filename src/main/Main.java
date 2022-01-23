package main;

import devices.*;


public class Main {

    public static void main(String[] args) {
        Human human = new Human();
        Phone phone = new Phone("Samsung", "Galaxy", 2022);
        human.setPhone(phone);
        Application application1 = new Application("Saper", "1.0", 12.5);
        Application application2 = new Application("AngryBirds", "1.2", 1.0);
        Application application3 = new Application("Racer", "0.22", 0.0);
        Application application4 = new Application("BF2024", "1.0", 0.0);

        phone.installAnApp(human, application1);
        human.cash = 100.0;
        phone.installAnApp(human, application1);
        phone.installAnApp(human, application2);
        phone.installAnApp(human, application3);
        phone.installAnApp(human, application4);

        if(phone.isApplicationInstalled(application1)){
            System.out.println("Aplikacja " + application1 + " jest zainstalowana");
        }

        if(phone.isApplicationInstalled("Racer")){
            System.out.println("Aplikacja Racer jest zainstalowana");
        }

        phone.printFreeApps();
        System.out.println();
        System.out.println("Wartość zainstalowanych aplikacji: " + phone.getAppsValue());
        System.out.println();
        phone.printAppsSortedByNames();
        System.out.println();
        phone.printAppsSortedByPrice();
        
    }
}
