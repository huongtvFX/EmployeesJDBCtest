package data;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import dao.EmployeesDao;
import model.Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FakeData {
    public static void main(String[] args) {
        EmployeesDao employeesDao = new EmployeesDao();
        Faker faker = new Faker(new Locale("vi"));

        for (int i = 0; i<100;i++){
            Employees e = new Employees();
            e.setFull_name(faker.name().nameWithMiddle());
            e.setCity(faker.address().cityName());
            e.setEmail("sds" + faker.number().numberBetween(100,1000000) + "samsung" + faker.number().numberBetween(100,1000000) + "@gmail.com");
            e.setPhone(faker.phoneNumber().phoneNumber());
            e.setGender(faker.number().numberBetween(0,2));
            e.setSalary(faker.number().numberBetween(1000,2000));
            employeesDao.InsertEmp(e);
        }
        List<Employees> employeesList = employeesDao.getAll();
        for (Employees e : employeesList) {
            System.out.println(e.toString());
        }
    }
}
