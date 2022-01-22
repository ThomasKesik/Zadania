package main;

import creatures.Animal;
import devices.Car;
import devices.Phone;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Human {
    public Animal pet;
    private Car [] garage;
    private Phone phone;
    private Double salary = 0.0;
    private String lastSalaryText = "";
    public Double cash = 0.0;

    public Human() {
        this.garage = new Car[3];
    }

    public Human(Integer garageSize) {
        this.garage = new Car[garageSize];
    }

    public Double getSalary(){
        if(lastSalaryText.equals("")){
            System.out.println("Wartość wypłaty wyświetlana jest pierwszy raz " + salary);
        } else {
            System.out.println(lastSalaryText);
        }
        lastSalaryText = "Ostatni raz wypłata wyświetlana była " + getActualDate() + " jej wartość wynosiła " + salary;
        return salary;
    }

    private String getActualDate(){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(date);
    }

    public void setSalary(Double salary){
        if(salary < 0){
            System.out.println("Wartość wypłaty musi być większa równa 0 !!!");
        } else {
            System.out.println("Dane zostały wysłane do systemu księgowości !!!");
            System.out.println("Należy odebrać aneks do umowy u pani Hani z kadr !!!");
            System.out.println("ZUS i US wiedzą o wysokości twojej wypłaty nie ukrywaj jej !!! ");
            this.salary = salary;
        }
    }

    public Car getCar(int position){
        if(garage.length <= position){
            System.out.println("Nie ma takiego miejsca w garazu");
            return null;
        }
        Car car = this.garage[position];
        if(car != null){
            System.out.println("Auto: " + car);
        } else {
            System.out.println("To miejsce jest puste");
        }
        return car;
    }

    public void setCar(Car car, int position){
        if(position < 0 || garage.length <= position){
            System.out.println("Nie ma takiego miejsca w garazu");
        } else if(garage[position] != null){
            System.out.println("Na tym miejscu stoi juz auto");
        } else {
            this.garage[position] = car;
            if(car.transactionCount() == 0){
                car.addOwner(this);
            }
            System.out.println("Wstawiono auto " + car + " na pozycję " + position);
        }
    }


    public Double getCarsValue(){
        Double value = 0.0;
        for (Car car: this.garage){
            if(car != null && car.value != null){
                value += car.value;
            }
        }
        return value;
    }

    public void sortCars(){
        ArrayList<Car> sortedCars = new ArrayList<>();
        for(Car car: garage){
            if(car != null){
                sortedCars.add(car);
            }
        }
        sortedCars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return c1.yearOfProduction - c2.yearOfProduction;
            }
        });
        for (int i = 0; i < garage.length; i++){
            if(sortedCars.size() > i){
                garage[i] = sortedCars.get(i);
            } else {
                garage[i] = null;
            }
        }
    }

    public Car[] getGarage() {
        return garage;
    }

    @Override
    public String toString() {
        return "Human{" +
                "pet=" + pet +
                ", garage=" + Arrays.toString(garage) +
                ", phone=" + phone +
                ", salary=" + salary +
                ", lastSalaryText='" + lastSalaryText + '\'' +
                ", cash=" + cash +
                '}';
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
