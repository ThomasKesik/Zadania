package main;

import devices.Car;
import devices.Phone;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Human {
    public Animal pet;
    private Car car;
    private Phone phone;
    private Double salary = 0.0;
    private String lastSalaryText = "";
    public Double cash = 0.0;

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

    public Car getCar(){
        return this.car;
    }

    public void setCar(Car car){
        if(car == null){
            this.car = null;
        }
        else if(salary > car.value){
            System.out.println("Twoje zarobki są wyższe niż wartość auta kupisz je za gotówkę");
            this.car = car;
        } else if(salary > (car.value/12)){
            System.out.println("Uda ci się kupić auto na kredyt (no trudno)");
            this.car = car;
        } else {
            System.out.println("Zapisz się na studia i znajdź nową robotę albo idź po podwyżkę");
        }
    }

    @Override
    public String toString() {
        return "main.Human{" +
                "pet=" + pet +
                ", car=" + car +
                ", salary=" + salary +
                ", lastSalaryText='" + lastSalaryText + '\'' +
                '}';
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
