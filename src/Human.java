import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Human {
    public Animal pet;
    public Car car;
    private Double salary = 0.0;
    private String lastSalaryText = "";

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
}
