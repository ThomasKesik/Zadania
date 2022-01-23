package devices;

import main.Human;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Phone extends Device{

    public static final String DEFAULT_SERVER_ADDRESS = "www.address.com";
    public static final String DEFAULT_PROTOCOL = "TCP";
    public static final String DEFAULT_VERSION = "1.0";
    public ArrayList<Application> apps;

    public Phone(String producer, String model, Integer yearOfProduction) {
        super(producer, model, yearOfProduction);
        this.apps = new ArrayList<>();
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

    public void installAnApp(Human owner, Application application){
        if(owner.cash < application.getPrice()){
            System.out.println("Nie posiadasz wystarczajacej liczby pieniedzy");
            return;
        } else if(isApplicationInstalled(application)){
            System.out.println("Aplikacja jest już zainstalowana na telefonie");
            return;
        }
        this.apps.add(application);
        owner.cash -= application.getPrice();
    }

    public boolean isApplicationInstalled(Application application){
        if(apps.contains(application)){
            return true;
        }
        return false;
    }

    public boolean isApplicationInstalled(String appName){
        for(Application app: apps){
            if(app.getName().equals(appName)){
                return true;
            }
        }
        return false;
    }

    public void printFreeApps(){
        for(Application app: apps){
            if(app.getPrice() == 0.0){
                System.out.println(app.toString());
            }
        }
    }

    public Double getAppsValue(){
        Double value = 0.0;
        for(Application app: apps){
            value += app.getPrice();
        }
        return value;
    }

    public void printAppsSortedByNames(){
        ArrayList<Application> sortedApps = new ArrayList<>(apps);
        sortedApps.sort(new Comparator<Application>() {
            @Override
            public int compare(Application app1, Application app2) {
                return app1.getName().compareTo(app2.getName());
            }
        });
        for(Application app: sortedApps){
            System.out.println(app.getName());
        }
    }

    public void printAppsSortedByPrice(){
        ArrayList<Application> sortedApps = new ArrayList<>(apps);
        sortedApps.sort(new Comparator<Application>() {
            @Override
            public int compare(Application app1, Application app2) {
                return app1.getPrice().compareTo(app2.getPrice());
            }
        });
        for(Application app: sortedApps){
            System.out.println(app.getName());
        }
    }
}
