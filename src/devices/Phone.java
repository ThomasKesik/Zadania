package devices;

import main.Human;

import java.net.URL;
import java.util.List;

public class Phone extends Device{

    public static final String DEFAULT_SERVER_ADDRESS = "www.address.com";
    public static final String DEFAULT_PROTOCOL = "TCP";
    public static final String DEFAULT_VERSION = "1.0";

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

    public void installAnApp(String appName){
        printInstallationText(appName, DEFAULT_VERSION, DEFAULT_SERVER_ADDRESS);
    }

    public void installAnApp(String appName, String version){
        printInstallationText(appName, version, DEFAULT_SERVER_ADDRESS);
    }

    public void installAnApp(String appName, String version, String server){
        printInstallationText(appName, version, server);
    }

    public void installAnApp(List<String> appsNames){
        for(String appName: appsNames){
            printInstallationText(appName, DEFAULT_VERSION, DEFAULT_SERVER_ADDRESS);
        }
    }

    public void installAnApp(URL url){
        System.out.println("Instaluje aplikacje za pomoca linku: " + url.toString());
    }

    public void printInstallationText(String appName, String version, String server){
        System.out.println("Instaluje aplikacje Nazwa: " + appName + " wersja: " + version + " serwer: " + server);
    }
}
