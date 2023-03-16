package dao;

import connection.MyConnection;
import model.Employees;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {
    public List<Employees> getAll() {
        List<Employees> employeesList = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            final String sql = "SELECT * FROM employees";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employees e = new Employees();
                e.setId(resultSet.getInt("id"));
                e.setFull_name(resultSet.getString("full_name"));
                e.setCity(resultSet.getString("city"));
                e.setEmail(resultSet.getString("email"));
                e.setPhone(resultSet.getString("phone"));
                e.setGender(resultSet.getInt("gender"));
                e.setSalary(resultSet.getInt("salary"));
                employeesList.add(e);
            }
            resultSet.close();
            statement.close();
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return employeesList;
    }

    public void InsertEmp(Employees e) {
        try {
            Connection con = MyConnection.getConnection();
            String sql = String.format("INSERT INTO employees VALUES (NULL,'%s','%s','%s','%s','%d','%d')",
                    e.getFull_name(), e.getCity(), e.getEmail(), e.getPhone(), e.getGender(), e.getSalary()
            );
            Statement statement = con.createStatement();
            int resultSet = statement.executeUpdate(sql);

            if (resultSet == 0) {
                System.out.println("Thêm không thành công!");
            }else {
                System.out.println("Thêm thành công!");
            }
            statement.close();
            con.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
